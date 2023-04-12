package gob.pe.mp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "email")
@Getter
@Setter
public class EmailProperties {

    private String uriApiEmail;
    private String idsistema;
    private String idusuario;
    private String ip;
    private String tipo;
    private String remitente;
    private String nombre;
    private String clave;
}
