import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zajecia1Test {

    @Test
    public void openPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");
        Assert.assertEquals("Wrong page title", "My Store", driver.getTitle());

        driver.close();
    }

    @Test
    public void findProduct() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.cssSelector("#search_query_top")).clear();
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Printed");
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();

        Assert.assertEquals("Wrong element found", "\"PRINTED\"", driver.findElement(By.cssSelector(".lighter")).getText());


        driver.quit();
    }

}
