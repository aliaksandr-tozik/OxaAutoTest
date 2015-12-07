package tests.freeQuote;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.FreeQuotePage;
import tests.BaseTest;
import static org.junit.Assert.assertTrue;


public class FreeQuoteMandatoryFields extends BaseTest {

    @Override
    public void pageFactory(){
        freeQuotePage = PageFactory.initElements(driver, FreeQuotePage.class);
    }

    @Test
    public void sendOnlineRequest(){
        driver.get(baseURL + "free-quote/");
        freeQuotePage.mandatoryFieldCheck();
        String textName = freeQuotePage.mandatoryFieldName();
        String textEmail = freeQuotePage.mandatoryFieldEmail();
        assertTrue(textName.contains("Enter your name"));
        assertTrue(textEmail.contains("Enter your email"));
    }
}

