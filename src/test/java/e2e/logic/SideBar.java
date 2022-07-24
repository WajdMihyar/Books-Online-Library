package e2e.logic;

import com.learning.atypon.spring.mvc.constants.selenium.Driver;
import e2e.pages.BooksPage;
import e2e.pages.HomePage;
import e2e.pages.SideBarPageSection;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class SideBar extends Driver {

    @Test(description = "Verify that when user clicks on Home link, user will get redirected back to home")
    public void verifyNavigatingToHomeSuccessfully() {
        HomePage homepage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        SideBarPageSection sideBar = new SideBarPageSection(driver);
        sideBar.clickHomeLink();
        softAssert.assertTrue(homepage.welcomeMessage.equals("Hello Test Automation Engineer!!"));
    }

    @Test(description = "Verify that when user clicks on Books link, user will get redirected to Books page")
    public void verifyNavigatingToBooksSuccessfully() {
        SideBarPageSection sideBar = new SideBarPageSection(driver);
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        sideBar.clickBooksLink();
        softAssert.assertTrue(booksPage.booksPageTitle.getText().equals("Books"));
    }

    @Ignore("API is returning error 404")
    @Test(description = "Verify that when user clicks on Authors link, user will get redirected to Authors page")
    public void verifyNavigatingToAuthorsSuccessfully() {
        SideBarPageSection sideBar = new SideBarPageSection(driver);
        SoftAssert softAssert = new SoftAssert();
        sideBar.clickAuthorsLink();
    }
}
