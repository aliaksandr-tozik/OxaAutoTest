package tests.freeQuote;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.FreeQuotePage;
import tests.BaseTest;


import static org.junit.Assert.assertTrue;

public class FreeQuoteSendRequest extends BaseTest {

    @Override
    public void pageFactory(){
        freeQuotePage = PageFactory.initElements(driver, FreeQuotePage.class);
    }

    @Test
    public void sendOnlineRequest(){
        driver.get(baseURL + "free-quote/");
        freeQuotePage.sendRequest();
        WebElement msgSuccess = driver.findElement(By.xpath("//div[contains(@class ,'request_sended_header')]"));
        String msgGoogleText = msgSuccess.getText();
        assertTrue(msgGoogleText.contains("successfully received"));
    }



}
