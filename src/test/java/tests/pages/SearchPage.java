package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement searchResult = $(".index-top-title"),
            searchError = $(".search-error");

    @Step ("Check item {0} exists in the search result")
    public SearchPage checkSearchResult(String response) {
        searchResult.shouldHave(text(response));
        return this;
    }

    @Step ("Check message for non-existent item")
    public SearchPage searchErrorResponse(String errorMessage) {
        searchError.shouldHave(text(errorMessage));
        return this;
    }
}
