package gob.pe.mp.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemitenteRequest {
    private static int idEmailCounter = 1;
    private int id_email;
    private String email;
    private String nombre;
    private String clave;

    public RemitenteRequest() {
        id_email = idEmailCounter;
        idEmailCounter++;
    }
}

