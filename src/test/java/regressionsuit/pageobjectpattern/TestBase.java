package regressionsuit.pageobjectpattern;

import com.unitedcodernigar.exceltutorial.FunctionUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public WebDriver driver;
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
