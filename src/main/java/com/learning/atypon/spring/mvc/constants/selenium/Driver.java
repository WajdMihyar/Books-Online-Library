package com.learning.atypon.spring.mvc.constants.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class Driver {

    public static WebDriver driver;
    public static String url = "http://localhost:8080/";


    @BeforeTest
    public void seleniumChromeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }



}
