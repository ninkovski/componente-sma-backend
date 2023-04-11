package gob.pe.mp.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatariosRequest {

    private String id_email;
    private String email;
    private String nombre;
    private String tipo;

}
