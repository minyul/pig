package me.pig.minyul.adapter.in.integration;

import me.pig.minyul.application.transformer.MessageTransformer;
import me.pig.minyul.config.TcpServerPortProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;

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
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows.from(Tcp.inboundGateway(Tcp.nioServer(serverPortProps.getStockA().getIndex())
                        .deserializer(TcpCodecs.crlf())
                        .get()))
                .transform(Transformers.objectToString())
                .transform(this.messageTransformer)
                .get();
    }
}
