package javaMailUtil;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSendler {
    String host = "smtp.yandex.ru";
    String username = "nikjavastudy@yandex.ru";
    String password = "***************";
    Properties props = new Properties();

    public void sendMessage(String sendTo) throws MessagingException {
        props.setProperty("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        InternetAddress[] toAddresses = {new InternetAddress(sendTo)};
        message.setRecipients(Message.RecipientType.TO, toAddresses);
        Transport.send(message, username, password);


    }
}
