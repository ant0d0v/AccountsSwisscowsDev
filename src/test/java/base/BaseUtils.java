package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public final class BaseUtils {

    static final String PREFIX_PROP = "default.";
    static final String PREFIX_PATH = "pdf/";
    private static final String ENV_CHROME_OPTIONS = "CHROME_OPTIONS";
    private static final String PROP_CHROME_OPTIONS = PREFIX_PROP + ENV_CHROME_OPTIONS.toLowerCase();
    private static ChromeOptions chromeOptions;
    private static Properties properties;

    static {
        initProperties();

        chromeOptions = new ChromeOptions();

        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
                chromeOptions.addArguments("--remote-allow-origins=*");
                File pdfFile = new File(PREFIX_PATH);
                String downloadDirectory = pdfFile.getAbsolutePath();
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", downloadDirectory);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
               // chromeOptions.addArguments("--load-extension=/Users/antonudovycenko/IdeaProjects/AccountsSwisscowsDev/target/swisscows.search.chrome");



            }
        }

        WebDriverManager.chromedriver().setup();
    }

    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();
            if (isServerRun()) {
                properties.setProperty(PROP_CHROME_OPTIONS, System.getenv(ENV_CHROME_OPTIONS));
            } else {
                try {
                    InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("local.properties");
                    if (inputStream == null) {
                        System.out.println("ERROR: The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                        System.out.println("You need to create it from local.properties.TEMPLATE file.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException ignore) {
                }
            }
        }
    }

    static Properties getProperties() {
        return properties;
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
    static void captureScreenFile(WebDriver driver, String methodName, String className) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(String.format("screenshots/%s-%s.png", className, methodName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void logf(String str, Object... arr) {
        System.out.printf(str, arr);
        System.out.println();
    }


}