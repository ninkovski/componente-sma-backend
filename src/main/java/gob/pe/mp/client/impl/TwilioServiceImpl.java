package gob.pe.mp.client.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import gob.pe.mp.client.TwilioService;
import gob.pe.mp.config.TokensConfigEnum;
import gob.pe.mp.config.TwilioConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwilioServiceImpl implements TwilioService {

    /*@Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.token}")
    private String twilioToken;

    @Value("${twilio.phone.sms.from}")
    private String twilioPhoneSmsFrom;

    @Value("${twilio.phone.whatsapp.from}")
    private String twilioPhoneWhatsappFrom;*/

    @Autowired
    private TwilioConfig twilioConfig;

    @Override
    public void sendSms(String to, String message) {
        log.info("Start to send sms to {}", to);

        //Twilio.init(twilioSid, twilioToken);
        TokensConfigEnum tokensConfigEnum = TokensConfigEnum.getTokenConfigEnum(to);
        Twilio.init(tokensConfigEnum.getSid(), tokensConfigEnum.getToken());

        Message messageSent = Message.creator(
                new PhoneNumber("+51" + to),
                //new PhoneNumber(twilioPhoneSmsFrom),
                new PhoneNumber(tokensConfigEnum.getNumeroFrom()),
                message
        ).create();

        log.info("Finish to send sms to {}", to);
        log.info(messageSent.getSid());
    }

    @Override
    public void sendWhatsapp(String to, String message) {
        log.info("Start to send whatsapp to {}", to);

        //Twilio.init(twilioSid, twilioToken);
        TokensConfigEnum tokensConfigEnum = TokensConfigEnum.getTokenConfigEnum(to);
        Twilio.init(tokensConfigEnum.getSid(), tokensConfigEnum.getToken());

        Message messageSent = Message.creator(
                new PhoneNumber("whatsapp:" + "+51" + to),
                //new PhoneNumber("whatsapp:" + twilioPhoneWhatsappFrom),
                new PhoneNumber("whatsapp:" + tokensConfigEnum.getNumeroFromWhatsapp()),
                message
        ).create();

        log.info("Finish to send whatsapp to {}", to);
        log.info(messageSent.getSid());
    }

}
