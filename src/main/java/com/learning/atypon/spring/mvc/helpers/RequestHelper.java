package com.learning.atypon.spring.mvc.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Wajd Mihyar
 * @Date 7/18/2022
 */

public class RequestHelper {
    private static String errorMsg = "";

    public static Response get(String url) {
        try {
            return RestAssured.given().that().and().when()
                    .get(url).thenReturn();

        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;

        }

    }
    public static Response getBySearchKey(String searchId, String url) {
        try {
            return RestAssured.given().that().and().queryParams("searchId",searchId).when()
                    .get(url).thenReturn();

        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;

        }

    }

    public static Response get(String id, String url) {
        try {
            return RestAssured.given().that().and().when()
                    .get(url.replace("*", id)).thenReturn();

        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;

        }

    }

    public static Response post(String title, String year, String url) {
        try {
            return RestAssured.given()
                    .queryParams("title", title, "year", year)
                    .when()
                    .post(url).thenReturn();

        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;

        }

    }
    public static Response post(String id, String title, String year, String url) {
        try {
            return RestAssured.given()
                    .queryParams("id",id,"title", title, "year", year)
                    .when()
                    .post(url).thenReturn();

        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;

        }

    }
}