package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void openMainPage() {
        open("https://www.labirint.ru");
    }
}
