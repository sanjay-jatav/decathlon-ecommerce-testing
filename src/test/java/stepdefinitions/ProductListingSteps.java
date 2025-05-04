package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.ProductListingPage;
import utils.DriverManager;

public class ProductListingSteps {

    WebDriver driver = DriverManager.getDriver();
    ProductListingPage plp = new ProductListingPage(driver);

    @Given("User is on the Decathlon homepage")
    public void user_is_on_the_decathlon_homepage() {
        driver.get("https://www.decathlon.in/");
        Assert.assertTrue(driver.getTitle().contains("Decathlon"), "Homepage not loaded");
    }

    @When("User navigates to the Product Listing Page")
    public void user_navigates_to_the_product_listing_page() {
        plp.applyMenFilter();
        By menShortsProduct = By.xpath("//span[contains(text(), 'Shorts')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(menShortsProduct));
        element.click();
    }

    @Then("User should see a list of products displayed")
    public void user_should_see_a_list_of_products_displayed() {
        Assert.assertTrue(plp.isProductListDisplayed(), "Product list is not displayed");
    }
}
