package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Feature("Search")
@Owner("buchnevaia")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Response message to incorrect search query")
    void searchWithIncorrectQueryTest() {
        mainPage.fillSearchField("The Story of Verona");
        searchPage.searchErrorResponse("Мы ничего не нашли по вашему запросу! Что делать?");
    }

    @CsvSource(value = {
            "Достоевский | «Достоевский»",
            "Над пропастью во ржи | «Над пропастью во ржи»",
            "Комиксы | «Комиксы»",
            "Bridget Jones's diary | «Bridget Jones's diary»"
    }, delimiter = '|')
    @ParameterizedTest
    @DisplayName("Response message to valid search query {0}")
    void searchWithDifferentQueriesTest(String request, String response) {
        mainPage.fillSearchField(request);
        searchPage.checkSearchResult(response);
    }
}
