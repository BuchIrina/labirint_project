package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.web.WebDriverProvider;
import helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.pages.MainPage;
import tests.pages.SearchPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @BeforeAll
    static void setUp() {
        WebDriverProvider provider = new WebDriverProvider();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

//    @BeforeEach
//    @Step("Open the browser")
//    public void openMainPage() {
//        open("https://www.labirint.ru");
//    }

    @AfterEach
    @Step("Add attachments and close webDriver")
    public void afterTests() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.addVideo();
        closeWebDriver();
    }
}
