package regressionsuit.pageobjectpattern;

import com.github.javafaker.Faker;
import com.unitedcodernigar.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FunctionPage {
    WebDriver driver;
    int timeout = Integer.parseInt(ApplicationConfig.readConfigProperties(
            "config2.properties","timeout"));
    public FunctionPage(WebDriver driver){
        this.driver = driver;
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitUnitElementPresent(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitAlertPresent(){    // alert = pop-pop  we can use for pop-pop this wait function
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String generateFakeName(){
        String faker = Faker.instance().name().firstName();
        return faker;
    }


}
