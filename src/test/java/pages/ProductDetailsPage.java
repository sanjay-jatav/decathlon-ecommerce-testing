package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductDetailsPage {
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By product = By.cssSelector(".product-card");
    private By productTitle = By.xpath("//h1[@class='text-black md:font-semibold font-normal text-14 md:text-[24px] md:mt-1 md:mb-1']");
    private By productPrice = By.xpath("//span[text()='₹ 299']");
    private By mainProductImage = By.xpath("(//img[@alt=\"KIPRUN 100 Dry Men's Breathable Running T-Shirt - BLACK\"])[6]");
    private By imageZoomArea = By.xpath("//img[@alt='PRODUCT NAME COME HERE....']"); // placeholder
    private By thumbnailImages = By.id("productImageThumbnails");
    private By specificationsSection = By.xpath("//section[contains(., 'Specifications')]");
    private By materialInfo = By.xpath("//section[contains(., 'Material')]");
    private By dimensionsInfo = By.xpath("//section[contains(., 'Dimensions')]");
    private By warrantyInfo = By.xpath("//section[contains(., 'Warranty')]");
    private By reviewsSection = By.id("reviews");
    private By userRatings = By.cssSelector(".user-rating");
    private By userComments = By.cssSelector(".user-comment");
    private By addToCartButton = By.xpath("//button[contains(., 'Add to Cart')]");
    private By cartConfirmationMessage = By.cssSelector(".cart-confirmation");

    // Actions
    public void clickOnProduct() {
    	driver.findElement(product).click();
    }
    public boolean isProductTitleDisplayed() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public void hoverOverMainProductImage() {
        WebElement image = driver.findElement(mainProductImage);
        new Actions(driver).moveToElement(image).perform();
    }

    public boolean isImageZoomedIn() {
        return driver.findElement(imageZoomArea).isDisplayed(); // adjust based on actual DOM
    }

    public boolean areThumbnailImagesVisible() {
        List<WebElement> thumbnails = driver.findElements(thumbnailImages);
        return thumbnails.size() > 0 && thumbnails.get(0).isDisplayed();
    }

    public boolean isSpecificationsSectionDisplayed() {
        return driver.findElement(specificationsSection).isDisplayed();
    }

    public boolean isKeySpecificationDisplayed() {
        return driver.findElement(materialInfo).isDisplayed() &&
               driver.findElement(dimensionsInfo).isDisplayed() &&
               driver.findElement(warrantyInfo).isDisplayed();
    }

    public boolean isReviewsSectionDisplayed() {
        return driver.findElement(reviewsSection).isDisplayed();
    }

    public boolean areRatingsAndCommentsVisible() {
        return driver.findElement(userRatings).isDisplayed() &&
               driver.findElement(userComments).isDisplayed();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isCartConfirmationVisible() {
        return driver.findElement(cartConfirmationMessage).isDisplayed();
    }
}
