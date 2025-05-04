package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }
    
    String url = "https://www.decathlon.in/";
    By menCategoryFilter = By.xpath("//span[contains(text(), 'Men')]");
    By sortByPriceLowToHigh = By.xpath("//select[@id='sort-by']");
    By productList = By.xpath("//li[@class=\"ais-InfiniteHits-item\"]");
    By firstProduct = By.cssSelector(".product-list-item:first-child");

    public void visit() {
    	driver.get(url);
    }
    
    public void applyMenFilter() {
        driver.findElement(menCategoryFilter).click();
    }
    
  
    public void sortByLowToHigh() {
        driver.findElement(sortByPriceLowToHigh).sendKeys("Price: Low to High");
    }

    public boolean isProductListDisplayed() {
        return driver.findElements(productList).size() > 0;
    }

    public void clickOnFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}
