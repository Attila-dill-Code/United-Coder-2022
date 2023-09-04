package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGgDemo2 {
    @BeforeClass
    public void setUp(){
        System.out.println("Before class...! ");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method....");
    }
    @Test
    public void addCustomerTest(){
        System.out.println("This is for add Customer..... ");
        Assert.assertTrue("Add Customer".contains("Customer"));
    }
    @Test(dependsOnMethods = {"addCustomerTest"},priority = 2)
    public void deleteCustomer(){
        System.out.println("Delete customer test....");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(dependsOnMethods = {"addCustomerTest"},priority = 1)
    public void editCustomer(){
        System.out.println("List of customer appeared... ");
        Assert.assertEquals(10,10);
    }
    @Test(enabled = false) // if you want to run this code you should change 'true'.
    public void customerList(){
        System.out.println("Customer List");
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
}
