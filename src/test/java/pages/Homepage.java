package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Homepage {
    WebDriver driver;
    private Actions actions;

    // 🔒 Private locators
    private By searchBar = By.cssSelector("button[data-testid='search-button']");
    private By searchInput = By.cssSelector("input[data-testid='search-input']");
    private By navMenuButton = By.xpath("//button[@aria-label='mega-menu']");
    private By navMenuItems = By.xpath("//div[contains(@class,'mega-menu')]//div[contains(@class,'category-title')]");
    private By subCategories = By.xpath("//div[@class='px-6 cursor-pointer text-grey-700']");
    private By banner = By.xpath("//div[@class='swiper-wrapper']");
    

    // 👨‍🔧 Constructor
    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // 🔍 Search using ENTER key
    public void searchUsingEnterKey(String query) {
        driver.findElement(searchBar).sendKeys(query + Keys.ENTER);
    }

    // 🖱️ Navigation menu button
    public void clickNavMenuButton() {
        driver.findElement(navMenuButton).click();
    }

    // 📋 Top-level navigation menu items
    public List<WebElement> getNavMenuItems() {
        return driver.findElements(navMenuItems);
    }

    // 📂 Subcategories
    public List<WebElement> getSubCategories() {
        return driver.findElements(subCategories);
    }

    public void clickSubCategory(String subCategoryName) {
        for (WebElement item : getSubCategories()) {
            if (item.getText().equalsIgnoreCase(subCategoryName)) {
                item.click();
                break;
            }
        }
    }

    // 📸 Banner interactions
    public boolean isBannerDisplayed() {
        return driver.findElement(banner).isDisplayed();
    }

    public void clickBanner() {
        driver.findElement(banner).click();
    }

    public String getBannerContent() {
        return driver.findElement(banner).getAttribute("innerHTML");
    }

    // ✅ Page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}
