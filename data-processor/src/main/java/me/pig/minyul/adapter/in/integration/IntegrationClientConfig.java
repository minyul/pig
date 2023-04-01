package me.pig.minyul.adapter.in.integration;

import lombok.extern.slf4j.Slf4j;
import me.pig.minyul.common.FormFeedTerminatorSerializer;
import me.pig.minyul.config.TcpClientPortProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.messaging.Message;

@Slf4j
@EnableIntegration
@Configuration
public class IntegrationClientConfig {

    public FormFeedTerminatorSerializer codec() {
        FormFeedTerminatorSerializer serializer = new FormFeedTerminatorSerializer();
        serializer.setPoolSize(10);
        serializer.setMaxMessageSize(10_000);
        return serializer;
    }

    private final TcpClientPortProperties clientPortProps;

    public IntegrationClientConfig(
            TcpClientPortProperties clientPortProps) {
        this.clientPortProps = clientPortProps;
    }

    @Bean
    public IntegrationFlow stockRequestInputChannel_Client() {
        return f -> f.handle(
                Tcp.outboundGateway(Tcp.nioClient(this.clientPortProps.getHost(), this.clientPortProps.getStockA().getIndex())
                        .deserializer(codec())
                        .get()))
                .log(LoggingHandler.Level.INFO, "stock : ", Message::getPayload)
                .transform(Transformers.objectToString());
    }
}
