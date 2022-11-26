package gob.pe.mp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sendgrid")
@Getter
@Setter
public class SendGridConfig {

    private String token;
    private String mailfrom;
}
