package assertions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import java.util.List;

public class IndexAssertion extends MainPage {

    @FindAll(@FindBy(css = "[id='homefeatured'] [class=product-container]"))
    private List<WebElement> products;

    public IndexAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isAnyDressProductAvailable() {
        int numberOfDressProducts = 0;
        for (WebElement element : products) {
            if (element.findElement(By.cssSelector(".product-name")).getText().contains("Dress")) {
                numberOfDressProducts++;
            }
        }
        Assert.assertTrue("No products with 'Dress' in name", numberOfDressProducts > 0);

    }
}
