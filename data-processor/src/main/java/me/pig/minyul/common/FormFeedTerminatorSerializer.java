package me.pig.minyul.common;

import org.springframework.integration.ip.tcp.serializer.AbstractPooledBufferByteArraySerializer;
import org.springframework.integration.ip.tcp.serializer.SoftEndOfStreamException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FormFeedTerminatorSerializer extends AbstractPooledBufferByteArraySerializer {

    private static final byte[] FF = {(byte) 0xff};

    public static String byteArrayToHexaString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        for (byte data : bytes) {
            builder.append(String.format("%02X ", data));
        }

        return builder.toString();
    }


    public int fillToFf(InputStream inputStream, byte[] buffer) throws IOException {
        int n = 0;
        int bite;
        int available = inputStream.available();
        logger.debug(() -> "Available to read: " + available);
        try {
            while (true) {
                bite = inputStream.read();
                if (bite < 0 && n == 0) {
                    throw new SoftEndOfStreamException("Stream closed between payloads");
                }
                checkClosure(bite);
                if (n > 0 && bite == 0xff) {
                    buffer[n++] = (byte) bite;
                    break;
                }
                buffer[n++] = (byte) bite;
                if (n >= getMaxMessageSize()) {
                    logger.error("buffer String : " + new String(buffer));
                    logger.error("buffer hexString : " + byteArrayToHexaString(buffer));
                    throw new IOException("FF not found before max message length: " + getMaxMessageSize());
                }
            }
            return n;
        } catch (SoftEndOfStreamException e) {
            throw e;
        } catch (IOException | RuntimeException e) {
            publishEvent(e, buffer, n);
            throw e;
        }
    }

    @Override
    protected byte[] doDeserialize(InputStream inputStream, byte[] buffer) throws IOException {
        int n = fillToFf(inputStream, buffer);
        return copyToSizedArray(buffer, n);
    }

    @Override
    public void serialize(byte[] bytes, OutputStream outputStream) throws IOException {
        outputStream.write(bytes);
        outputStream.write(FF);

    }
}
