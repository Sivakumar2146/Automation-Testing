package SeleiumWebDriver.pageobjects;

import java.io.IOException;
import org.testng.Assert;
import org.testng.AssertJUnit; 

import java.util.List;
 
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import seleniumwebdriver.TestComponents.BaseTest;

public class StandAloneTest22 extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3"; // sivass2101@gmail.com pavi2108@gmail.com

		ProductCatalogu productCatalogu = landingpage.loginApplication("sivass2101@gmail.com", "6381012858@Sp");

		List<WebElement> products = productCatalogu.getProductList();
		productCatalogu.addProductToCart(productName);
		CartPage cartPage = productCatalogu.goToCartPage();
	
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkOutPage = cartPage.goToCheckout();
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationPage = CheckoutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfirmationMessage();

		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
  
	@Test(dependsOnMethods={"submitOrder"})
	public  void OrderHistorytest()
	{
		// ZARA COAT 3
		ProductCatalogu productCatalogu = landingpage.loginApplication("sivass2101@gmail.com", "6381012858@Sp");
		 OrderPage   orderpage=productCatalogu.goToOrdersPage();	
	//   Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
	
	}
	
	
	
	
}
