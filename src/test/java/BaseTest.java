import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ClientPage;
import utils.Browser;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ClientPage clientPage;

    @BeforeEach
    public void setUpBrowser() {

        Browser.open("chrome");
    }

    @AfterEach
    public void tearDown() {

        Browser.close();
    }

    /**
     * This method create instance of LoginPage class.
     * LoginPage loginPage = new LoginPage()
     */
    protected void initLoginPage() {
        this.loginPage = new LoginPage(Browser.driver);
    }

    /**
     * This method create instance of HomePage class.
     * HomePage homePage = new HomePage()
     */
    protected void initHomePage() {
        this.homePage = new HomePage(Browser.driver);
    }

    /**
     * This method create instance of ClientPage class.
     * ClientPage clientPage = new ClientPage()
     */
    protected void initClientPage() {
        this.clientPage = new ClientPage(Browser.driver);
    }
}
