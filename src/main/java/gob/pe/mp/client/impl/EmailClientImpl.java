package gob.pe.mp.client.impl;

import gob.pe.mp.client.EmailClientService;
import gob.pe.mp.client.request.DestinatariosRequest;
import gob.pe.mp.client.request.RemitenteRequest;
import gob.pe.mp.client.request.SendEmailRequest;
import gob.pe.mp.client.response.SendEmailResponse;
import gob.pe.mp.config.EmailProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmailClientImpl implements EmailClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmailProperties emailProperties;

    @Override
    public SendEmailResponse sendEmail(List<String> para, List<String> enCopia, String asunto, String body) {
        String url = emailProperties.getUriapiemail();

        log.info("Estableciendo comunicación ({}) enviarEmail: ", url);

        List<DestinatariosRequest> destinatariosRequests = new ArrayList<>();

        for (String destino : para) {
            DestinatariosRequest destinatariosRequest = new DestinatariosRequest();
            destinatariosRequest.setEmail(destino);
            destinatariosRequest.setNombre("");
            destinatariosRequest.setTipo(emailProperties.getDestinatarioTipo());
            destinatariosRequests.add(destinatariosRequest);
        }

        RemitenteRequest remitenteRequest = new RemitenteRequest();
        remitenteRequest.setEmail(emailProperties.getRemitenteEmail());
        remitenteRequest.setNombre(emailProperties.getRemitenteNombre());
        remitenteRequest.setClave(emailProperties.getRemitenteClave());

        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.setIdsistema(emailProperties.getIdsistema());
        emailRequest.setIdusuario(emailProperties.getIdusuario());
        emailRequest.setIp(emailProperties.getMaquinaIp());
        emailRequest.setRemitente(remitenteRequest);
        emailRequest.setAsunto(asunto);
        emailRequest.setDestinatarios(destinatariosRequests);
        emailRequest.setCuerpo(body);

        HttpEntity<SendEmailRequest> request = new HttpEntity<>(emailRequest);

        ResponseEntity<SendEmailResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, SendEmailResponse.class);

        log.info("Terminando la comunicación ({}) enviarEmail, response: {}", url, response != null ? response.getBody() : null);

        return response.getBody();
    }

}
