package com.learning.atypon.spring.mvc.helpers;

import com.learning.atypon.spring.mvc.constants.Constants;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * @author Wajd Mihyar
 * @date 5/22/2022 12:28 PM
 */
public class AssertionHelper {
    private static SoftAssert softAssert = new SoftAssert();

    public static void commonSuccessAssertions( int expectedCode , Response response) {
        Assert.assertNotNull(response, "Response was null");
        ResponseBody body = response.getBody();
        Assert.assertNotNull(body, "response body was null");
        Assert.assertEquals(response.statusCode(),expectedCode, "Status code must be "+ expectedCode );
        softAssert.assertTrue(response.getTime() < Constants.EXPECTED_RESPONSE_TIME, "response time should be less than 500");
        softAssert.assertAll();

    }

//    public static void commonFailedAssertions(Response response) {
//        Assert.assertNotNull(response, "Response was null");
//        ResponseBody body = response.getBody();
//        Assert.assertNotNull(body, "response body was null");
//
//        softAssert.assertTrue(response.getStatusLine().contains(StatusCode.OK.getDescription()), "Status line must be OK");
//        softAssert.assertTrue(response.getTime() < Constant.EXPECTED_RESPONSE_TIME, "response time must be less than 500");
//        Assert.assertEquals(response.statusCode(), StatusCode.OK.getValue(), "Status code must be 200");
//        Assert.assertEquals(ResponseHelper.getString(body, Path.SUCCESS_STATUS), Constant.EXPECTED_FAILURE_STATUS, "response status must be true but failed because" + ResponseHelper.getString(body, Path.ERROR_DESCRIPTION ));
//
//    }


}
