package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Authorization")
@Owner("buchnevaia")
public class AuthorizationTest extends TestBase {
    private static final String ERROR_MASSAGE = "Введенного кода не существует";

    @Test
    @DisplayName("Authorization is not possible with invalid authorization code")
    void unsuccessfulAuthorizationTest() {
        mainPage.openLoginDialog()
                .enterAuthorizationCode("A655-4264-B3012")
                .checkErrorAuthorizationResult(ERROR_MASSAGE);
    }

    // email - nayer15345@lubde.com
    //code - A655-4264-B301
    @Test
    @DisplayName("Successful authorization with valid authorization code")
    void successfulAuthorizationTest() {
        mainPage.openLoginDialog()
                .enterAuthorizationCode("A655-4264-B301")
                .checkSuccessAuthorizationResult("Здравствуйте");
    }
}
