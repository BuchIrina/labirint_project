package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement searchResult = $(".index-top-title"),
            searchError = $(".search-error");

    public SearchPage checkSearchResult(String response) {
        searchResult.shouldHave(text(response));
        return this;
    }

    public SearchPage searchErrorResponse(String errorMessage) {
        searchError.shouldHave(text(errorMessage));
        return this;
    }
}
