package seleniumTest.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert; // Correct import statement

import SeleiumWebDriver.pageobjects.CartPage;
import SeleiumWebDriver.pageobjects.CheckoutPage;
import SeleiumWebDriver.pageobjects.ConfirmationPage;
import SeleiumWebDriver.pageobjects.Landingpage;
import SeleiumWebDriver.pageobjects.ProductCatalogu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import seleniumwebdriver.TestComponents.BaseTest;

public class StepDefinitionsImple extends BaseTest {
	
    public Landingpage landingpage;
    public ProductCatalogu productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingpage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password) {
        productCatalogue = landingpage.loginApplication(username, password);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        List<org.openqa.selenium.WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) {
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }                 
                    
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string) {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals(strArg1, landingpage.getErrorMessage());
        driver.close();
    }
}
