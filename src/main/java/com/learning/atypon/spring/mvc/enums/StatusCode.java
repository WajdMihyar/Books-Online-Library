package com.learning.atypon.spring.mvc.enums;

/**
 * @author Wajd Mihyar
 */

//enum has all Http status codes
public enum StatusCode {

    OK(200, "OK"),

    CREATED(201, "Created"),

    ACCEPTED(202, "Accepted"),

    NON_AUTHORITATIVE_INFORMATION(203, "Non-authoritative Information"),

    NO_CONTENT(204, "No Content"),

    FOUND(302, "Found"),
    //Client Error
    BAD_REQUEST(400, "Bad Request"),

    UNAUTHORIZED(401, "Unauthorized"),

    FORBIDDEN(403, "Forbidden"),

    NOT_FOUND(404, "Not Found"),

    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    NOT_ACCEPTABLE(406, "Not Acceptable"),

    REQUEST_TIMEOUT(408, "Request Timeout"),

    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),

    EXPECTATION_FAILED(417, "Expectation Failed"),

    LOCKED(423, "Locked"),

    FAILED_DEPENDENCY(424, "Failed Dependency"),

    TOO_MANY_REQUESTS(429, "Too Many Requests"),

    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),

    //Server Error
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    NOT_IMPLEMENTED(501, "Not Implemented"),

    BAD_GATEWAY(502, "Bad Gateway"),

    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    GATEWAY_TIMEOUT(504, "Gateway Timeout"),

    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),

    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");

    private final int value;
    private final String description;

    StatusCode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}