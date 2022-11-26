package gob.pe.mp.client.impl;

import com.sendgrid.*;
import gob.pe.mp.client.SendGridService;
import gob.pe.mp.config.SendGridConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SendGridServiceImpl implements SendGridService {

    private SendGrid sendGridClient;

    //@Value("${sendgrid.mail.from}")
    //private String sendGridMailFrom;

    private SendGridConfig sendGridConfig;

    //public SendGridServiceImpl(@Value("${sendgrid.token}") String sendGridToken) {

    @Autowired
    public SendGridServiceImpl(SendGridConfig sendGridConfig) {
        //this.sendGridClient = new SendGrid(sendGridToken);
        this.sendGridConfig = sendGridConfig;
        this.sendGridClient = new SendGrid(sendGridConfig.getToken());
    }

    @Override
    public void sendText(String to, List<String> inCopy, String subject, String body) {
        Response response = sendEmail(to, inCopy, subject, new Content("text/plain", body));
        log.info("Finish to send mail to {}", to);
        log.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: " + response.getHeaders());
    }
    @Override
    public void sendHTML(String to, List<String> inCopy, String subject, String body) {
        Response response = sendEmail(to, inCopy, subject, new Content("text/html", body));
        log.info("Finish to send mail to {}", to);
        log.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: " + response.getHeaders());
    }

    private Response sendEmail(String to, List<String> inCopy, String subject, Content content) {
        log.info("Start to send mail to {}", to);

        Mail mail = new Mail();
        //mail.setFrom(new Email(sendGridMailFrom));
        mail.setFrom(new Email(sendGridConfig.getMailfrom()));
        mail.setSubject(subject);
        mail.addContent(content);
        mail.addPersonalization(completeToAndInCopy(to, inCopy));

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            return sendGridClient.api(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return new Response();
    }

    private Personalization completeToAndInCopy(String to, List<String> inCopy) {
        Personalization personalization = new Personalization();
        personalization.addTo(new Email(to));

        if (inCopy != null && !inCopy.isEmpty()) {
            inCopy.forEach(s -> personalization.addCc(new Email(s)));
        }

        return personalization;
    }

}
