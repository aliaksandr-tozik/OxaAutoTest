package tests.freeQuote;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FreeQuotePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by zholnerkevichns on 26.11.2015.
 */
public class freeQuoteSendRequest {
    private WebDriver driver;
    private String baseURL;
    private FreeQuotePage FreeQuotePage;



    @Before
    public void setUP() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        baseURL = "http://redesign-qa.oxagile.com/free-quote/";
        driver.get(baseURL);
        FreeQuotePage = PageFactory.initElements(driver, FreeQuotePage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void sendOnlineRequest(){

        FreeQuotePage.sendRequest();
        WebElement msgSuccess = driver.findElement(By.xpath("//div[contains(@class ,'request_sended_header')]"));
        String msgGoogleText = msgSuccess.getText();
        assertTrue(msgGoogleText.contains("successfully received"));
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
