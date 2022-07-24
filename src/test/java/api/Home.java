package api;

import com.learning.atypon.spring.mvc.constants.Endpoints;
import com.learning.atypon.spring.mvc.constants.ErrorMessages;
import com.learning.atypon.spring.mvc.enums.StatusCode;
import com.learning.atypon.spring.mvc.helpers.AssertionHelper;
import com.learning.atypon.spring.mvc.helpers.RequestHelper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Wajd Mihyar
 * @Date 7/22/2022
 */
public class Home {

    @Test(description = "Verify displaying Home successfully")
    public void verifyDisplayingHomeSuccessfully() {
        String welcomeMessage = "Hello Test Automation Engineer!!";
        Response response = RequestHelper.get(Endpoints.HOST);
        ResponseBody body = response.getBody();
        AssertionHelper.commonSuccessAssertions(StatusCode.OK.getValue(), response);
        Assert.assertNotNull(body, ErrorMessages.NULL_RESPONSE);
        Assert.assertTrue(body.asString().contains(welcomeMessage));
    }
}
