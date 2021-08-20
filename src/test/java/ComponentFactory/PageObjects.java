package ComponentFactory;


import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjects {

    private WebDriver driver;

    private LandingPage landingPage;


    public PageObjects(WebDriver driver) {

        this.driver = driver;
    }

    public LandingPage getHomePage() {

        return new LandingPage(driver);
    }

    public PaymentsPage getPaymentsPage() {

        return new PaymentsPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }
}
