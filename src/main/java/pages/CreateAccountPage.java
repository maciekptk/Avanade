package pages;

import assertions.CreateAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends MainPage {

    public CreateAccountAssertion createAccountAssertion;

    @FindBy(css = "#customer_firstname")
    private WebElement firstNameInput;

    @FindBy(css = "#customer_lastname")
    private WebElement lastNameInput;

    @FindBy(css = "#passwd")
    private WebElement passwordInput;

    @FindBy(css = "#firstname")
    private WebElement firstNameAddressInput;

    @FindBy(css = "#lastname")
    private WebElement lastNameAddressInput;

    @FindBy(css = "#address1")
    private WebElement addressInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#id_state")
    private WebElement stateSelect;

    @FindBy(css = "#postcode")
    private WebElement postCodeInput;

    @FindBy(css = "#phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(css = "#alias")
    private WebElement aliasInput;

    @FindBy(css = "#submitAccount")
    private WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        createAccountAssertion = new CreateAccountAssertion(driver);
    }

    public CreateAccountPage setFirstName(String firstName) {
        driverWait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        return this;
    }

    public CreateAccountPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public CreateAccountPage setFirstNameAddress(String firstNameAddress) {
        firstNameAddressInput.sendKeys(firstNameAddress);
        return this;
    }

    public CreateAccountPage setLastNameAddress(String lastNameAddress) {
        lastNameAddressInput.sendKeys(lastNameAddress);
        return this;
    }

    public CreateAccountPage setAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public CreateAccountPage setCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public CreateAccountPage setState(String state) {
        new Select(stateSelect).selectByVisibleText(state);
        return this;
    }

    public CreateAccountPage setPostCode(String postCode) {
        postCodeInput.sendKeys(postCode);
        return this;
    }

    public CreateAccountPage setMobiePhone(String mobiePhone) {
        mobilePhoneInput.sendKeys(mobiePhone);
        return this;
    }

    public CreateAccountPage setAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        return this;
    }

    public MyAccountPage clickSubmitButton() {
        submitButton.click();
        return new MyAccountPage(driver);
    }
}
