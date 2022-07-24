package com.learning.atypon.spring.mvc.constants.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class Wait extends Driver {
    private static WebDriverWait wait;

    public static WebElement waitTillElementVisible(WebElement element, Long duration) {
        wait = new WebDriverWait(driver, duration);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

