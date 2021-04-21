package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final String PAGE_URL = "/home";
    private static final By LOC_USER_PANEL = By.cssSelector("div.userpanel-heade");
    private static final By LOC_USER_PANEL_EXIT_BTN = By.xpath("//a[@class='selenium-button-logout button-logout']");
    private static final By LOC_CLIENT_LINK = By.id("tabs_clients");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method return text in the user panel, which is the user email.
     * @return String
      */
    public String getUserPanelText() {
        return driver.findElement(LOC_USER_PANEL).getText().trim();
    }

    /**
     * This method logout from home page
     */
    public void logout() {
        System.out.println("Pressing Logout link");
        driver.findElement(LOC_USER_PANEL).click();
        driver.findElement(LOC_USER_PANEL_EXIT_BTN).click();
    }

    /**
     * This method open the client page.
     */
    public void pressClientsLink(){
        System.out.println("Pressing clients link from the menu");
        driver.findElement(LOC_CLIENT_LINK).click();
    }


}
