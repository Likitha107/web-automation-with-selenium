package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass{

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    WebElement dashboard;

    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    WebElement customer;

    @FindBy(xpath = "//a[contains(text(),'Create')]")
    WebElement create;

    @FindBy(xpath = "//a[contains(text(),'Categories')]")
    WebElement categories;

    public String getDashboard(){
        waitForVisiblity(dashboard, 25);
        return dashboard.getText();
    }
   
	 

    public CategoriesPage clickCategory(){
        waitForVisiblity(categories,25).click();
        return new CategoriesPage(driver);
    }

    public CustomerPage clickCreate(){
        waitForVisiblity(customer,25).click();
        waitForVisiblity(create,25).click();
        return new CustomerPage(driver);
    }

}
