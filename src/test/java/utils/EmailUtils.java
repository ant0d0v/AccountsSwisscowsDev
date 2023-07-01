package utils;
import javax.mail.Folder;
import javax.mail.MessagingException;
import java.util.Properties;


public class EmailUtils {
    private  static Properties properties;
    public final static String HOST = "imap.gmail.com";
    public final static String PASSWORD_NEW_GMAIL = "efsbabphzkolqroa";
    public final static String NEW_GMAIL_USER = ProjectConstants.NEW_GMAIL_USER ;
    public final static String GMAIL_USER = ProjectConstants.GMAIL_USER;
    public final static String PASSWORD_GMAIL = "hmcmhkutozxsxdvq";
    public static int port = 993;

    public static Properties setServerProperties() {
        properties = new Properties();
        properties.put("mail.imap.host", HOST);
        properties.put("mail.imap.port", port);
        properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.store.protocol", "imaps");
        return properties;
    }
    public static  int waitForNewMessage(Folder folder, int initialCount) throws MessagingException, InterruptedException {
        int currentCount = initialCount;
        int maxRetries = 2;
        int retryDelayMillis = 5000;

        for (int i = 0; i < maxRetries; i++) {
            Thread.sleep(retryDelayMillis);

            folder.close(false);
            folder.open(Folder.READ_ONLY);

            int newCount = folder.getMessageCount();

            if (newCount > currentCount) {
                return newCount;
            }
            currentCount = newCount;
        }

        return currentCount;
    }

}
