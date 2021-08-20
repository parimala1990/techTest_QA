package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By deleteButton =  By.cssSelector("input[data-action='delete']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clearBasket()
    {
        List<WebElement> deleteElements = waitAndGetElementsBy(deleteButton);
        deleteElements.forEach(e->e.click());
    }
}
