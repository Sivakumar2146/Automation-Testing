package seleniumwebdriver.TestComponents;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleiumWebDriver.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {
    
    public WebDriver driver;    
    public Landingpage landingpage;   
    
    
    
    public WebDriver initializeDriver() throws IOException {
        // properties class
        Properties prop = new Properties();
        
        // Correcting the FileInputStream path
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"//src//test//java//SeleiumWebDriver//resources//GlobalData.properties");
    
        prop.load(fis);
        
        String browsername = prop.getProperty("browser");
        
        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            // handle firefox setup
        } else if (browsername.equalsIgnoreCase("edge")) {
            // handle edge setup
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    
    @BeforeMethod
    public Landingpage launchApplication() throws IOException {
        driver = initializeDriver();
        landingpage = new Landingpage(driver);
        landingpage.goTo();
        return landingpage;
    }
    
   
	@AfterMethod
    public void tearDown()
    {
    	driver.close();
    }
    
    
    
    
    
    
}
