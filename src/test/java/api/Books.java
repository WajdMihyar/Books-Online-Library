package api;

import com.learning.atypon.spring.mvc.constants.Endpoints;
import com.learning.atypon.spring.mvc.constants.ErrorMessages;
import com.learning.atypon.spring.mvc.enums.StatusCode;
import com.learning.atypon.spring.mvc.helpers.AssertionHelper;
import com.learning.atypon.spring.mvc.helpers.RequestHelper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Wajd Mihyar
 * @Date 7/18/2022
 */
public class Books {

    @Test(description = "Verify that the get books API will return books as expected")
    public void verifyGettingBooksSuccessfully(ITestContext context) {
        Response response = RequestHelper.get(Endpoints.BOOKS_API);
        AssertionHelper.commonSuccessAssertions(StatusCode.OK.getValue(), response);
        ResponseBody body = response.getBody();
        Assert.assertNotNull(body, ErrorMessages.NULL_RESPONSE);
        String bookId = body.htmlPath().getString("html.body.div.div.div.table.tbody.tr.td.a[1].@href").replaceAll("[^0-9]", "");
        String bookName = body.htmlPath().getString("html.body.div.div.div.table.tbody.tr.td[0]");
        context.getSuite().setAttribute("bookId", bookId);
        context.getSuite().setAttribute("bookName", bookName);
    }

    @Test(description = "Verify that the create books API will create a book successfully")
    public void verifyCreatingBooksSuccessfully() {
        //Making request
        String title = "thisIsAtest";
        String year = "1998";
        Response response = RequestHelper.post(title, year, Endpoints.BOOKS_API);
        AssertionHelper.commonSuccessAssertions(StatusCode.FOUND.getValue(), response);
        Response booksResponse = RequestHelper.get(Endpoints.BOOKS_API);
        List<String> booksUpdated = booksResponse.htmlPath().getList("html.body.div.div.div.table.tbody.tr.td");
        Assert.assertTrue(booksUpdated.contains(" "+title));
    }


    @Test(description = "Verify deleting a book successfully", dependsOnMethods = {"verifyCreatingBooksSuccessfully", "verifyGettingBooksSuccessfully"})
    public void verifyDeletingBookSuccessfully(ITestContext context) {
        Response response = RequestHelper.get((String) context.getSuite().getAttribute("bookId"), Endpoints.DELETE_BOOK_API);
        ResponseBody body = response.getBody();
        AssertionHelper.commonSuccessAssertions(StatusCode.OK.getValue(), response);
        List<String> booksUpdated = body.htmlPath().getList("html.body.div.div.div.table.tbody.tr.td");
        Assert.assertFalse(booksUpdated.contains((String) context.getSuite().getAttribute("bookName")));
    }


    @Test(description = "Verify editing a book successfully", dependsOnMethods = {"verifyCreatingBooksSuccessfully", "verifyGettingBooksSuccessfully"})
    public void verifyEditingBookSuccessfully(ITestContext context) {
        String newTitle = "updatedTitledededeeffrfr";
        String newYear = "1000";
        Response response = RequestHelper.post((String) context.getSuite().getAttribute("bookId"),newTitle, newYear, Endpoints.BOOKS_API);
        AssertionHelper.commonSuccessAssertions(StatusCode.FOUND.getValue(), response);
        Response booksResponse = RequestHelper.get(Endpoints.BOOKS_API);
        List<String> booksUpdated = booksResponse.htmlPath().getList("html.body.div.div.div.table.tbody.tr.td");
        Assert.assertTrue(booksUpdated.contains(" "+newTitle));
    }
}
