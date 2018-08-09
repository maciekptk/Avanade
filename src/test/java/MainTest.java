import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndexPage;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = new IndexPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }
}
