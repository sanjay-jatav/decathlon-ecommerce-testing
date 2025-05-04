package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepdefinitions", // folder name (case-sensitive)
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "json:target/cucumber.json"
	    },
	    tags = "@login",
	    monochrome = true
	)

public class TestRunner extends AbstractTestNGCucumberTests {
}
