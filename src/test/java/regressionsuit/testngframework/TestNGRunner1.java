package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import regressionsuit.pageobjectpattern.*;

@Listeners(TestResultListener.class)
public class TestNGRunner1 extends TestBase{

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductsPage productsPage;
    CustomerPage customerPage;
    @BeforeClass
    public void setUp(ITestContext context){
        setUpBrowser();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.login();
        context.setAttribute("driver",driver);
    }
    @Test
    public  void viewProduct(){
        dashboardPage.clickOnProductsLink();
        productsPage = new ProductsPage(driver);
        boolean isProductDisplayed = productsPage.viewProducts();
        Assert.assertTrue(isProductDisplayed);
    }
    @Test
    public void addCustomer(){
        dashboardPage.clickOnCustomerLink();
        customerPage = new CustomerPage(driver);
        customerPage.addCustomer();
        Assert.assertTrue(customerPage.isCustomerAddedSuccessfully());
    }
    @AfterClass
    public void tearDown(){
        dashboardPage.clickOnLogoutLink();
        closeBrowser();
    }
}
