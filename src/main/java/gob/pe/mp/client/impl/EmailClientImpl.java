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
        String url = emailProperties.getUriApiEmail();

        log.info("Establishing communication ({}) sendEmail: ", url);

        List<RemitenteRequest> remitentesRequests = new ArrayList<>();

        for (String remite : para) {
            RemitenteRequest remitenteRequest = new RemitenteRequest();
            remitenteRequest.setId_email(remite);
            remitenteRequest.setEmail(remite);
            remitenteRequest.setNombre(remite);
            remitenteRequest.setClave(remite);
            remitentesRequests.add(remitenteRequest);
        }

        List<DestinatariosRequest> destinatariosRequests = new ArrayList<>();

        for (String destino : enCopia) {
            DestinatariosRequest destinatariosRequest = new DestinatariosRequest();
            destinatariosRequest.setId_email(destino);
            destinatariosRequest.setEmail(destino);
            destinatariosRequest.setNombre(destino);
            destinatariosRequest.setTipo(destino);
            destinatariosRequests.add(destinatariosRequest);
        }

        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.setIdsistema(emailProperties.getIdsistema());
        emailRequest.setIdusuario(emailProperties.getIdusuario());
        emailRequest.setIp(emailProperties.getIp());
        emailRequest.setRemitente((RemitenteRequest) remitentesRequests);
        emailRequest.setAsunto(asunto);
        emailRequest.setDestinatarios(destinatariosRequests);
        emailRequest.setCuerpo(body);

        HttpEntity<SendEmailRequest> request = new HttpEntity<>(emailRequest);

        ResponseEntity<SendEmailResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, SendEmailResponse.class);

        log.info("Finishing communication ({}) sendSms, response: {}", url, response != null ? response.getBody() : null);

        return response.getBody();
    }

}
