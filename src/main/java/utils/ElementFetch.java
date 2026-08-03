package utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BaseTest;

public class ElementFetch {

    public void handleVignetteAd() {
        if (BaseTest.driver.getCurrentUrl().contains("#google_vignette")) {
            BaseTest.driver.navigate().refresh();
        }
    }

    public WebElement getXPATHWebElement(String identifierValue) {
        handleVignetteAd();
        return BaseTest.driver.findElement(By.xpath(identifierValue));
    }

    public List<WebElement> getXPATHWebElements(String identifierValue) {
        handleVignetteAd();
        return BaseTest.driver.findElements(By.xpath(identifierValue));
    }

    public WebElement getWebElement(String identifierType, String identifierValue) {
        handleVignetteAd();
        return BaseTest.driver.findElement(By.xpath(identifierValue));
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        handleVignetteAd();
        return BaseTest.driver.findElements(By.xpath(identifierValue));
    }
}