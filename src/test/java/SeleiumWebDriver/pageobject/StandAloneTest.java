package SeleiumWebDriver.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleiumWebDriver.pageobject.CartPage;
import SeleiumWebDriver.pageobject.CheckOutPage;
import SeleiumWebDriver.pageobject.ConfirmationPage;
import SeleiumWebDriver.pageobject.Landingpage;
import SeleiumWebDriver.pageobject.ProductCatalogu;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumwebdriver.TestComponents.BaseTest1;

public class StandAloneTest  extends BaseTest1{

	public static void main(String[] args) throws InterruptedException {

		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       Landingpage landingpage = new Landingpage(driver);
		landingpage.goTo();
		SeleiumWebDriver.pageobjects.ProductCatalogu productCatalogu = landingpage.loginApplication("sivass2101@gmail.com", "6381012858@Sp");

		List<WebElement> products = productCatalogu.getProductList();
		productCatalogu.addProductToCart(productName);
		CartPage cartpage = productCatalogu.goToCartpage();

		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartpage.goToCheckout(driver);
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.close();

	}

}
