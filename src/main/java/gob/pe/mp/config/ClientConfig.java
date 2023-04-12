
package gob.pe.mp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {


    @Bean
    public RestTemplate restTemplateConfigurer() {
        return new RestTemplate();
    }

}
