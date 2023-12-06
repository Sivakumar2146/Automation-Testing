package SeleiumWebDriver.SeleniumFrameworkDesgin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
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
	
	
	public void loginApplication ( String email , String password )
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		}
	
	public void goTo()
	{
		driver.get(" https://rahulshettyacademy.com/client");
	}
		
	
	

}
