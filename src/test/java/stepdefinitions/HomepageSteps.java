package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.Homepage;
import utils.DriverManager;
import utils.ExtentManager;

public class HomepageSteps {

    WebDriver driver = DriverManager.getDriver();
    Homepage homePage = new Homepage(driver);

    ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest extentTest;

    @Given("User opens the Decathlon homepage")
    public void user_opens_the_decathlon_homepage() {
        driver.get("https://www.decathlon.in/");
        extentTest = extent.createTest("Homepage Test");
        extentTest.pass("User opened the Decathlon homepage.");
    }

    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        extentTest.pass("Verified page title: " + expectedTitle);
    }

    @And("The Decathlon logo should be visible")
    public void the_decathlon_logo_should_be_visible() {
        Assert.assertTrue(homePage.isLogoVisible(), "Logo is not visible");
        extentTest.pass("Logo is visible");
    }
}
