package buchneva.web.tests;

import buchneva.web.drivers.AuthConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Authorization")
@Owner("buchnevaia")
public class AuthorizationTest extends TestBase {
    private static final String ERROR_MASSAGE = "Введенного кода не существует";
    private static final String HELLO_MASSAGE = "Здравствуйте";
    AuthConfig authConfig;

    @BeforeEach
    public void createAuth() {
        authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    }

    @Test
    @DisplayName("Authorization is not possible with invalid authorization code")
    void unsuccessfulAuthorizationTest() {
        mainPage.openPage();
        mainPage.openLoginDialog()
                .enterAuthorizationCode(authConfig.code() + "2")
                .checkErrorAuthorizationResult(ERROR_MASSAGE);
    }

    @Test
    @DisplayName("Successful authorization with email and code")
    void successfulAuthorizationEmailTest() {
        mainPage.openPage();
        mainPage.openLoginDialog()
                .enterAuthorizationEmailAndCode(authConfig.email(), authConfig.code())
                .checkSuccessAuthorizationResult(HELLO_MASSAGE);
    }

    @Test
    @DisplayName("Successful authorization with only code")
    void successfulAuthorizationTest() {
        mainPage.openPage();
        mainPage.openLoginDialog()
                .enterAuthorizationCode(authConfig.code())
                .checkSuccessAuthorizationResult(HELLO_MASSAGE);
    }
}
