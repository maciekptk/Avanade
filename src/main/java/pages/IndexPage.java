package pages;

import assertions.AddToCartAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class IndexPage extends MainPage {

    public AddToCartAssertion addToCartAssertion;

    String url = "http://automationpractice.com";

    @FindBy(css = "[class='blockbestsellers']")
    private WebElement bestsellersButton;

    @FindBy(css = "#blockbestsellers [class='product-container']")
    private WebElement productContainers;

    @FindBy(css = "#blockbestsellers .hovered [title='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(css = "[id='layer_cart']")
    private WebElement layerCartPopup;

    @FindBy(css = "[class='login']")
    private WebElement signInButton;


    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        addToCartAssertion = new AddToCartAssertion(driver);
    }

    public IndexPage openIndexPage() {
        driver.navigate().to(url);
        return this;
    }

    public IndexPage clickBestsellersButton() {
        bestsellersButton.click();
        return this;
    }

    public IndexPage selectRandomProduct() {
        List<WebElement> listOfBestsellerContainers = driver.findElements(By.cssSelector("#blockbestsellers [class='product-container']"));

        Random rg = new Random();
        int randomInt = rg.nextInt(listOfBestsellerContainers.size());

        Actions action = new Actions(driver);
        action.moveToElement(listOfBestsellerContainers.get(randomInt)).build().perform();

        return this;
    }

    public IndexPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public IndexPage waitForLayerCartToBeVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(layerCartPopup));
        return this;
    }

    public AuthenticationPage clickSignInButton() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }
}


