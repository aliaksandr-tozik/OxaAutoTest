package check;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Admin-A on 23.12.2015.
 */
public class Screenshoter {

    public static String takeScreenshot(WebDriver driver, String screenshotPath){
        try {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            File destination= new File(screenshotPath);
            FileUtils.copyFile(source, destination);
            return destination.getName();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();

        }

    }
}
