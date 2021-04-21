package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClientPage {
    private static final String PAGE_URL = "/clients/manage";

    private static final By LOC_H2_HEADER = By.xpath("//div[@id='headline2']//h2");
    private static final By LOC_NEW_CLIENT_BTN = By.xpath("//a[@class='newbtn selenium-add-client-button']");
    private static final By LOC_ADDRESS_FORM_FIELD = By.name("firm_addr");
    private static final By LOC_CITY_FORM_FIELD = By.name("firm_town");
    private static final By LOC_FIRM_NAME_FORM_FIELD = By.name("firm_name");
    private static final By LOC_ADD_CLIENT_FORM_FIELD = By.name("do_submit");
    private static final By LOC_SUCCESS_MSG = By.id("okmsg");
    private static final By LOC_EMPTY_MSG = By.id("emptylist");

    private WebDriver driver;

    public ClientPage(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * This method get the text content of the H2 element of the login page.
     * @return String
     */
    public String getH2Text() {
        return driver.findElement(LOC_H2_HEADER).getText().trim();
    }

    /**
     * This method open a new client form, after clicking on "Нов Клиент" link button.
     * return ClientPage
     */
    public ClientPage pressNewClientLink() {
        System.out.println("Pressing New Client link");
        driver.findElement(LOC_NEW_CLIENT_BTN).click();
        return this;
    }

    /**
     * This method fill the address input field.
     * @param address - address of the customer firm
     * @return ClientPage
     */
    public ClientPage enterAddress(String address) {
        System.out.println("Entering address:" + address);
        WebElement addressField = driver.findElement(LOC_ADDRESS_FORM_FIELD);
        addressField.clear();
        addressField.sendKeys(address);
        return this;
    }

    /**
     * This method fill the city name input field.
     * @param city - the name of city of the customer firm
     * @return ClientPage
     */
    public ClientPage enterCity(String city) {
        System.out.println("Entering city:" + city);
        WebElement cityField = driver.findElement(LOC_CITY_FORM_FIELD);
        cityField.clear();
        cityField.sendKeys(city);
        return this;
    }

    /**
     * This method fill the firm name input field.
     * @param name - the name of customer firm
     * @return ClientPage
     */
    public ClientPage enterName(String name) {
        System.out.println("Entering name:" + name);
        WebElement nameField = driver.findElement(LOC_FIRM_NAME_FORM_FIELD);
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    /**
     * This method save the form with the new client.
     */
    public void pressSaveClient() {
        System.out.println("Pressing Save button");
        WebElement saveInput = driver.findElement(LOC_ADD_CLIENT_FORM_FIELD);
        saveInput.click();
    }

    /**
     * This method create new client with the mandatory fields.
     * @param name - name of the firm
     * @param address - address of the firm
     * @param city - city where the firm is situated
     */
    public void createClient( String name, String address, String city) {
        pressNewClientLink()
                .enterName(name)
                .enterAddress(address)
                .enterCity(city)
                .pressSaveClient();
    }

    /**
     * This method get the message after the successful adding og new client.
     * @return String
     */
    public String getSuccessMessage() {
        return driver.findElement(LOC_SUCCESS_MSG).getText().trim();
    }

    public String getEmptyListMessage() {
        return driver.findElement(LOC_EMPTY_MSG).getText();
    }

    /**
     * This method navigate to the client page.
     * @return ClientPage
     */
    public ClientPage navigateTo() {
        System.out.println("Navigating to Clients page");
        driver.navigate().to(Defaults.BASE_URL + PAGE_URL);
        return this;
    }

    public String getTableText() {
        return driver
                .findElement(By.id("fakturi_table")).getText();
    }
}
