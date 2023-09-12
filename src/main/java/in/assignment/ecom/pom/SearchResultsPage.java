package in.assignment.ecom.pom;

import in.assignment.ecom.config.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class SearchResultsPage extends POMBase{
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    TestData testData = new TestData();
    By resultsHeader = By.xpath("(//span[@class=\"a-size-medium-plus a-color-base a-text-bold\"])[1]");
    By brandFilterTitle = By.id("p_89-title");
    By priceFilterTitle = By.id("p_36-title");
    By dealsAndDiscountsFilter = By.xpath("//*[contains(text(),\"Deals & Discounts\")]");
    By allBrands = By.xpath("//div[@id=\"brandsRefinements\"]//ul//li");
    By checkBox = By.xpath("//div[@id='brandsRefinements']//ul//li[@aria-label='%s']/span//label/i");
    By priceFilter1 = By.xpath("//*[contains(text(),\"₹1,000 - ₹5,000\")]");
    By productPrice = By.className("a-price-whole");
    By sortBy = By.className("a-dropdown-label");
    By sortByValue = By.className("a-dropdown-prompt");
    By priceHighToLowSort = By.id("s-result-sort-select_2");
    By highestPricedInList = By.xpath("(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[1]");
    By clearAppliedFilter = By.xpath("//*[contains(text(),\"Clear\")]");
    By anyPriceOption = By.xpath("//*[contains(text(),\"Any Price\")]");

    public String verifyUserIsOnSearchResultsPage() {
        return driver.findElement(resultsHeader).getText();
    }

    public void selectBrand(String brandName)  {
        waitForElement(driver,priceFilterTitle);
        WebElement element = driver.findElement(priceFilterTitle);
        scrollToElement(element);
        List<WebElement> brands = driver.findElements(allBrands);

        for(WebElement brand : brands) {
            if(Objects.equals(brand.getAttribute("aria-label"), brandName)) {
                findElementByLocatorWithParameter(brandName, checkBox).click();
                break;
            }

        }
    }

    public void setPriceFilter() {
        waitForElement(driver, highestPricedInList);

        waitForElement(driver,priceFilterTitle);
        WebElement element = driver.findElement(priceFilterTitle);
        scrollToElement(element);

        WebElement ele = driver.findElement(priceFilter1);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();

    }

    public Boolean isPriceFilterAppliedCorrectly() {
        List<WebElement> prices = driver.findElements(productPrice);
        for(WebElement price: prices) {
            if(Integer.parseInt(price.getText().replaceAll(",","")) > 5000 || Integer.parseInt(price.getText().replaceAll(",","")) < 1000) {
                return false;
            }
        }
        return true;
    }

    public void sortFromHighToLow() {
        if(!Objects.equals(driver.findElement(sortByValue).getText(), "Price: High to Low")) {
            driver.findElement(sortBy).click();
            driver.findElement(priceHighToLowSort).click();
        }
    }

    public void clickOnHighestPricedItem() {
        waitForElement(driver, highestPricedInList);
        driver.findElement(highestPricedInList).click();
    }

    public void clearBrandFilter() {

        waitForElement(driver,highestPricedInList);
        waitForElement(driver,clearAppliedFilter);
        driver.findElement(clearAppliedFilter).click();
    }

    public void clearPriceFilter() {
        waitForElement(driver,highestPricedInList);
        waitForElement(driver,priceFilterTitle);
        WebElement element = driver.findElement(priceFilterTitle);
        scrollToElement(element);
        driver.findElement(anyPriceOption).click();
    }

}
