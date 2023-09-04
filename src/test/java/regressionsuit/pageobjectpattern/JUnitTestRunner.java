package regressionsuit.pageobjectpattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class JUnitTestRunner{
    static WebDriver driver;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static CustomerPage customerPage;
    static CategoryPage categoryPage;

    @BeforeAll
    public static void serUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        customerPage = new CustomerPage(driver);
        categoryPage = new CategoryPage(driver);
    }
    @Test
    public void loginTest(){
        loginPage.login();
        Assertions.assertTrue(dashboardPage.verifyLogin());
    }
    @Test
    public void addCustomerTest(){
        dashboardPage.clickOnCustomerLink();
        customerPage.addCustomer();
        Assertions.assertTrue(customerPage.isCustomerAddedSuccessfully());
    }
    @Test
    public void deleteCategoryTest(){
        dashboardPage.clickOnCategoriesLink();
        categoryPage.deleteCategory();
        //Assertions.assertTrue(categoryPage.isCategoryDeleted());
    }
    @AfterAll
    public static void tearDown(){
        dashboardPage.clickOnLogoutLink();
        driver.close();
        driver.quit();
    }

}
