package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {


    @FindBy(css = "div[id='huc-v2-order-row-confirm-text']>h1")
    WebElement itemInBasketConfirmationText;

    @FindBy(id = "hlb-ptc-btn-native")
    WebElement checkoutButton;

    @FindBy(css = "div [class*='ship-to-this-address a-button a-button']  a")
    WebElement selectAddressButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String verifyItemInTheCart() {
        itemInBasketConfirmationText.isDisplayed();
        return itemInBasketConfirmationText.getText();
    }

    public void proceedToCheckOut() {
        checkoutButton.click();
        selectAddressButton.click();
    }
}
