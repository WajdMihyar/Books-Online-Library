package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div/div/div[2]")
    public WebElement welcomeMessage;

}
