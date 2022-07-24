package com.learning.atypon.spring.mvc.constants;

/**
 * @author Wajd Mihyar
 * @date 2/27/2022 10:19 AM
 * The Endpoint class contains endpoints for all APIs
 */
public class Endpoints {

    public static final String HOST;
    public static final String BOOKS_API;
    public static final String DELETE_BOOK_API;
    public static final String AUTHORS_API;
    public static final String SEARCH_API;


    static {
        HOST = "http://localhost:8080/";
        BOOKS_API = HOST + "books";
        DELETE_BOOK_API = HOST + "books/*/delete";
        AUTHORS_API = HOST + "authors";
       SEARCH_API = HOST + "search";


    }
}
