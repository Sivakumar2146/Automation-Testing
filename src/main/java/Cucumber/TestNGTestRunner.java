package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/cucumber", glue="seleniumTest.stepDefinitions",
monochrome=true , plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner  extends AbstractTestNGCucumberTests {
	

	
	
	
}
