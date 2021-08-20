package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class PaymentsPage extends BasePage {

    @FindBy(css = "a[data-action='a-expander-toggle']")
    WebElement giftCardToggle;

    @FindBy(css = "input[name='ppw-claimCode']")
    WebElement giftCardTextBox;

    @FindBy(css = "span[class='a-button a-button-base pmts-claim-code-apply-button pmts-button-input']")
    WebElement applyButton;

    @FindBy(css = "div[class='a-box a-alert a-alert-error'] span")
    WebElement errorText;

    By errorAlert = By.cssSelector("div[class='a-box a-alert a-alert-error']");


    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    public void addGiftCard(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        giftCardToggle.click();
        giftCardTextBox.sendKeys(maps.get(0).get("giftCardNumber"));
        applyButton.click();
    }


    public boolean verifyErrorAlert() {
        return waitAndGetElementBy(errorAlert).isDisplayed();
    }

    public String verifyInvalidGiftCardErrorMessage() {
        return errorText.getText();
    }
}
