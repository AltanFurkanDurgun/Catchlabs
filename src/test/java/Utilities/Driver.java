package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {

        if (driver == null) {

            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    chromeOptions.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.setExperimentalOption("prefs",prefs);
                    chromeOptions.addArguments("start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
            }

        }

        return driver;


    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
