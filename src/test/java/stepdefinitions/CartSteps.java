package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductDetailsPage;
import utils.DriverManager;

public class CartSteps {

    WebDriver driver = DriverManager.getDriver();
    ProductDetailsPage pdp;
    CartPage cart;

    @Given("I am on a Product Details Page")
    public void i_am_on_product_details_page() throws InterruptedException {
        driver.get("https://www.decathlon.in/c/men-tshirts-17107");
        Thread.sleep(5000);
        pdp = new ProductDetailsPage(driver);
        cart = new CartPage(driver);
    }

    @When("I add the product to the cart")
    public void i_add_product_to_cart() throws InterruptedException {
        pdp.clickAddToCart();
        Thread.sleep(8000);
    }

    @Then("the cart should contain the product")
    public void cart_should_contain_product() {
        Assert.assertTrue(cart.isProductInCart(), "Product is not in the cart!");
    }

    @Given("I have a product in the cart")
    public void i_have_product_in_cart() {
        driver.get("https://www.decathlon.in/c/men-tshirts-17107"); // Load PDP again
        pdp = new ProductDetailsPage(driver);
        pdp.clickAddToCart();
        cart = new CartPage(driver);
    }

    @When("I remove the product from the cart")
    public void i_remove_product_from_cart() {
        cart.removeProduct();
    }

    @Then("the cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertEquals(cart.getCartItemCount(), 0, "Cart is not empty!");
    }

    @When("I update the quantity to {int}")
    public void i_update_quantity_to(int quantity) {
        cart.updateQuantity(String.valueOf(quantity));
    }

    @Then("the cart should reflect quantity as {int}")
    public void cart_should_reflect_quantity(int expectedQty) {
        Assert.assertEquals(Integer.parseInt(cart.getQuantity()), expectedQty, "Quantity does not match!");
    }

    @Given("I have a product in the cart with quantity {int}")
    public void i_have_product_with_quantity(int quantity) {
        driver.get("https://www.decathlon.in/p/123456"); // Replace with PDP URL
        pdp = new ProductDetailsPage(driver);
        pdp.clickAddToCart();
        cart = new CartPage(driver);
        cart.updateQuantity(String.valueOf(quantity));
    }

    @Then("the total price should be correctly calculated")
    public void total_price_should_be_correct() {
        double unitPrice = cart.productPrice(); // You need to expose this in ProductDetailsPage
        int quantity = Integer.parseInt(cart.getQuantity());
        double expectedTotal = unitPrice * quantity;
        double actualTotal = cart.getTotalPrice();
        Assert.assertEquals(actualTotal, expectedTotal, "Total price mismatch!");
    }

    @Given("I add multiple different products to the cart")
    public void i_add_multiple_products_to_cart() {
        // Simulate by opening two PDPs and adding both products
        driver.get("https://www.decathlon.in/p/123456");
        pdp = new ProductDetailsPage(driver);
        pdp.clickAddToCart();

        driver.get("https://www.decathlon.in/p/789101");
        pdp = new ProductDetailsPage(driver);
        pdp.clickAddToCart();

        cart = new CartPage(driver);
    }

    @Then("all products should be listed in the cart")
    public void all_products_should_be_listed_in_cart() {
        Assert.assertTrue(cart.getCartItemCount() >= 2, "Not all products are listed in the cart!");
    }
}
