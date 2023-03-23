package drivers.web;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browser_${run}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.labirint.ru")
    String getBaseURL();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();


    @Key("browser.size")
    @DefaultValue("1900x1080")
    String getBrowserSize();


    @Key("browser.version")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();
}
