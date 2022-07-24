package e2e.logic;

import com.learning.atypon.spring.mvc.constants.Endpoints;
import com.learning.atypon.spring.mvc.constants.selenium.Driver;

import com.learning.atypon.spring.mvc.enums.StatusCode;
import com.learning.atypon.spring.mvc.helpers.AssertionHelper;
import com.learning.atypon.spring.mvc.helpers.RequestHelper;
import e2e.pages.BooksPage;
import e2e.pages.SideBarPageSection;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;


/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class Books extends Driver {


    @BeforeMethod
    public void navigateToBooksPage() {
        SideBarPageSection sideBar = new SideBarPageSection(driver);
        sideBar.clickBooksLink();
    }

    @Test(description = "Verify that books in books page matches API response")
    public static void verifyDisplayingBooksSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        Response response = RequestHelper.get(Endpoints.BOOKS_API);
        AssertionHelper.commonSuccessAssertions(StatusCode.OK.getValue(), response);
        ResponseBody body = response.getBody();
        List<String> books = body.htmlPath().getList("html.body.div.div.div.table.tbody.tr.td");
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> booksList = booksPage.booksTableList;
        softAssert.assertTrue(books.contains(booksList));
    }

    @Test(description = "Verify that when user clicks on Edit, user will get redirected to edit book")
    public void verifyNavigatingEditBookPageSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        booksPage.clickEditBookButton();
        softAssert.assertTrue(booksPage.booksPageTitle.equals("Edit Book"));
    }

    @Test(description = "Verify that when user clicks on Create, user will get redirected to create book")
    public void verifyNavigatingToCreateBookPageSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        booksPage.clickCreateBookButton();
        softAssert.assertTrue(booksPage.booksPageTitle.getText().equals("Create Book"));
    }

    @Test(description = "Verify that when user deletes a book, books list will get updated successfully")
    public void verifyDeletingBookSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        int beforeDeletionSize = booksPage.booksTableList.size();
        booksPage.clickDeleteBookButton();
        int afterDeletionSize = booksPage.booksTableList.size();
        softAssert.assertTrue(beforeDeletionSize == afterDeletionSize - 1);
    }

    @Test(description = "Verify creating a book successfully")
    public void verifyCreatingBookSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        booksPage.clickCreateBookButton();
        String bookTitle = "ThisIsAbookName";
        String bookYear = "2005";
        booksPage.fillTitleField(bookTitle);
        booksPage.fillYearField(bookYear);
        booksPage.clickSaveNewBookButton();
        List<WebElement> updatedBooksPage = booksPage.booksTableList;
        softAssert.assertTrue(updatedBooksPage.contains(bookTitle));
    }


    @Test(description = "Verify editing a book successfully")
    public void verifyEditingBookSuccessfully() {
        BooksPage booksPage = new BooksPage(driver);
        SoftAssert softAssert = new SoftAssert();
        booksPage.clickEditBookButton();
        String bookTitle = "ThisIsAnEditedBookName";
        String bookYear = "2010";
        booksPage.fillTitleField(bookTitle);
        booksPage.fillYearField(bookYear);
        booksPage.clickSaveNewBookButton();
        List<WebElement> updatedBooksPage = booksPage.booksTableList;
        softAssert.assertTrue(updatedBooksPage.contains(bookTitle));
    }

}
