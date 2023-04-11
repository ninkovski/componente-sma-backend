package gob.pe.mp.client;


import gob.pe.mp.client.response.SendEmailResponse;

import java.util.List;

public interface EmailClientService {

    SendEmailResponse sendEmail(List<String> para, List<String> enCopia, String asunto, String body);
}