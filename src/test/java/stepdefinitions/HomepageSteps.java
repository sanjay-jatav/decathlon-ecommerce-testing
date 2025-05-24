package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.Homepage;
import utils.DriverManager;
import utils.ExtentManager;

import java.util.List;

public class HomepageSteps {

    WebDriver driver = DriverManager.getDriver();
    Homepage homepage = new Homepage(driver);

    ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest extentTest;

    @Given("User opens the Decathlon homepage")
    public void user_opens_the_decathlon_homepage() {
        driver.get("https://www.decathlon.in/");
        Assert.assertEquals(homepage.getPageTitle(), "Decathlon - Buy Sport Products Online | Download Decathlon App");
    }

    @When("User enters {string} in the search bar")
    public void user_enters_in_the_search_bar(String query) {
        homepage.searchUsingEnterKey(query);
    }

    @Then("Search results related to {string} should be displayed")
    public void search_results_related_to_should_be_displayed(String query) {
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains(query.toLowerCase()), 
            "Search results do not contain expected keyword: " + query);
    }

    @Then("The navigation menu should include {string}, {string}, {string}, {string}, and {string}")
    public void the_navigation_menu_should_include_and(String m1, String m2, String m3, String m4, String m5) {
        List<WebElement> menuItems = homepage.getNavMenuItems();
        Assert.assertTrue(menuItems.stream().anyMatch(e -> e.getText().equalsIgnoreCase(m1)));
        Assert.assertTrue(menuItems.stream().anyMatch(e -> e.getText().equalsIgnoreCase(m2)));
        Assert.assertTrue(menuItems.stream().anyMatch(e -> e.getText().equalsIgnoreCase(m3)));
        Assert.assertTrue(menuItems.stream().anyMatch(e -> e.getText().equalsIgnoreCase(m4)));
        Assert.assertTrue(menuItems.stream().anyMatch(e -> e.getText().equalsIgnoreCase(m5)));
    }

    @When("User clicks on the {string} category")
    public void user_clicks_on_the_category(String category) {
        homepage.clickNavMenuButton(); // click to open menu
        homepage.clickSubCategory(category); // click specific subcategory
    }

    @Then("The user should be redirected to the Men’s category page")
    public void the_user_should_be_redirected_to_the_men_s_category_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("men"), 
            "Not redirected to the Men’s category page.");
    }

    @Then("Subcategories like {string}, {string}, {string} should be displayed")
    public void subcategories_like_should_be_displayed(String s1, String s2, String s3) {
        List<WebElement> subcats = homepage.getSubCategories();
        Assert.assertTrue(subcats.stream().anyMatch(e -> e.getText().equalsIgnoreCase(s1)));
        Assert.assertTrue(subcats.stream().anyMatch(e -> e.getText().equalsIgnoreCase(s2)));
        Assert.assertTrue(subcats.stream().anyMatch(e -> e.getText().equalsIgnoreCase(s3)));
    }

    @Then("The homepage banner should be visible")
    public void the_homepage_banner_should_be_visible() {
        Assert.assertTrue(homepage.isBannerDisplayed(), "Banner is not visible");
    }

    @When("User clicks on the homepage banner")
    public void user_clicks_on_the_homepage_banner() {
        homepage.clickBanner();
    }

    @Then("The user should be redirected to the relevant promotion page")
    public void the_user_should_be_redirected_to_the_relevant_promotion_page() {
        // Simple validation — adjust as needed based on actual redirection
        Assert.assertFalse(driver.getCurrentUrl().contains("decathlon.in"), 
            "Not redirected from homepage after clicking banner.");
    }

    @Then("The homepage should display different banner images after a few seconds")
    public void the_homepage_should_display_different_banner_images_after_a_few_seconds() throws InterruptedException {
        String bannerBefore = homepage.getBannerContent();
        Thread.sleep(6000); // Wait for banner to rotate
        String bannerAfter = homepage.getBannerContent();
        Assert.assertNotEquals(bannerBefore, bannerAfter, "Banner image did not change after a few seconds.");
    }
}
