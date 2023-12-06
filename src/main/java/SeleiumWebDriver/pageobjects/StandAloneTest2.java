package SeleiumWebDriver.pageobjects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumwebdriver.TestComponents.BaseTest;

public class StandAloneTest2 extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void wrongvalidations(HashMap<String, String> input) throws InterruptedException, IOException {

		// sivass2101@gmail.com

		ProductCatalogu productCatalogu = landingpage.loginApplication(input.get("email"), input.get("password"));
		Assert.assertEquals("Incorrect email  passsword ", landingpage.getErrorMessage());
		
		/*List<WebElement> products = productCatalogu.getProductList();
		productCatalogu.addProductToCart(productName);
		CartPage cartPage = productCatalogu.goToCartPage();
	
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkOutPage = cartPage.goToCheckout();
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationPage = CheckoutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfirmationMessage();

		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

*/
	}

/*	@Test
	public void submitOrder1() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3"; // sivass2101@gmail.com pavi2108@gmail.com

		ProductCatalogu productCatalogu = landingpage.loginApplication("sivass2101@gmail.com", "6381012858@Sp");

		List<WebElement> products = productCatalogu.getProductList();
		productCatalogu.addProductToCart(input.get("product"));
		CartPage cartpage = productCatalogu.goToCartpage();

		Boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}        */

	@DataProvider
	public Object[][] getData() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("email", "sivass2101@gmail.com");
		map.put("password", "6381012858@Sp");
		map.put("product", "ZARA COAT 3 ");

		return new Object[][] { { map }, { "pavi2108@gmail.com", " 8489948775@Sp" } };

	}

}
