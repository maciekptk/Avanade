package assertions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;

public class MyAccountAssertion extends MainPage {

    @FindBy(css = ".account")
    private WebElement loggedUserField;

    public MyAccountAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isLoggedUserCorrect(String firstAndLastName) {

        Assert.assertEquals("Different user is logged in", firstAndLastName, driverWait.until(ExpectedConditions.visibilityOf(loggedUserField)).getText());
    }
}
