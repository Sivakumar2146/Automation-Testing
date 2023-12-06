package seleniumwebdriver.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleiumWebDriver.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;
   

public class BaseTest {
    
    public WebDriver driver;    
    public Landingpage landingpage;
    
    
    
    public WebDriver initializeDriver() throws IOException {
        // properties class
        Properties prop = new Properties();
        
        // Correcting the FileInputStream path
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"//src//test//java//SeleiumWebDriver//resources//GlobalData.properties");
    
        prop.load(fis);
        
        String browsername = prop.getProperty("browser");
        
        if (browsername.contains("chrome")) {
        	
        	ChromeOptions options = new ChromeOptions();
        	if(browsername.contains("headless"))
        	{
        		options.addArguments("headless");
        	}
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
    
    
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ((RemoteWebDriver) ts).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
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
