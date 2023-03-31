package me.pig.minyul.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@ConfigurationProperties("tcp.client.port")
@Configuration
public class TcpClientPortProperties {

    private String host;
    private ProductInfo stockA;
}
