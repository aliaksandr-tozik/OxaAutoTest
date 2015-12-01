package check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zholnerkevichns on 28.11.2015.
 */
public class ElementFind {
    public ElementFind (WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    public void waitForElement(String xpath){
        WebDriverWait waitForOne = new WebDriverWait(driver, 3);
        waitForOne.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
