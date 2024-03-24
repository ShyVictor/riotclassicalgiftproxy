package br.devshy.riotgiftproxy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration @Getter @Setter
@ConfigurationProperties(prefix = "hydra")
public class HydraAuthConfig {
    private String authkey;
    private String type;
}
