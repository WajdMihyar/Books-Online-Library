package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Wajd Mihyar
 * @Date 7/23/2022
 */
public class MenuPageSection {
    public MenuPageSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[1]/a")
    public WebElement homeTab;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[2]/a")
    public WebElement booksTab;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[3]/a")
    public WebElement authorsTab;

    @FindBy(xpath = "//*[@id=\"searchID\"]")
    public WebElement searchInputBox;

    @FindBy(xpath = "//*[@id=\"searchForm\"]/button")
    public WebElement searchButton;

    public void clickHomeTab() {
        homeTab.click();
    }

    public void clickBooksTab() {
        booksTab.click();
    }

    public void clickAuthorsTab() {
        authorsTab.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void fillSearchField(String searchKey) {
        searchInputBox.sendKeys(searchKey);
    }

}
