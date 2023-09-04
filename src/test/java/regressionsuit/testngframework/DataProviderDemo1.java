package regressionsuit.testngframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.pageobjectpattern.LoginPage;
import regressionsuit.pageobjectpattern.TestBase;

public class DataProviderDemo1 extends TestBase{
    LoginPage loginPage;
    @BeforeClass
    public void setUp(){
        setUpBrowser();
        loginPage = new LoginPage(driver);
    }
    @Test(dataProvider = "loginData")
    public void loginTest(){
        loginPage.multiLoginTest();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
    @DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object[][]{
                {"testautomation1","automation123!"},
                {"testautomation2","automation123!"}
        };
        return data;
    }

}
