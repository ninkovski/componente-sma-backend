package gob.pe.mp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "email")
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class EmailProperties {

    private String uriApiEmail;

    private String idsistema;

    private String idusuario;

    @Value("${email.maquina.ip}")
    private String ip;

    @Value("${email.destinatario.tipo}")
    private String tipo;

    private String remitente;

    @Value("${email.remitente.nombre}")
    private String nombre;

    @Value("${email.remitente.clave}")
    private String clave;

    private String cuerpo;
}
