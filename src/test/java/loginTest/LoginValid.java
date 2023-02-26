package loginTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginValid extends BaseTest {

    @Test
    public void login() {
        loginPage.openLoginPage();
        loginPage.enterUserEmailIntoInputEmail("agent@phptravels.com");
        loginPage.enterUserPasswordIntoInputEmail("demoagent");
        loginPage.clickOnLoginButton();

        // Assert.assertTrue("button missed", homepage);


    }

    public void loginAdmin() {
        loginPage.openLoginPage();
        loginPage.enterUserEmailIntoInputEmail("admin@phptravels.com");
        loginPage.enterUserPasswordIntoInputEmail("demoadmin");
        loginPage.clickOnLoginButton();

    }
}
