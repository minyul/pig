package me.minyul.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.codec.RedisCodec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Slf4j
@RequiredArgsConstructor
public class StringObjectRedisCodec implements RedisCodec<String, Object> {

    private final GenericJackson2JsonRedisSerializer serializer;

    public StringObjectRedisCodec(ObjectMapper objectMapper) {
        this.serializer = new GenericJackson2JsonRedisSerializer(objectMapper);
    }

    @Override
    public String decodeKey(ByteBuffer bytes) {
        return StandardCharsets.UTF_8
                .decode(bytes)
                .toString();
    }

    @Override
    public Object decodeValue(ByteBuffer bytes) {
        return serializer.deserialize(bytes.array());
    }

    @Override
    public ByteBuffer encodeKey(String key) {
        return StandardCharsets.UTF_8
                .encode(key);
    }

    @Override
    public ByteBuffer encodeValue(Object value) {
        return ByteBuffer.wrap(serializer.serialize(value));
    }
}