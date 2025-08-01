package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    WebElement dashboard;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
  

   private By PasswordError=By.xpath("//div[text()='The form is not valid. Please check for errors']");

    public DashboardPage loginInvalid(String user, String pass) {
        waitForPageToLoadCompletely(25);
        waitForVisiblity(username, 25).sendKeys(user);
        waitForVisiblity(password, 25).sendKeys(pass);
        loginBtn.click();
       return new DashboardPage(driver);
    }
   
    
    public void TextAssert(String PasswordInvalidText)
    {
    	String text=driver.findElement(PasswordError).getText();
    	if(text.equals(PasswordInvalidText))
    	{
    		System.out.println("Please provide Password..Unable to login successfully");
    	}
    	else
    	{
    		System.out.println("logged in successfully");
    	}
    }

    public DashboardPage login(String user, String pass) {
        waitForPageToLoadCompletely(25);
        waitForVisiblity(username, 25).sendKeys(user);
        waitForVisiblity(password, 25).sendKeys(pass);
        loginBtn.click();
       return new DashboardPage(driver);
    }
}
