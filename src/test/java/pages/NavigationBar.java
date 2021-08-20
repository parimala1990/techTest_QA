package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationBar extends BasePage{

    By cartCount = By.cssSelector("#nav-cart-count");
    By cart = By.cssSelector("#nav-cart-count-container");

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public Integer getCartCount(){
        String cartCountText =waitAndGetElementBy(cartCount).getText();
        return Integer.parseInt(cartCountText);
    }

    public void clickCart()
    {
        waitAndGetElementBy(cart).click();
    }

}
