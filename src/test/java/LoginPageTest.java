import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.Defaults;
import pages.LoginPage;
import utils.Browser;

public class LoginPageTest  extends BaseTest{

    private static final String LOGIN_ERROR = "Грешно потребителско име или парола. Моля, опитайте отново.";
    private static final String BLANK_CREDS_ERROR = "Моля, попълнете вашия email";
    private static final String LOGOUT_SUCCESS = "Вие излязохте от акаунта си.";

    @Test
    @DisplayName("Can login with valid credentials")
    @Tag("smoke")
    public void canLoginWithValidCredentials() {
        initLoginPage();
        loginPage.navigateTo();
        Assertions.assertEquals("Вход в inv.bg", loginPage.getH1Text());
        loginPage.enterEmail(Defaults.EMAIL);
        loginPage.enterPassword(Defaults.PASSWORD);

        initHomePage();
        Assertions.assertEquals(Defaults.EMAIL, homePage.getUserPanelText());
    }

    @Test
    @DisplayName("Cant login with invalid credentials")
    @Tag("smoke")
    public void cantLoginWithInvalidCredentials() {
        loginPage.navigateTo();
        Assertions.assertEquals("Вход в inv.bg" ,loginPage.getH1Text());
        loginPage.login(Defaults.EMAIL, "1212121345");
        Assertions.assertEquals(LOGIN_ERROR, loginPage.getLoginErrorMsg());
    }

    @Test
    @DisplayName("Can login with valid credentials and logout")
    @Tag("smoke")
    public void canLoginWithValidCredentialsAndLogout() {
        loginPage.login(Defaults.EMAIL, Defaults.PASSWORD);
        initHomePage();
        Assertions.assertEquals(Defaults.EMAIL, homePage.getUserPanelText());

        homePage.logout();
        Assertions.assertEquals(LOGOUT_SUCCESS, loginPage.getLogoutSuccessMsg());
    }




}
