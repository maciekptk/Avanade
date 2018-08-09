package assertions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class AddToCartAssertion extends MainPage {

    @FindBy(css = ".layer_cart_product h2")
    private WebElement addedToCartConfirmation;

    public AddToCartAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isConfirmationDisplayed() {
        Assert.assertEquals("Product not added to the cart",
                "Product successfully added to your shopping cart", addedToCartConfirmation.getText());
    }
}
