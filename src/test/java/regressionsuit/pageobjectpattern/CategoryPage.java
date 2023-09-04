package regressionsuit.pageobjectpattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    WebDriver driver;
    FunctionPage functionPage;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(css = "i.fa.fa-trash")
    WebElement deleteIcon;
    @FindBy(xpath = "//*[contains(text(),'Category successfully deleted.')]")
    WebElement successfullyDeletedMassage;

    public void deleteCategory(){
        functionPage.waitUnitElementPresent(deleteIcon);
        deleteIcon.click();
        Alert alert = driver.switchTo().alert();
        functionPage.waitAlertPresent();
        alert.accept();
    }
    public boolean isCategoryDeleted(){
        functionPage.waitUnitElementPresent(successfullyDeletedMassage);
        if (successfullyDeletedMassage.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }





}
