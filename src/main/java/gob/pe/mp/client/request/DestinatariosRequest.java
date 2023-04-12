package gob.pe.mp.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatariosRequest {
    private static int idEmailCounter = 1;
    private int id_email;
    private String email;
    private String nombre;
    private String tipo;

    public DestinatariosRequest() {
        id_email = idEmailCounter;
        idEmailCounter++;
    }
}
