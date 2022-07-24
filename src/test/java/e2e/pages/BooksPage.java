package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.learning.atypon.spring.mvc.constants.selenium.Wait.*;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class BooksPage {
    public BooksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-header")
    public WebElement booksPageTitle;

    @FindBy(className = "page-header")
    public WebElement editBookPageTitle;

    @FindBy(className = "page-header")
    public WebElement createBookPageTitle;
    @FindBy(linkText = "Edit")
    public WebElement editBookButton;
    @FindBy(linkText = "Delete")
    public WebElement deleteBookButton;

    @FindBy(linkText = "Create Book")
    public WebElement createBookButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/table/tbody/tr")
    public List<WebElement> booksTableList;

    @FindBy(id = "title")
    public WebElement titleInputTextBox;

    @FindBy(id = "year")
    public WebElement yearInputTextBox;

    @FindBy(xpath = "/html/body/div/div/div[2]/form/div[2]/button[1]")
    public WebElement saveBookButton;

    public void clickEditBookButton() {
        waitTillElementVisible(editBookButton, Long.valueOf(5)).click();
    }

    public void clickDeleteBookButton() {
        waitTillElementVisible(deleteBookButton, Long.valueOf(5)).click();
    }

    public void clickCreateBookButton() {
        waitTillElementVisible(createBookButton, Long.valueOf(5)).click();
    }

    public void fillTitleField(String title) {
        titleInputTextBox.sendKeys(title);
    }

    public void fillYearField(String year) {
        yearInputTextBox.sendKeys(year);
    }

    public void clickSaveNewBookButton() {
        waitTillElementVisible(saveBookButton, Long.valueOf(5)).click();

    }
}
