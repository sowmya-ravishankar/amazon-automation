package in.assignment.ecom.pom;

import in.assignment.ecom.config.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import java.util.List;
import java.util.Objects;


public class HomePage extends POMBase{
    TestData testData = new TestData();
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By pageTitle = By.id("nav-logo-sprites");
    By searchBox = By.id("twotabsearchtextbox");
    By searchIcon = By.id("nav-search-submit-button");

    public String waitAndGetPageTitle() {
        LOGGER.info("Wait for page to load and get Page Title");
        boolean result;

        result = driver.findElement(pageTitle).isDisplayed();
        Assert.assertTrue(result, "Page Title is not displayed");

        return driver.findElement(pageTitle).getAttribute("aria-label");
    }

    public Boolean getSearchBox() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public void enterTextInSearchBox() {
        String searchKey = testData.getValueFromTestDataFile("searchKey");
        driver.findElement(searchBox).sendKeys(searchKey);
    }

    public void clickOnSearchIcon() {
        driver.findElement(searchIcon).click();
    }

}
