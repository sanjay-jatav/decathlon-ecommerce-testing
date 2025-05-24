package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepdefinitions", // folder name (case-sensitive)
	    
	    tags = "@loginWithMobileNumber",
	    monochrome = true
	)
 
public class TestRunner extends AbstractTestNGCucumberTests {
}
