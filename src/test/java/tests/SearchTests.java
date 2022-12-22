package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchTests extends TestBase {

    @Test
    void searchWithIncorrectQueryTest() {
        $("#search-field").setValue("The Story of Verona");
        $(".b-header-b-search-e-btn").click();
        $(".search-error").shouldHave(text("Мы ничего не нашли по вашему запросу! Что делать?"));
    }

    //Достоевский Над пропастью во ржи Комиксы Bridget Jones's diary Ljcnjtdcrbq
    @CsvSource(value = {
            "Достоевский | «Достоевский»",
            "Над пропастью во ржи | «Над пропастью во ржи»",
            "Комиксы | «Комиксы»",
            "Bridget Jones's diary | «Bridget Jones's diary»",
            "Ljcnjtdcrbq | «Достоевский»"
    }, delimiter = '|')
    @ParameterizedTest
    void searchWithDifferentQueriesTest(String request, String response) {
        $("#search-field").setValue(request);
        $(".b-header-b-search-e-btn").click();
        $(".index-top-title").shouldHave(text(response));
    }
}
