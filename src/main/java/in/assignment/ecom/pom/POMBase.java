package in.assignment.ecom.pom;


import com.beust.jcommander.internal.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class POMBase {
    protected WebDriver driver;
    static Logger LOGGER = LogManager.getLogger();
    protected int waitTimeInSec = 5;
    public POMBase(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element) {
        Actions a = new Actions(driver);
        a.moveToElement(element);
        a.perform();
    }

    public WebElement findElementByLocatorWithParameter(String param, By locator) {
        By xpathWithParam = By.id(String.format(String.valueOf(locator), param));
        String xpath = xpathWithParam.toString().replaceAll("By.id: By.xpath: ","");
        return driver.findElement(By.xpath(xpath));
    }

    public void waitForElement(WebDriver driver, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void switchToNewTab() {
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public void switchToPreviousTab() {
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(0));
    }

}
