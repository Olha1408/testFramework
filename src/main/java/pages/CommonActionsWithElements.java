package pages;


import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait10, webDriverWait15;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);


    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }


    protected void enterTextIntoElement(WebElement webElement, String text) {

        try {

            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));

            webElement.clear();
            webElement.sendKeys(text);

            logger.info(text + " Was inputted in to element" );
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }
    }
    private String getElementName(WebElement webElement) {

        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return " ";
        }
    }
    protected void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }


}
