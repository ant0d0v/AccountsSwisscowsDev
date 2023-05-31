package utils;
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

}
