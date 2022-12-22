package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationTest extends TestBase {



    // email - nayer15345@lubde.com
    //code - A655-4264-B301
    @Test
    void successfulAuthorizationTest() {
        $(".b-header-b-personal-e-list-item_cabinet").click();
        $("[autocomplete='code tel email phone phones telephone mail']").setValue("A655-4264-B301");
        $("#g-recap-0-btn").click();
        $("#auth-success-login").shouldHave(text("Здравствуйте"));
    }

    // email - nayer15345@lubde.com
    //code - A655-4264-B301
    @Test
    void unsuccessfulAuthorizationTest() {
        $(".b-header-b-personal-e-list-item_cabinet").click();
        $("[autocomplete='code tel email phone phones telephone mail']").setValue("A655-4264-B3012");
        $("#g-recap-0-btn").click();
        $(".full-input__msg-small.js-msg-small").shouldHave(exactText("Введенного кода не существует"));
    }
}
