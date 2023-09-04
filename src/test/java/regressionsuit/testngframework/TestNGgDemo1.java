package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGgDemo1 {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before suit...");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test...");
    }
    @BeforeClass
    public void setUp(){
        System.out.println("Before class...! ");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method....");
    }
    @Test(description = "this test is for add customer function !",groups = {"regression test"},priority = 2)
    public void addCustomerTest(){
        System.out.println("This is for add Customer..... ");
        Assert.assertTrue("Add Customer".contains("Customer"));
    }
    @Test(groups = {"smoke test"},priority = 1,dependsOnGroups = {"regression test"})
    public void deleteCustomer(){
        System.out.println("Delete customer test....");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(groups = {"smoke test"},priority = 3)
    public void verifyCustomerList(){
        System.out.println("List of customer appeared... ");
        Assert.assertEquals(10,10);
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method.... ");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class.... ");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test....");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("after suit.....");
    }
}
