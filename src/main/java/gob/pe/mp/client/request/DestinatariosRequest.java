package gob.pe.mp.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatariosRequest {
    private static int idEmailCounter = 0;
    private String id_email;
    private String email;
    private String nombre;
    private String tipo;

    public void setId_email() {
        id_email = Integer.toString(idEmailCounter);
        idEmailCounter++;
    }

}
