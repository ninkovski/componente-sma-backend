package gob.pe.mp.client.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailResponse {

    private Boolean estado;
    private String codigo;
    private Integer id;
    private String mensaje;

}
