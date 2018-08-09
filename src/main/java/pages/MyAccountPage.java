package pages;

import assertions.MyAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends MainPage {

    public MyAccountAssertion myAccountAssertion;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        myAccountAssertion = new MyAccountAssertion(driver);
    }
}
