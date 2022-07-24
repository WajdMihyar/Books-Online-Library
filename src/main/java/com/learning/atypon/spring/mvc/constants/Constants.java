package com.learning.atypon.spring.mvc.constants;

/**
 * @author Wajd Mihyar
 * The Constant class contains constants that are generic
 */
public class Constants {

    public static final String CONTENT_TYPE;
    public static final String JSON_CONTENT_TYPE;
    public static final String AUTHORIZATION;
    public static final String BEARER;
    public static final String EXPECTED_SUCCESS_STATUS;
    public static final String EXPECTED_FAILURE_STATUS;
    public static final int EXPECTED_RESPONSE_TIME;
    public static final String LANGUAGE;
    public static final String ARABIC;
    public static final String ENGLISH;
    public static final String JWT;
    public static final String REFRESH_TOKEN;
    public static final String PASSWORD;
    public static final String VALIDATION_UID;
    public static final String ERROR_MSG;
    public static final String ID;
    public static final String ACCOUNT_NUMBER;
    public static final String BENEFICIARY_ID;
    public static final String VALIDATE_ID;
    public static final String DESCRIPTION;

    static {
        CONTENT_TYPE = "Content-Type";
        JSON_CONTENT_TYPE = "application/json";
        LANGUAGE = "Language";
        ARABIC = "ar";
        ENGLISH = "en";
        AUTHORIZATION = "Authorization";
        BEARER = "Bearer ";
        EXPECTED_SUCCESS_STATUS = "true";
        EXPECTED_FAILURE_STATUS = "false";
        EXPECTED_RESPONSE_TIME = 7000000;
        JWT = "jwt";
        REFRESH_TOKEN = "refreshToken";
        PASSWORD = "password";
        VALIDATION_UID = "validationUID";
        ERROR_MSG = "";
        ID = "id";
        ACCOUNT_NUMBER = "accountNumber";

        BENEFICIARY_ID = "beneficiaryID";
        VALIDATE_ID = "validateID";
        DESCRIPTION = "Description";
    }
}