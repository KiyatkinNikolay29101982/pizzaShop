package javaMailUtil;


import javax.mail.*;
import java.util.Properties;

public class MailReader {
    String host = "imap.yandex.ru";
    String username = "nikjavastudy@yandex.ru";
    String password = "mlgpdqggjigusvbu";
    Properties props;

    private static String parseAddresses(Address[] addresses){
        String listAddress = "";
        if(addresses!=null)
            for(int i = 0; i < addresses.length; i ++){
                listAddress = addresses[i].toString() + ", ";

            }
        if(listAddress.length() > 1){
            listAddress = listAddress.substring(0, listAddress.length() - 2);
        }
        return listAddress;
    }

    public void read() throws MessagingException {
        props.setProperty("mail.imap.ssl.enable", "true");
        // set any other needed mail.imap.* properties here
        Session session = Session.getInstance(props);
        Store store = session.getStore("imap");
        store.connect(host, username, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        System.out.println("количество сообщений " + folder.getNewMessageCount());
        Message[] messages = folder.getMessages();
        for(int i = 0; i < messages.length; i ++){
            Message msg = messages[i];
            Address[] addresses = msg.getFrom();
            String from = addresses[0].toString();
            String subject = msg.getSubject();
            String toList = parseAddresses(msg.getRecipients(Message.RecipientType.TO));
            String ccList = parseAddresses(msg.getRecipients(Message.RecipientType.CC));
            String sentDate = msg.getSentDate().toString();
            String contentType = msg.getContentType();
            String msgContent ="";

            if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                try {
                    Object content = msg.getContent();
                    if (content != null) {
                        msgContent = content.toString();
                    }
                } catch (Exception ex) {
                    msgContent = "[Error downloading content]";
                    ex.printStackTrace();
                }
            }

            // print out details of each message
            System.out.println("Message #" + (i + 1) + ":");
            System.out.println("\t From: " + from);
            System.out.println("\t To: " + toList);
            System.out.println("\t CC: " + ccList);
            System.out.println("\t Subject: " + subject);
            System.out.println("\t Sent Date: " + sentDate);
            System.out.println("\t Message: " + msgContent);
        }

        // disconnect
        folder.close(false);
        store.close();
    }

}
