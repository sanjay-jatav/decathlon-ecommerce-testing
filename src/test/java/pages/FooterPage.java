package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    WebDriver driver;

    // Constructor
    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(linkText = "About Us")
    private WebElement aboutUsLink;

    @FindBy(linkText = "Contact")
    private WebElement contactLink;

    @FindBy(linkText = "Terms & Conditions")
    private WebElement termsLink;

    @FindBy(linkText = "Privacy Policy")
    private WebElement privacyPolicyLink;

    @FindBy(css = "a[href*='facebook']")
    private WebElement facebookIcon;

    @FindBy(css = "a[href*='instagram']")
    private WebElement instagramIcon;

    // Actions
    public void clickAboutUs() {
        aboutUsLink.click();
    }

    public void clickContact() {
        contactLink.click();
    }

    public void clickTerms() {
        termsLink.click();
    }

    public void clickPrivacyPolicy() {
        privacyPolicyLink.click();
    }

    public void clickFacebookIcon() {
        facebookIcon.click();
    }

    public void clickInstagramIcon() {
        instagramIcon.click();
    }

    // Verification methods could also be added
    public boolean isAboutUsDisplayed() {
        return aboutUsLink.isDisplayed();
    }
}
