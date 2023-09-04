package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.pageobjectpattern.*;

public class DataProviderDemo2 extends TestBase{
    LoginPage loginPage;
    FunctionPage functionPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @BeforeClass
    public void setUp(){
        setUpBrowser();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        customerPage = new CustomerPage(driver);
        functionPage = new FunctionPage(driver);
    }
    @Test(dataProvider = "loginData",priority = 1)
    public void loginTest(){
        loginPage.login();
        Assert.assertTrue(dashboardPage.verifyLogin());
    }
    @Test(dataProvider = "customerData",priority = 2)
    public void addCustomer(String firstName, String lastName, String email){
        dashboardPage.clickOnCustomerLink();
        customerPage.addCustomer(firstName,lastName,email);
        Assert.assertTrue(customerPage.isCustomerAddedSuccessfully());
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
    @DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object[][]{
                {"testautomation1","automation123!"}
        };
        return data;
    }
    @DataProvider
    public Object[][] customerData(){
        Object[][] data1 = new Object[][] {
            {functionPage.generateFakeName(),functionPage.generateFakeName(),
                    functionPage.generateFakeName()+"@gmail.com"},
            {functionPage.generateFakeName(),functionPage.generateFakeName(),
                    functionPage.generateFakeName()+"@gmail.com"},
            {functionPage.generateFakeName(),functionPage.generateFakeName(),
                    functionPage.generateFakeName()+"@gmail.com"}
        };
        return data1;
    }

}
