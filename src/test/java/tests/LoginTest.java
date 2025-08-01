package tests;

import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import reports.ExtentManager;
import utils.ScreenshotUtil;

@Listeners(utils.TestListener.class)
public class LoginTest extends BaseTest{
   
	DashboardPage dashboard;
	CustomerPage customer;
   
	 @Test(priority=1)
	    public void loginWithCredentials() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);
	        dashboard=loginPage.login("demo", "demo");
	      
	        ScreenshotUtil.attachStepScreenshot(driver, "Step1_Login with Valid credentials", "Login is successful");
	    }

    @Test(priority=2,dependsOnMethods="loginWithCredentials",enabled=true)
    public void createCustomer() throws InterruptedException {
        customer = dashboard.clickCreate();
        ScreenshotUtil.attachStepScreenshot(driver, "Step1_CreateCustomer", "Create Customer is displayed");
        boolean createlabel = customer.createCustomer("Lilly", "Jame", "abc@gmail.com");
        Assert.assertTrue(createlabel,"Customer is created successfully");
        ScreenshotUtil.attachStepScreenshot(driver, "Step2_Customer Created", "Customer is created successfully");
        
        customer.getCustomers();
        customer.searchandSelectCustomer("abc@gmail.com");
        ScreenshotUtil.attachStepScreenshot(driver, "Step3_Customer Disaplyed", "Customer created is displayed successfully");
    }

    @Test(priority=3,dependsOnMethods="loginWithCredentials",enabled=true)
    public void editCategory() throws InterruptedException{
        CategoriesPage category = dashboard.clickCategory();
        boolean createlabel = category.editCategory(70);
        Assert.assertTrue(createlabel,"Category is updated successfully");
        ScreenshotUtil.attachStepScreenshot(driver, "Step1_Category Updated", "Category is updated successfully");
    }

    @Test(priority=4,dependsOnMethods="loginWithCredentials",enabled=true)
    public void afterEdit(){
    	CategoriesPage category = dashboard.clickCategory();
        boolean found = category.afterEditCategory(70);
        Assert.assertTrue(found,"Poster is updated successfully");
        ScreenshotUtil.attachStepScreenshot(driver, "Step1_Updated Price", "Updated Price is reflected successfully");

    }
    
    @Test(priority=5,dependsOnMethods="loginWithCredentials",enabled=true)
    public void DeleteCustomer() throws InterruptedException{
     
    	customer.getCustomers();
        ScreenshotUtil.attachStepScreenshot(driver, "Customer list", "Customer list is displayed");
        customer.searchandSelectCustomer("abc@gmail.com");
        customer.DeleteUser();
        ScreenshotUtil.attachStepScreenshot(driver, "Customer Deletion", "Customer is deleted successfully");
        tearDown();
    }
    
    @Test(priority=6,enabled=true)
    public void loginWithInvalidCredentials() throws InterruptedException {
    	
    	setUp();

        LoginPage loginPage = new LoginPage(driver);
        dashboard=loginPage.loginInvalid("demo", "");
      
        ScreenshotUtil.attachStepScreenshot(driver, "Step1_Login with Invalid credentials", "Login is not successful");

        loginPage.TextAssert("The form is not valid. Please check for errors");
        
       
    }
    
}

