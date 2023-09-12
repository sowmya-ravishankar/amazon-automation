package in.assignment.test;

import TestDataProvider.DataProviderClass;
import in.assignment.ecom.pom.HomePage;
import in.assignment.ecom.pom.ProductPage;
import in.assignment.ecom.pom.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static listeners.ExtentReports.ExtentTestManager.startTest;

public class AddToCart extends TestBase {
    public WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    String baseURL = "http://www.amazon.in";

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void nameBefore(Method method)
    {
        startTest(method.getName());
    }

    @Test(priority = 0)
    public void verifyPageTitle() {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.waitAndGetPageTitle(), "Amazon.in","Page Title is incorrect");
    }

    @Test
    public void searchProduct() {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        homePage.enterTextInSearchBox();
        homePage.clickOnSearchIcon();
        Assert.assertEquals(searchResultsPage.verifyUserIsOnSearchResultsPage(),"Results", "User is not on the search results page");
    }

    @Test(dependsOnMethods = {"searchProduct"}, dataProvider="BrandProvider",dataProviderClass= DataProviderClass.class)
    public void filterProductAndAddToCart(String brand)  {
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        searchResultsPage.selectBrand(brand);
        searchResultsPage.setPriceFilter();
        Assert.assertTrue(searchResultsPage.isPriceFilterAppliedCorrectly(), "Filter is not applied correctly");
        searchResultsPage.sortFromHighToLow();
        searchResultsPage.clickOnHighestPricedItem();
        productPage.verifyProductTitle();
        productPage.clickOnAddToCartBtn();
        Assert.assertEquals(productPage.verifyAddedToCart(),"Added to Cart", "Product is not added to cart");
        productPage.closeWindow();
        searchResultsPage.clearBrandFilter();
        searchResultsPage.clearPriceFilter();
    }
}
