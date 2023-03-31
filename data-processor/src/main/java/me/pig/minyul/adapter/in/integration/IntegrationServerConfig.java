package me.pig.minyul.adapter.in.integration;

import me.pig.minyul.config.TcpServerPortProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@Configuration
public class IntegrationServerConfig {

    private final TcpServerPortProperties serverPortProps;

    public IntegrationServerConfig(
            TcpServerPortProperties serverPortProps
    ) {
        this.serverPortProps = serverPortProps;
    }
}
