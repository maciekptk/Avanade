import org.junit.Test;

import java.util.Random;

public class CreateNewAccountTest extends MainTest {

    String firstName = "John";
    String lastName = "Smith";
    String password = "qwerty";
    String address = "Main Street 434";
    String city = "New York";
    String state = "New York";
    String mobilePhone = "+1448288122834";
    String alias = "Home";
    String postCode = "48288";


    Random rg = new Random();
    int randomInt = rg.nextInt(10000);
    String email = "test" + randomInt + "@mail.com";

    @Test
    public void shouldPassEmail() {
        indexPage.openIndexPage()
                .clickSignInButton()
                .setEmail(email)
                .clickCreateAccountButton()
                .createAccountAssertion
                .isEmailCorrect(email);
    }

    @Test
    public void shouldRegisterNewUser() {
        indexPage.openIndexPage()
                .clickSignInButton()
                .setEmail(email)
                .clickCreateAccountButton()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setFirstNameAddress(firstName)
                .setLastNameAddress(lastName)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setPostCode(postCode)
                .setMobiePhone(mobilePhone)
                .setAlias(alias)
                .clickSubmitButton()
                .myAccountAssertion
                .isLoggedUserCorrect(firstName + " " + lastName);
    }
}
