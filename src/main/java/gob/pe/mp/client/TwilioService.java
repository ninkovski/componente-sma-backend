package gob.pe.mp.client;

public interface TwilioService {
    void sendSms(String to, String message);
    void sendWhatsapp(String to, String message);
}
