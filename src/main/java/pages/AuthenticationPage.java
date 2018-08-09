package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends MainPage {

    @FindBy(css = "#email_create")
    private WebElement emailInput;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}
