package gob.pe.mp.client;

import java.util.List;

public interface SendGridService {
    void sendText(String to, List<String> inCopy, String subject, String body);
    void sendHTML(String to, List<String> inCopy, String subject, String body);
}
