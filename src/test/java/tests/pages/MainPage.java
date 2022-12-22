package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
            searchButton = $(".b-header-b-search-e-btn");

    private ElementsCollection headerMenu = $$("li.b-header-b-menu-e-list-item"),
            secondMenu = $$(".b-menu-second-container li");

    public MainPage clickOnLabirintLogo() {
        labirintLogo.click();
        return this;
    }

 //todo передать сюда урл как параметр
    public MainPage checkPageIsOpening(String url) {
        webdriver().shouldHave(url("https://www.labirint.ru" + url));
        return this;
    }

    public MainPage openHeaderMenu(HeaderMainMenu headerMainMenu) {
        headerMenu.find(text(headerMainMenu.name)).click();
        return this;
    }

    public MainPage openSecondHeaderMenu(String name) {
        menuMore.hover();
        secondMenu.find(text(name)).click();
        return this;
    }

    public MainPage openLoginDialog() {
        personalCabinet.click();
        return this;
    }

    public MainPage fillCodeForAuthorization(String code) {
        loginField.setValue(code);
        loginButton.click();
        return this;
    }

    public MainPage checkErrorAuthorizationResult(String expectedErrorMessage) {
        unsuccessLogin.shouldHave(text(expectedErrorMessage));
        return this;
    }

    public MainPage checkSuccessAuthorizationResult(String expectedMessage) {
        successLogin.shouldHave(exactText(expectedMessage));
        return this;
    }

    public MainPage fillSearchField(String searchQuery) {
        searchField.setValue(searchQuery);
        searchButton.click();
        return this;
    }
}
