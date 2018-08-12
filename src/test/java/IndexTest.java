import org.junit.Test;

public class IndexTest extends MainTest {

    @Test
    public void shouldFindAllDressProducts() {
        indexPage.openIndexPage()
                .indexAssertion
                .isAnyDressProductAvailable();
    }
}
