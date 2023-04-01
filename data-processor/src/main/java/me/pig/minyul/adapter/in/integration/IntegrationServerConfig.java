package me.pig.minyul.adapter.in.integration;

import me.pig.minyul.application.transformer.MessageTransformer;
import me.pig.minyul.config.TcpServerPortProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;
import org.springframework.messaging.Message;

@IntegrationComponentScan(basePackages = "me.pig.minyul.adapter.in.web")
@EnableIntegration
@Configuration
public class IntegrationServerConfig {

    private final TcpServerPortProperties serverPortProps;
    private final MessageTransformer messageTransformer;

    public IntegrationServerConfig(
            TcpServerPortProperties serverPortProps,
            MessageTransformer messageTransformer
    ) {
        this.serverPortProps = serverPortProps;
        this.messageTransformer = messageTransformer;
    }

    @Bean
    public IntegrationFlow stockRequestInputChannel() {
        return IntegrationFlows.from(Tcp.inboundGateway(Tcp.nioServer(serverPortProps.getStockA().getIndex())
                        .deserializer(TcpCodecs.crlf())
                        .get()))
                .transform(Transformers.objectToString())
                .transform(this.messageTransformer)
                .get();
    }
}
