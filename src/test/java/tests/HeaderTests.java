package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import tests.domain.HeaderMainMenu;
import tests.domain.HeaderSecondMenu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HeaderTests extends TestBase {

    @Test
    void clickOnHeaderLogoReturnOnMainPageTest() {
        $(".b-header-b-logo-e-logo").click();
        webdriver().shouldHave(url("https://www.labirint.ru" + "/"));
    }

    @EnumSource(HeaderMainMenu.class)
    @ParameterizedTest
    void checkListOfHeaderMenuItemsTest(HeaderMainMenu headerMainMenu) {
        $$("li.b-header-b-menu-e-list-item").find(text(headerMainMenu.name)).click();
        webdriver().shouldHave(url("https://www.labirint.ru" + headerMainMenu.link));
    }

//    @EnumSource(HeaderSecondMenu.class)
//    @ParameterizedTest
//    void checkListOfSecondHeaderMenuItemsTest(HeaderSecondMenu headerSecondMenu) {
//        $("[data-toggle='header-more']").hover();
//        $$(".b-menu-second-container li").find(text(headerSecondMenu.name)).click();
//        webdriver().shouldHave(url("https://www.labirint.ru" + headerSecondMenu.link));
//    }

    @CsvSource(value = {
            "CD/DVD, /multimedia/",
            "Сувениры, /souvenir/",
            "Журналы, /journals/",
            "Товары для дома, /household/"
    })
    @ParameterizedTest
    void checkListOfSecondHeaderMenuItemsTest1(String name, String url) {
        $("[data-toggle='header-more']").hover();
        $$(".b-menu-second-container li").find(text(name)).click();
        webdriver().shouldHave(url("https://www.labirint.ru" + url));
    }
}
