package assertions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;

public class CreateAccountAssertion extends MainPage {

    @FindBy(css = "#email")
    private WebElement emailInput;

    public CreateAccountAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isEmailCorrect(String enteredEmail) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email'][not(@value='')]")));

        Assert.assertEquals("Email is not correctly passed", enteredEmail,
                emailInput.getAttribute("value"));
    }
}
