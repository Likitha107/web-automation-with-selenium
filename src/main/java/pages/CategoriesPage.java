package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends BaseClass{

    public CategoriesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="(//h2[contains(text(),'Flowers')]//following::div//child::a)[2]")
    WebElement edit;

    @FindBy(xpath="(//a[contains(text(),'Dalhia')]//following::a)[1]")
    WebElement floweredit;

    @FindBy(xpath="//a[@id='tabheader-details']")
    WebElement details;

    @FindBy(xpath="//input[@name='price']")
    WebElement price;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement savebtn;

    @FindBy(xpath = "//div[text()='Poster updated']")
    WebElement editsuccess;

    @FindBy(xpath = "(//a[contains(text(),'Dalhia')]//following::td/span)[1]")
    WebElement aftereditprice;

    public boolean editCategory(int priceamt) throws InterruptedException {
        waitForVisiblity(edit,40).click();
        waitForVisiblity(floweredit,30).click();
        waitForVisiblity(details,40).click();
        waitForVisiblity(price,40).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        Thread.sleep(200);
        System.out.println(String.valueOf(priceamt));
        waitForVisiblity(price,40).sendKeys(String.valueOf(priceamt));
        waitForVisiblity(savebtn,30).click();
        return waitForVisiblity(editsuccess,30).isDisplayed();
    }

    public boolean afterEditCategory(int priceamount){
        waitForVisiblity(edit,30).click();
        String afterprice=waitForVisiblity(aftereditprice,30).getText();
        int priceupdated= (int) Double.parseDouble(afterprice.replace("$"," ").trim());
        if(priceupdated==priceamount) {
            return true;
        }
        else return false;
    }
}
