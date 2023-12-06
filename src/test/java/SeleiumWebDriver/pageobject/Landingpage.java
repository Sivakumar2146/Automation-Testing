package SeleiumWebDriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleiumWebDriver.pageobjects.ProductCatalogu;
import Webdriver.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		
		super(driver);
		// initalizes 
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
      //	WebElement userEmail= driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")    
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	public ProductCatalogu loginApplication ( String email , String password )
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogu productCatalogu = new ProductCatalogu(driver);
		return productCatalogu;
		
		
		
		}
	
	public void goTo()
	{
		driver.get(" https://rahulshettyacademy.com/client");
	}
		
	
	

}
