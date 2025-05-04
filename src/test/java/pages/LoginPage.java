package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By mobileTab = By.id("input_type_tab2");
    private By emailTab = By.id("input_type_tab1");
    
    private By mobileInput = By.id("input-mobile");
    private By emailInput = By.id("input-email");
    private By sendOtpBtn = By.id("lookup-btn");
    private By signInbtn = By.xpath("//p[contains(text(), 'Sign In')]");
    private By otpSentMessage = By.xpath("//div[@aria-label='The code has been sent']"); // optional

    // Navigate to login page
    public void visitLoginPage() {
        driver.get("https://www.decathlon.in/");
        driver.findElement(signInbtn).click();
    }

    // Select mobile login tab
    public void selectMobileLogin() {
        driver.findElement(mobileTab).click();
    }

    // Select email login tab
    public void selectEmailLogin() {
        driver.findElement(emailTab).click();
    }

    // Enter mobile number
    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    // Enter email address
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Click on Send OTP
    public void clickSendOtp() {
        driver.findElement(sendOtpBtn).click();
    }

    // Optional: Verify OTP sent message (can use explicit wait in step definition)
    public boolean isOtpSentMessageVisible() {
        return driver.findElement(otpSentMessage).isDisplayed();
    }
}
