package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import tests.domain.HeaderMainMenu;

@Feature("Header menu")
@Owner("buchnevaia")
public class HeaderTests extends TestBase {

    @DisplayName("Main page open by click on logo")
    @Test
    void clickOnHeaderLogoReturnOnMainPageTest() {
        mainPage.openPage();
        mainPage.clickOnLabirintLogo()
                .checkPageIsOpening("/");
    }

    @EnumSource(HeaderMainMenu.class)
    @ParameterizedTest
    @DisplayName("Each header menu item opens on new page")
    void checkListOfHeaderMenuItemsTest(HeaderMainMenu headerMainMenu) {
        mainPage.openPage();
        mainPage.openHeaderMenu(headerMainMenu)
                .checkPageIsOpening(headerMainMenu.link);
    }

    @CsvSource(value = {
            "CD/DVD, /multimedia/",
            "Сувениры, /souvenir/",
            "Журналы, /journals/",
            "Товары для дома, /household/"
    })
    @ParameterizedTest
    @DisplayName("Each item of More menu opens on new page")
    void checkListOfSecondHeaderMenuItemsTest1(String name, String url) {
        mainPage.openPage();
        mainPage.openSecondHeaderMenu(name)
                .checkPageIsOpening(url);
    }
}
