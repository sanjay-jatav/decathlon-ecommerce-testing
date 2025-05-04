package stepdefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverManager;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentTest;


public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ExtentTest test = ExtentManager.getTest("Login Test");

    @Given("User is on the Decathlon login page")
    public void user_is_on_decathlon_login_page() throws InterruptedException {
        
        loginPage.visitLoginPage();
        Thread.sleep(5000);
    }

    @When("User selects login with Mobile and OTP")
    public void user_selects_login_with_mobile_and_otp() {
        
        loginPage.selectMobileLogin();
    }

    @And("User enters valid mobile number {string}")
    public void user_enters_valid_mobile_number(String mobile) {
        
        loginPage.enterMobileNumber(mobile);
    }

    @And("User clicks on the Send OTP button")
    public void user_clicks_on_send_otp_button() {
        
        loginPage.clickSendOtp();
        
    }

    @Then("User should receive OTP and login should be successful")
    public void user_should_receive_otp_and_login_should_be_successful() throws InterruptedException {
    	Thread.sleep(10000);
        Assert.assertTrue(loginPage.isOtpSentMessageVisible(), "OTP not visible");
        
    }
    
    @When("User selects login with Email and OTP")
    public void user_selects_login_with_email_and_otp() {
        loginPage.selectEmailLogin();
    }
    @And("User enters valid email address {string}")
    public void user_enters_valid_email_address(String email) {
    	loginPage.enterEmail(email);
        
    }

}
