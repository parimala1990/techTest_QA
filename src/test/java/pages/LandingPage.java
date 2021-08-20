package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(id = "nav-link-accountList")
    WebElement loginLink;

    @FindBy(id = "ap_email")
    WebElement userNameTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement passwordTextBox;

    @FindBy(id = "signInSubmit")
    WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(xpath = " //span[text()='Mac Retro matte lipstick 3 g, Ruby Woo']")
    WebElement productSelection;

    By addToCart = By.id("add-to-cart-button");



    public LandingPage(WebDriver driver) {
        super(driver);
    }


    public void searchAnItem(String itemName) {
        searchTextBox.sendKeys(itemName);
        searchButton.click();
        productSelection.click();

    }

    public void addItemToCart()
    {
        waitAndGetElementBy(addToCart).click();
    }

    public void enterUserNameAndPassword() {
        loginLink.click();
        userNameTextBox.sendKeys(readPropertiesFile("username"));
        continueButton.click();
        passwordTextBox.sendKeys(readPropertiesFile("password"));
        signInButton.click();
    }

}
