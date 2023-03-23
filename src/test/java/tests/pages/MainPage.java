package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.domain.HeaderMainMenu;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

    private SelenideElement labirintLogo = $(".b-header-b-logo-e-logo"),
            menuMore = $("[data-toggle='header-more']"),
            personalCabinet = $(".b-header-b-personal-e-list-item_cabinet"),
            loginField = $("[autocomplete='code tel email phone phones telephone mail']"),
            loginButton = $("#g-recap-0-btn"),
            successLogin = $("#auth-success-login"),
            unsuccessLogin = $(".full-input__msg-small.js-msg-small"),
            searchField = $("#search-field"),
            searchButton = $(".b-header-b-search-e-btn"),
            cookiesButton = $(".cookie-policy__button");

    private ElementsCollection headerMenu = $$("li.b-header-b-menu-e-list-item"),
            secondMenu = $$(".b-menu-second-container li");

    //todo добавить куда-то этот метод
    public MainPage cookiesAccept() {
        cookiesButton.click();
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        open("/");
        cookiesButton.click();
        return this;
    }

    @Step("Click on Labirint logo")
    public MainPage clickOnLabirintLogo() {
        labirintLogo.click();
        return this;
    }

    @Step("Check that page {0} opening")
    //todo передать сюда урл как параметр
    public MainPage checkPageIsOpening(String url) {
        webdriver().shouldHave(url("https://www.labirint.ru" + url));
        return this;
    }

    @Step("Open header main menu item {0}")
    public MainPage openHeaderMenu(HeaderMainMenu headerMainMenu) {
        headerMenu.find(text(headerMainMenu.name)).click();
        return this;
    }

    @Step("Open second header menu item {0}")
    public MainPage openSecondHeaderMenu(String name) {
        menuMore.hover();
        secondMenu.find(text(name)).click();
        return this;
    }

    @Step("Open login dialog")
    public MainPage openLoginDialog() {
        personalCabinet.click();
        return this;
    }

    @Step("Enter authorization code")
    public MainPage enterAuthorizationCode(String code) {
        loginField.setValue(code);
        loginButton.click();
        return this;
    }

    @Step ("Check authorization error message")
    public MainPage checkErrorAuthorizationResult(String expectedErrorMessage) {
        unsuccessLogin.shouldHave(exactText(expectedErrorMessage));
        return this;
    }

    @Step ("Check the massage about successful authorization")
    public MainPage checkSuccessAuthorizationResult(String expectedMessage) {
        successLogin.shouldHave(text(expectedMessage));
        return this;
    }

    @Step ("Perform search for {0}")
    public MainPage fillSearchField(String request) {
        searchField.setValue(request);
        searchButton.click();
        return this;
    }
}
