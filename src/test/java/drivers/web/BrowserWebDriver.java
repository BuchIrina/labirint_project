package drivers.web;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserWebDriver {

    public static void configuration() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        String browserName = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browser_size", "1900x1080");
        String browserVersion = System.getProperty("browser_version", "100");
        String remote = System.getProperty("remote");
        if (remote != null) {
            Configuration.remote = remote;
        }
    }
}
