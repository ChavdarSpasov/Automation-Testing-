package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final By LOC_EMAIL = By.id("loginusername");
    private static final By LOC_PASSWORD = By.id("loginpassword");
    private static final By LOC_LOGIN_BUTTON = By.id("loginsubmit");
    private static final By LOC_LOGIN_ERROR_MSG = By.id("error");
    private static final By LOC_SUCCESS_LOGOUT_MSG = By.id("okmsg");

    private static final String PAGE_URL = "/login";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * This method login the customer with his default email and password.
     */
    public void defaultLogin() {

        login(Defaults.EMAIL, Defaults.PASSWORD);
    }

    public void login(String email, String password) {
        navigateTo().
                enterEmail(email).
                enterPassword(password).
                pressLoginButton();
    }

    /**
     * This method navigate to the customer login page.
     * @return LoginPage
     */
    public LoginPage navigateTo() {
        System.out.println("Navigate to Login page");
        driver.navigate().to(Defaults.BASE_URL + PAGE_URL);
        return this;
    }


    /**
     * This method fill email input field.
     * @param email String
     * @return LoginPAge
     */
    public LoginPage enterEmail(String email) {
        System.out.println("Enter email:" + email);
        WebElement emailField = driver.findElement(LOC_EMAIL);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    /**
     * This method fill password input field.
     * @param password String
     * @return LoginPAge
     */
    public LoginPage enterPassword(String password) {
        System.out.println("Enter password:" + password);
        WebElement passwordField = driver.findElement(LOC_PASSWORD);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    /**
     * This method click on login on button.
     * @return LoginPAge
     */
    public LoginPage pressLoginButton() {
        System.out.println("Pressing login button");
        driver.findElement(LOC_LOGIN_BUTTON).click();
        return this;
    }

    /**
     * Method which return the login error message.
     * @return String
     */
    public String getLoginErrorMsg() {
       return driver.findElement(LOC_LOGIN_ERROR_MSG).getText().trim();
    }

    /**
     * Method which return the H1 description text, above the login form .
     * @return String
     */
    public String getH1Text(){
        return driver.findElement(By.xpath("//h1")).getText().trim();
    }

    /**
     * Method which return the successful logout text.
     * @return String
     */
    public String getLogoutSuccessMsg() {
        return driver.findElement(LOC_SUCCESS_LOGOUT_MSG).getText().trim();
    }
}
