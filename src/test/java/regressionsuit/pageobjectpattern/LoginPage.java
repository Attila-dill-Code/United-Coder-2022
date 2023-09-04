package regressionsuit.pageobjectpattern;

import com.unitedcodernigar.configutility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id="username")
    WebElement userNameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;
    FunctionPage functionPage;
    String userName = ApplicationConfig.readConfigProperties("config2.properties","username");
    String password = ApplicationConfig.readConfigProperties("config2.properties","password");
    int timeout = 10;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);
    }

    public void typeUserName(){
        functionPage.waitUnitElementPresent(userNameField);
        userNameField.sendKeys(userName);
    }
    public void typePassword(){
        functionPage.waitUnitElementPresent(passwordField);
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(){
        typeUserName();
        typePassword();
        clickLoginButton();
    }
    public void multiLoginTest(){
        typeUserName();
        typePassword();
        loginButton.click();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnLogoutLink();
    }


}
