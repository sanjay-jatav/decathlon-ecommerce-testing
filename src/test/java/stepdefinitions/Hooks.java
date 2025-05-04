package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;
import utils.ExtentManager;

public class Hooks {

    @Before
    public void setUp() {
        // Initialize WebDriver
        DriverManager.getDriver();

        // Initialize ExtentReports instance (optional: only needed if ExtentReports initialization is required here)
        ExtentManager.getInstance();
    }

    @After
    public void tearDown() {
        // Quit WebDriver
        DriverManager.quitDriver();

        // Flush ExtentReports
        ExtentManager.flushReports();
    }
}
