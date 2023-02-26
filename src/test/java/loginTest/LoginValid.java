package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginValid extends BaseTest {

    @Test
    public void login() {
        loginPage.openLoginPage();
        loginPage.enterUserEmailIntoInputEmail("agent@phptravels.com");
        loginPage.enterUserPasswordIntoInputEmail("demoagent");
        loginPage.clickOnLoginButton();



    }

}
