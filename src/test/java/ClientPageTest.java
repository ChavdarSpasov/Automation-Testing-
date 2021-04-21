import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientPageTest extends BaseTest{
    private static final String SUCCESS_MESSAGE = "Клиентът е добавен успешно.";
    private static final String EMPTY_LIST_MESSAGE = "Все още нямате добавени клиенти.";

    @Test
    @DisplayName("Can create new client with valid information")
    public void canCreateNewClientWithValidInformation() {
        loginPage.defaultLogin();
        homePage.pressClientsLink();
        //Assert heading text
        Assertions.assertEquals("Клиенти", clientPage.getH2Text());
        //Create new client
        clientPage.createClient("Pragmatic", "Student District", "Sofia");
        //Assert that the client was created / success message
        Assertions.assertEquals(SUCCESS_MESSAGE, clientPage.getSuccessMessage());
    }
}
