package buchneva.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {
    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createDriver();
    }

    public void createDriver() {
        switch (config.getBrowser()) {
            case CHROME: {
                Configuration.browser = "CHROME";
                break;
            }
            case FIREFOX: {
                Configuration.browser = "FIREFOX";
                break;
            }
            case SAFARI: {
                Configuration.browser = "SAFARI";
                break;
            }
            case INTERNET_EXPLORER: {
                Configuration.browser = "INTERNET_EXPLORER";
                break;
            }
            case EDGE: {
                Configuration.browser = "EDGE";
                break;
            }
            default: {
                throw new RuntimeException(String.valueOf(config.getBrowser()));
            }
        }

        Configuration.baseUrl = config.getBaseURL();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemoteUrl();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }


}
