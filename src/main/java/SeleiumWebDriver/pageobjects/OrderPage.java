package SeleiumWebDriver.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Webdriver.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
    
	WebDriver driver;




    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = "tr td:nth-child(3)")
    public List<WebElement> productElements;
    
    public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		
	}

    
    public Boolean verifyOrderDisplay(String expectedProductName) {
        Boolean match = productElements.stream().anyMatch(product -> product.getText().equalsIgnoreCase(expectedProductName));
        return match;
    }

	

   /* public CheckOutPage goToCheckout() {
        checkoutEle.click();
        return new CheckOutPage(driver);
    }             */
}
