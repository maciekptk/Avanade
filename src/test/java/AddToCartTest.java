import org.junit.Test;

public class AddToCartTest extends MainTest {

    @Test
    public void shouldAddBestsellerToCart() {
        indexPage.openIndexPage()
                .clickBestsellersButton()
                .selectRandomProduct()
                .clickAddToCartButton()
                .waitForLayerCartToBeVisible()
                .addToCartAssertion
                .isConfirmationDisplayed();
    }
}
