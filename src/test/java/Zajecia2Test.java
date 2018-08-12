import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Zajecia2Test {

    @Test
    public void findDressInProductContainers() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");

        List<WebElement> productsList = driver.findElements(By.cssSelector("[id='homefeatured'] [class=product-container]"));
        int numberOfDressProducts = 0;

        for (WebElement element : productsList) {
            String productName = element.findElement(By.cssSelector(".product-name")).getText();
            if (productName.contains("Dress")) {
                System.out.println("Dresses: " + productName);
                numberOfDressProducts++;
            }
        }
        Assert.assertTrue("No products with 'Dress' in name", numberOfDressProducts > 0);

        driver.quit();
    }

    @Test
    public void findDressInProductContainers2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");

        List<WebElement> productNames = driver.findElements(By.cssSelector("[id='homefeatured'] [class=product-container] .product-name"));
        int numberOfDressProducts = 0;
        for (WebElement el : productNames) {
            if (el.getText().contains("Dress")) {
                numberOfDressProducts++;
            }
        }
        Assert.assertTrue("No products with 'Dress' in name", numberOfDressProducts > 0);
        System.out.println("Number of products with 'Dress' in name: " + numberOfDressProducts);

        driver.quit();
    }
}
