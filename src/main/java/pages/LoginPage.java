package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentAllPages {

    @FindBy(xpath = ".//input[@placeholder='Email']")
    private WebElement inputUserEmail;

    @FindBy(xpath = ".//input[@type='password' ]")
    private WebElement inputPassword;


    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeURL() { //зробили геттер бо є абстрактний клас
        return "/";
    }


    public void openLoginPage() {
        try {
            //webDriver.get("https://phptravels.net/login");
            webDriver.get("https://phptravels.net/admin");
            logger.info("Login page is opened");
        } catch (Exception e) {
            logger.error("Cannot open Login page" + e);
            Assert.fail("Cannot open Login page" + e);
        }
    }

    public void enterUserEmailIntoInputEmail(String userEmail) {

        enterTextIntoElement(inputUserEmail, userEmail);

        }


    public void enterUserPasswordIntoInputEmail(String password) {
        enterTextIntoElement(inputPassword, password);


    }

    public void clickOnLoginButton() {
        clickOnElement(buttonLogin);
    }
    public boolean isButtonSignInDisplayed() {

        return isElementDisplayed(buttonLogin);
    }
}
