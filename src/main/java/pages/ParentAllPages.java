package pages;

import org.apache.log4j.Logger;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ParentAllPages extends CommonActionsWithElements {
    protected String base_url;

    public ParentAllPages(WebDriver webDriver) {
        super(webDriver);
        base_url = configProperties.base_url().replace("[env]", System.getProperty("env", "qa"));
    }

    abstract String getRelativeURL();





}
