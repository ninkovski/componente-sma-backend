package gob.pe.mp.service;

import gob.pe.mp.api.NotificacionesApiDelegate;
import gob.pe.mp.client.EmailClientService;
import gob.pe.mp.client.SendGridService;
import gob.pe.mp.client.TwilioService;
import gob.pe.mp.config.EmailProperties;
import gob.pe.mp.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class NotificacionService implements NotificacionesApiDelegate {

    @Autowired
    private EmailClientService emailClientService;

    @Autowired
    private EmailProperties emailProperties;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private TwilioService twilioService;

    @Override
    public ResponseEntity<EnviarEmailResponse> enviarEmail(EnviarEmailMRequest request) {
//        String body = getBody(request);
        String body = enviarMensajeSrFiscal(request);

        emailClientService.sendEmail(
                request.getPara(),
                request.getEnCopia(),
                request.getAsunto(),
                body
        );

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        EnviarEmailResponse response = new EnviarEmailResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnviarSmsResponse> enviarSms(EnviarSmsRequest request) {
        request.getPara().forEach(para -> {
            String templateMessage = "SR FISCAL:\nLa mujer identificada como " +
                    request.getNombreAgraviada() + " con DNI° " + request.getNumeroDocAgraviada() +
                    ", presenta tres denuncias con el SR. " + request.getNombreAgraviante() + " con DNI° " +
                    request.getNumeroDocAgraviante() + " en la Fiscalía " + request.getNombreFiscalia() + ".";

            try {
                twilioService.sendSms(para, templateMessage);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        });

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        EnviarSmsResponse response = new EnviarSmsResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnviarWhatsappResponse> enviarWhatsapp(EnviarWhatsappRequest request) {
        request.getPara().forEach(para -> {
            String templateMessage = "SR FISCAL:\nLa mujer identificada como " +
                    request.getNombreAgraviada() + " con DNI° " + request.getNumeroDocAgraviada() +
                    ", presenta tres denuncias con el SR. " + request.getNombreAgraviante() + " con DNI° " +
                    request.getNumeroDocAgraviante() + " en la Fiscalía " + request.getNombreFiscalia() + ".";

            twilioService.sendWhatsapp(para, templateMessage);
        });

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        EnviarWhatsappResponse response = new EnviarWhatsappResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private String getBody(EnviarEmailMRequest request) {
        Map<String, String> mapaValoresPlantilla = new HashMap<>();
        mapaValoresPlantilla.put("nombreAgraviada", request.getNombreAgraviada());
        mapaValoresPlantilla.put("numeroDocAgraviada", request.getNumeroDocAgraviada());
        mapaValoresPlantilla.put("nombreAgraviante", request.getNombreAgraviante());
        mapaValoresPlantilla.put("numeroDocAgraviante", request.getNumeroDocAgraviante());
        mapaValoresPlantilla.put("nombreFiscalia", request.getNombreFiscalia());

        return VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine,
                "template/email.template",
                "UTF-8",
                mapaValoresPlantilla
        );
    }

    private String enviarMensajeSrFiscal(EnviarEmailMRequest request) {
        return String.format(emailProperties.getMensaje(),
                request.getNombreAgraviada(), request.getNumeroDocAgraviada(),
                request.getNombreAgraviante(), request.getNumeroDocAgraviante(),
                request.getNombreFiscalia());
    }

}
