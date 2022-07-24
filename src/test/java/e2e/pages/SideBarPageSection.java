package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class SideBarPageSection {

    public SideBarPageSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/ul/li[1]/a")
    public WebElement homeLink;

    @FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/a")
    public WebElement booksLink;

    @FindBy(xpath = "/html/body/div/div/div[1]/ul/li[3]/a")
    public WebElement authorsLink;

    public void clickHomeLink() {
        homeLink.click();
    }
    public void clickBooksLink() {
        booksLink.click();
    }
    public void clickAuthorsLink() {
        authorsLink.click();
    }

}
