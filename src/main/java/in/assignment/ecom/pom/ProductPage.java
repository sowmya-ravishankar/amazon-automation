package in.assignment.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends POMBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By productTitle = By.xpath("//span[@id=\"productTitle\"]");
    By addToCartBtn = By.xpath("//input[@id=\"add-to-cart-button\"]");
    By addedToCartText = By.xpath("//div[@id=\"attachDisplayAddBaseAlert\"]//h4");

    public void verifyProductTitle() {
        switchToNewTab();
        driver.findElement(productTitle).isDisplayed();
    }

    public void clickOnAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

    public String verifyAddedToCart() {
        waitForElement(driver, addedToCartText);
        return driver.findElement(addedToCartText).getText();
    }

    public void closeWindow() {
        driver.close();
        switchToPreviousTab();
    }

}
