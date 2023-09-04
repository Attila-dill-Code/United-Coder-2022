package regressionsuit.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(css = "i.fa.fa-sign-out")
    WebElement logoutLink;
    @FindBy(id = "nav_products")
    WebElement productsLink;
    FunctionPage functionPage;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);
    }

    public void clickOnCustomerLink(){
        functionPage.waitUnitElementPresent(customerListLink);
        customerListLink.click();
    }
    public void clickOnCategoriesLink(){
        functionPage.waitUnitElementPresent(categoriesLink);
        categoriesLink.click();
    }
    public void clickOnLogoutLink(){
        functionPage.waitUnitElementPresent(logoutLink);
        logoutLink.click();
    }
    public boolean verifyLogin(){
        functionPage.waitUnitElementPresent(logoutLink);
        if (logoutLink.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public void clickOnProductsLink(){
        functionPage.waitUnitElementPresent(productsLink);
        productsLink.click();
    }


}
