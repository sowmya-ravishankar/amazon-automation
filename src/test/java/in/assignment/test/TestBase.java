package in.assignment.test;

import in.assignment.ecom.config.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import java.util.Objects;


public class TestBase {

    private WebDriver driver;
    TestData testData;

    @BeforeSuite
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        if(Objects.equals(browser, "Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(Objects.equals(browser, "Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(Objects.equals(browser, "Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(Objects.equals(browser, "Safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
    }

    @BeforeSuite
    @Parameters({"testDataFile"})
    public void setUpTestData(String testDataFile) {
        testData = new TestData();
        testData.setTestData(testDataFile);
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

