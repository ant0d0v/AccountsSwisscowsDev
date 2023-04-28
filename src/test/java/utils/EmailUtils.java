package utils;
import java.util.Properties;


public class EmailUtils {

    public static class PropertiesNewGmail {
        public final String host = "imap.gmail.com";
        public final String user = "a.udovychenko1203@gmail.com";
        public final String password = "efsbabphzkolqroa";
        final int port = 993;

        public Properties setServerProperties() {
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", port);
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.store.protocol", "imaps");
            return properties;
        }

    }

    public static class PropertiesGmail {
        public final String host = "imap.gmail.com";
        public final String user = "qaengineer1203@gmail.com";
        public final String password = "hmcmhkutozxsxdvq";
        final int port = 993;

        public Properties setServerProperties() {
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", port);
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.store.protocol", "imaps");
            return properties;
        }

    }

}
