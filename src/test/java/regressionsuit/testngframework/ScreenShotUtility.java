package regressionsuit.testngframework;

import com.unitedcodernigar.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    public void takeScreenShot(String fileName, WebDriver driver){
        DateTime time = new DateTime();
        // use formatter to print the date time in yyyy-MM-dd-HH-mm-ss-SSS  format
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timeStamp = time.toString(formatter);
        fileName = fileName+"_"+timeStamp;
        File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        String imageFolder = applicationConfig.readConfigProperties("config2.properties","imageFolder");
        try {
            FileUtils.copyFile(imageFile,new File(imageFolder+File.separator+fileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
