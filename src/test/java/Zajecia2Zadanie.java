import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zajecia2Zadanie {

    @Test
    public void zadanie1() {
        String query = "Printed Dress";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");

        WebElement searchInput = driver.findElement(By.cssSelector("#search_query_top"));
        searchInput.clear();
        searchInput.sendKeys(query);
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        String dressName = "Printed Chiffon Dress";
        WebElement dress = driver.findElement(By.xpath("//div[@class='right-block']//a[@title='" + dressName + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dress).build().perform();
        dress.findElement(By.xpath("./../..//a[@title='Add to cart']")).click();

        List<WebElement> okIcon = driver.findElements(By.cssSelector(".icon-ok"));

        Assert.assertTrue("Product not added to the cart", okIcon.size() > 0);

        driver.quit();
    }

    @Test
    public void zadanie2() {
        String query = "Printed Dress";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");

        WebElement searchInput = driver.findElement(By.cssSelector("#search_query_top"));
        searchInput.clear();
        searchInput.sendKeys(query);
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        String dressName = "Printed Chiffon Dress";
        WebElement dress = driver.findElement(By.xpath("//div[@class='right-block']//a[@title='" + dressName + "']"));
        dress.click();
        WebElement quantityInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#quantity_wanted")));
        String quantityQuery = "3";
        quantityInput.clear();
        quantityInput.sendKeys(quantityQuery);
        WebElement sizeSelect = driver.findElement(By.cssSelector("#group_1"));
        String sizeQuery = "L";
        new Select(sizeSelect).selectByVisibleText(sizeQuery);
        driver.findElement(By.cssSelector("[name='Submit']")).click();

        String addedDress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart_product_title"))).getText();
        Assert.assertEquals("Wrong product added to the cart", dressName, addedDress);
        Assert.assertEquals("Number of added products is different than: " + quantityQuery, quantityQuery, driver.findElement(By.cssSelector("#layer_cart_product_quantity")).getText());
        Assert.assertTrue("Size of added product is different than: " + sizeQuery, driver.findElement(By.cssSelector("[class='layer_cart_product_info']")).getText().contains(sizeQuery));

        driver.quit();
    }


    @Test
    public void zadanie3() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div>ul>li>[title='Dresses']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='product_list grid row']")));
        List<WebElement> discountProducts = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price-percent-reduction']/.."));

        for (WebElement el : discountProducts) {
            String oldPriceString = el.findElement(By.xpath("span[@class='old-price product-price']")).getText().substring(1);
            Float oldPrice = Float.parseFloat(oldPriceString);

            String actualPriceString = el.findElement(By.xpath("span[@class='price product-price']")).getText().substring(1);
            Float actualPrice = Float.parseFloat(actualPriceString);

            String discountString = el.findElement(By.xpath("span[@class='price-percent-reduction']")).getText().replaceAll("[^\\d]", "");
            Float discount = Float.parseFloat(discountString);

            Assert.assertEquals("Actual price is wrongly calculated", (oldPrice * ((100 - discount)/100)), actualPrice, 0.01);
        }
        driver.quit();
    }
}