package buchneva.web.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import buchneva.web.drivers.AuthConfig;
import buchneva.web.WebDriverProvider;
import buchneva.web.helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import buchneva.web.tests.pages.MainPage;
import buchneva.web.tests.pages.SearchPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @BeforeAll
    static void setUp() {
        WebDriverProvider provider = new WebDriverProvider();
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    @Step("Add attachments and close webDriver")
    public void afterTests() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.addVideo();
        closeWebDriver();
    }
}
