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

    private String uriapiemail;

    private String idsistema;

    private String idusuario;

    @Value("${email.maquina.ip}")
    private String maquinaIp;

    @Value("${email.destinatario.tipo}")
    private String destinatarioTipo;

    @Value("${email.remitente.email}")
    private String remitenteEmail;

    @Value("${email.remitente.nombre}")
    private String remitenteNombre;

    @Value("${email.remitente.clave}")
    private String remitenteClave;

    private String mensaje;
}
