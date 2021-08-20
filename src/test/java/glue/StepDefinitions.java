package glue;


import ComponentFactory.PageObjects;
import CucumberHelper.ITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.*;

public class StepDefinitions implements En {

    private final PageObjects pageObjects;
    private final LandingPage landingPage;
    private final CheckoutPage checkoutPage;
    private final PaymentsPage paymentsPage;
    private final NavigationBar navigationBar;
    private final CartPage cartPage;


    public StepDefinitions(ITestContext testContext) {

        this.pageObjects = testContext.getPageObjectManager();

        this.landingPage = pageObjects.getHomePage();
        this.checkoutPage = pageObjects.getCheckoutPage();
        this.paymentsPage = pageObjects.getPaymentsPage();
        this.navigationBar = pageObjects.getNavigationBar();
        this.cartPage = pageObjects.getCartPage();
        
        Given("I search for product {string}", (String itemName) -> {
            landingPage.searchAnItem(itemName);
        });
        Given("I login into amazon with valid credentials", () -> {
            landingPage.enterUserNameAndPassword();
            if (navigationBar.getCartCount()>0)
            {
                navigationBar.clickCart();
                cartPage.clearBasket();
            }

        });
        And("^I add item to the cart to proceed to checkout$", () -> {
            landingPage.addItemToCart();
            Assert.assertEquals(checkoutPage.verifyItemInTheCart(),"Added to Basket");
            checkoutPage.proceedToCheckOut();
        });
        And("^I select a payment method as Gift card$", (DataTable dataTable) -> {

            paymentsPage.addGiftCard(dataTable);
        });
        Then("^I verify error alert is displayed$", () -> {
            Assert.assertTrue(paymentsPage.verifyErrorAlert());
        });
        And("I should see {string} error message", (String errorMessage) -> {
            Assert.assertEquals(paymentsPage.verifyInvalidGiftCardErrorMessage(),errorMessage);
        });

        After(() -> {
            testContext.tearDown();
        });


    }
}