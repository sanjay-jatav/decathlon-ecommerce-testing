package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    WebDriver driver;
    String url = "https://www.decathlon.in/";
    By logo = By.xpath("//a[@class='ml-3 cursor-default md:ml-6 lg:ml-12']");
    By banner = By.xpath("(//img[@alt='BannerV1'])[1]");
    By allBanners = By.xpath("//img[@alt='BannerV1']");
    By navmenu = By.xpath("//button[@aria-label='mega-menu']");
    By navItems = By.xpath("//a[contains(text(),'Men') or contains(text(),'Women') or contains(text(),'Kids') or contains(text(),'Sports') or contains(text(),'Gift Cards')]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    // Visit the home page
    public void visitHomepage() {
        driver.get(url);
    }

    // Return the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Check if logo is displayed
    public boolean isLogoVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    // Check Banner is visible
    public boolean isBannerVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(banner)).isDisplayed();
    }

    // Get current banner image link through src tag
    public String getCurrentBannertImage() {
        return driver.findElement(banner).getAttribute("src");
    }

    // Check all banners are clickable 
    public boolean areAllBannersClickable() {
        List<WebElement> banners = driver.findElements(allBanners);
        for(WebElement b: banners) {
            String link = b.findElement(By.xpath("ancestor::a")).getAttribute("href");
            if(link == null || link.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Check if Navigation Menu is visible
    public boolean isNavigationMenuVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(navmenu)).isDisplayed();
    }

    // Check if Expected Menu Items are visible
    public boolean areExpectedMenuItemsVisible(List<String> expectedItems) {
        List<WebElement> items = driver.findElements(navItems);
        List<String> visibleTexts = items.stream().map(WebElement::getText).collect(Collectors.toList());

        return visibleTexts.containsAll(expectedItems);
    }
}
