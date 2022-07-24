package e2e.logic;

import com.learning.atypon.spring.mvc.constants.selenium.Driver;
import e2e.pages.BooksPage;
import e2e.pages.HomePage;
import e2e.pages.MenuPageSection;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class Menu extends Driver {

    @Test(description = "Verify that when user clicks on Home from menu, user will get redirected back to home")
    public void verifyNavigatingToHomeFromMenuSuccessfully() {
        HomePage homepage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        MenuPageSection menu = new MenuPageSection(driver);
        menu.clickHomeTab();
        softAssert.assertTrue(homepage.welcomeMessage.equals("Hello Test Automation Engineer!!"));
    }

    @Test(description = "Verify that when user clicks on Books from menu, user will get redirected to Books page")
    public void verifyNavigatingToBooksFromMenuSuccessfully() {
        MenuPageSection menu = new MenuPageSection(driver);
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        menu.clickBooksTab();
        softAssert.assertTrue(booksPage.booksPageTitle.getText().equals("Books"));
    }

    @Ignore("API is returning error 404")
    @Test(description = "Verify that when user clicks on Authors from menu, user will get redirected to Authors page")
    public void verifyNavigatingToAuthorsFromMenuSuccessfully() {
        MenuPageSection menu = new MenuPageSection(driver);
        SoftAssert softAssert = new SoftAssert();
        menu.clickAuthorsTab();
    }

    @Ignore("API is returning error 404")
    @Test(description = "Verify searching for a book successfully")
    public void verifySearchingForAbookSuccessfully() {
        MenuPageSection menu = new MenuPageSection(driver);
        SoftAssert softAssert = new SoftAssert();
        menu.fillSearchField("bookName");
        menu.clickSearchButton();
    }
}
