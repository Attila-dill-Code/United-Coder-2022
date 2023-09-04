package regressionsuit.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    WebDriver driver;
    FunctionPage functionPage;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);
    }

    @FindAll(
            @FindBy(xpath = "//div[@id='general']/table[3]/tbody/tr")
    )
    List<WebElement> products;

    public boolean viewProducts(){
        return products.size()>=1;
    }

}
