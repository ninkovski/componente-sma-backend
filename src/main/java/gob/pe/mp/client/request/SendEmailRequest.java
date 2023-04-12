package gob.pe.mp.client.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendEmailRequest {

    private static int idUsuarioCounter = 0;
    private String idsistema;
    private String idusuario;
    private String ip;
    private RemitenteRequest remitente;
    private String asunto;
    private List<DestinatariosRequest> destinatarios;
    private String cuerpo;

    public void setIdusuario() {
        idusuario = Integer.toString(idUsuarioCounter);
        idUsuarioCounter++;
    }

//    @Override
//    public String toString(){
//        return "NotificationResponse{" +
//                "id del sistema='" + idsistema + '\'' +
//                ", id del usuario='" + idusuario + '\'' +
//                ", ip de maquina='" + ip + '\'' +
//                ", remitente='" + remitente + '\'' +
//                ", asunto='" + asunto + '\'' +
//                ", destinatarios='" + destinatarios + '\'' +
//                ", cuerpo='" + cuerpo + '\'' +
//                '}';
//    }
}
