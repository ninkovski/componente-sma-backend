package gob.pe.mp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Getter
@Setter
public class TwilioConfig {

    private String sid;
    private String token;

    @Value("${twilio.phone.sms.from}")
    private String phoneSmsFrom;

    @Value("${twilio.phone.whatsapp.from}")
    private String phoneWhatsappFrom;
}
