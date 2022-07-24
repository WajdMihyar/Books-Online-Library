package e2e.logic;

import com.learning.atypon.spring.mvc.constants.selenium.Driver;
import e2e.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class Home extends Driver {

    @Test(description = "Verify that the welcome message appears correctly")
    public void verifyHomePageTitleAppearsCorrect()  {
        HomePage homepage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homepage.welcomeMessage.equals("Hello Test Automation Engineer!!"));
    }
}
