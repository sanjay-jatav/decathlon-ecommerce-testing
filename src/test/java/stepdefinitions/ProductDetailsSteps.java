package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductDetailsPage;
import utils.DriverManager;

public class ProductDetailsSteps {

    WebDriver driver = DriverManager.getDriver();
    ProductDetailsPage pdp = new ProductDetailsPage(driver);

    @Given("I am on the Product Listing Page")
    public void i_am_on_the_product_listing_page() {
        driver.get("https://www.decathlon.in/shop/decathlon-men-collection"); // Example URL
    }

    @When("I click on a product")
    public void i_click_on_a_product() {
        // Click the first product (you can customize this)
        pdp.clickOnProduct();
    }

    @Then("the Product Details Page should display the product title")
    public void product_title_should_be_displayed() {
        Assert.assertTrue(pdp.isProductTitleDisplayed());
    }

    @Then("the Product Details Page should display the product price")
    public void product_price_should_be_displayed() {
        Assert.assertTrue(pdp.isProductPriceDisplayed());
    }

    @Given("I am on the Product Details Page")
    public void i_am_on_the_product_details_page() {
        driver.get("https://www.decathlon.in/p/123456"); // Replace with a valid PDP URL
    }

    @When("I hover over the main product image")
    public void i_hover_over_the_main_product_image() {
        pdp.hoverOverMainProductImage();
    }

    @Then("the image should zoom in")
    public void image_should_zoom_in() {
        Assert.assertTrue(pdp.isImageZoomedIn());
    }

    @Then("additional thumbnail images should be visible")
    public void additional_thumbnails_should_be_visible() {
        Assert.assertTrue(pdp.areThumbnailImagesVisible());
    }

    @Then("I should see the product specifications section")
    public void i_should_see_product_specifications() {
        Assert.assertTrue(pdp.isSpecificationsSectionDisplayed());
    }

    @Then("it should include key details like material, dimensions, and warranty")
    public void key_specification_details_should_be_visible() {
        Assert.assertTrue(pdp.isKeySpecificationDisplayed());
    }

    @Then("I should see a reviews section")
    public void i_should_see_reviews_section() {
        Assert.assertTrue(pdp.isReviewsSectionDisplayed());
    }

    @Then("it should display user ratings and comments")
    public void user_ratings_and_comments_should_be_visible() {
        Assert.assertTrue(pdp.areRatingsAndCommentsVisible());
    }

    @When("I click on the {string} button")
    public void i_click_on_add_to_cart_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add to Cart")) {
            pdp.clickAddToCart();
        }
    }

    @Then("the product should be added to the cart")
    public void product_should_be_added_to_cart() {
        Assert.assertTrue(pdp.isCartConfirmationVisible());
    }

    @Then("a confirmation message should appear")
    public void confirmation_message_should_appear() {
        Assert.assertTrue(pdp.isCartConfirmationVisible());
    }
}
