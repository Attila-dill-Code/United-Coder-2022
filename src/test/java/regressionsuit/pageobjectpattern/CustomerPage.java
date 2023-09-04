package regressionsuit.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    WebDriver driver;
    FunctionPage functionPage;
    @FindBy(linkText = "Add Customer")
    WebElement addCustomerLink;
    @FindBy(id = "cust-firstname")
    WebElement firstNameField;
    @FindBy(id = "cust-lastname")
    WebElement lastNameField;
    @FindBy(id = "cust-email")
    WebElement emailField;
    @FindBy(name = "save")
    WebElement saveButton;
    @FindBy(css = "div.success")
    WebElement customerSuccessMassage;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);
    }
    public void addCustomer(){
        functionPage.waitUnitElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionPage.waitUnitElementPresent(firstNameField);
        firstNameField.sendKeys(functionPage.generateFakeName());
        functionPage.waitUnitElementPresent(lastNameField);
        lastNameField.sendKeys(functionPage.generateFakeName());
        functionPage.waitUnitElementPresent(emailField);
        emailField.sendKeys(functionPage.generateFakeName()+"@gmail.com");
        functionPage.waitUnitElementPresent(saveButton);
        saveButton.click();
    }
    public void addCustomer(String firstName, String lastName,String email){
        functionPage.waitUnitElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionPage.waitUnitElementPresent(firstNameField);
        firstNameField.sendKeys(functionPage.generateFakeName());
        functionPage.waitUnitElementPresent(lastNameField);
        lastNameField.sendKeys(functionPage.generateFakeName());
        functionPage.waitUnitElementPresent(emailField);
        emailField.sendKeys(functionPage.generateFakeName()+"@gmail.com");
        functionPage.waitUnitElementPresent(saveButton);
        saveButton.click();
    }

    public boolean isCustomerAddedSuccessfully(){
        functionPage.waitUnitElementPresent(customerSuccessMassage);
        if (customerSuccessMassage.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

}
