package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    private By firstProduct = By.xpath("(//button[@aria-label='addToCart'])[1]");
    private By cartItems = By.cssSelector(".cart-item"); // Update with actual selector
    private By removeButton = By.cssSelector(".remove-item");
    private By quantityField = By.cssSelector("input.quantity-input");
    private By productPrice = By.xpath("//span[text()='₹ 299']");
    private By totalPrice = By.cssSelector(".cart-total-price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCart(WebDriver driver) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
       if(ele.isDisplayed()) {
    	   System.out.println("Yes first produt is display..!");
       }
       ele.click();
    }
    public boolean isProductInCart() {
        return driver.findElements(cartItems).size() > 0;
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    public void updateQuantity(String quantity) {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(quantity);
    }

    public String getQuantity() {
        return driver.findElement(quantityField).getAttribute("value");
    }
    
    public double productPrice() {
        String priceText = driver.findElement(productPrice).getText(); 
        priceText = priceText.replace("₹", "").replace(",", "").trim();
        return Double.parseDouble(priceText); 
    }

    public double getTotalPrice() {
        String priceText = driver.findElement(totalPrice).getText().replace("₹", "").trim();
        return Double.parseDouble(priceText);
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }
}
