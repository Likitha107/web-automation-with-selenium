package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends BaseClass {

    public CustomerPage(WebDriver driver){
        super((driver));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement savebtn;

    @FindBy(xpath = "//div[text()='Customer created']")
    WebElement createsuccess;
    
    @FindBy(xpath = "//input[@type='text']")
    WebElement SearchCustomer;
    @FindBy(xpath = "//button[@title='Unselect']")
    WebElement UnselectCustomer;
    
  
    
    @FindBy(xpath = "(//input[contains(@class, 'PrivateSwitchBase-input css')])[2]//parent::span")
    WebElement SelectCustomer;
    
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement DeleteCustomer;
    
    @FindBy(xpath = "//div[text()='Customer deleted']")
    WebElement SuccessfulDeletetion;
    
  
    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    WebElement customer;

    public boolean createCustomer(String fname,String lname,String mail){
        waitForVisiblity(firstname,30).sendKeys(fname);
        waitForVisiblity(lastname,30).sendKeys(lname);
        waitForVisiblity(email,30).sendKeys(mail);
        waitForVisiblity(savebtn,30).click();
        return waitForVisiblity(createsuccess,30).isDisplayed();
    }
    
    public void searchandSelectCustomer(String Mail) throws InterruptedException {
    	WebElement value= waitForVisiblity(SearchCustomer,30);
    	String text=value.getAttribute("value");
    	int len=text.length();
    	for(int i=0;i<len;i++ )
    	{
    		 waitForVisiblity(SearchCustomer,30).sendKeys(Keys.BACK_SPACE);	
    	}
   
  
    waitForVisiblity(SearchCustomer,30).sendKeys(Mail);
  
    Thread.sleep(600);
    if(UnselectCustomer.isDisplayed())
    		{
    	waitForVisiblity(UnselectCustomer,30).click();
    		}
    waitForVisiblity(SelectCustomer,30).click();
    }
    
    
    public void getCustomers() throws InterruptedException{ 
    	 Thread.sleep(600);
    	waitForVisiblity(customer,30).click();
	  }
    
    public void DeleteUser() throws InterruptedException
    {
    	
    	   waitForVisiblity(DeleteCustomer,30).click();
    	
    	 waitForVisiblity(SuccessfulDeletetion, 1);
    }

}

