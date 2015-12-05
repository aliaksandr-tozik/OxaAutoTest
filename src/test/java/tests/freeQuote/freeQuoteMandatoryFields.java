package tests.freeQuote;

import org.junit.Test;
import tests.BaseTest;
import static org.junit.Assert.assertTrue;


public class freeQuoteMandatoryFields extends BaseTest {

    @Test
    public void sendOnlineRequest(){
        driver.get(baseURL + "free-quote/");
        freeQuotePage.mandatoryFieldCheck();
        String textName = freeQuotePage.mandatoryFieldName();
        String textEmail = freeQuotePage.mandatoryFieldEmail();
        assertTrue(textName.contains("Enter your name"));
        assertTrue(textEmail.contains("Enter your email"));
    }//wwwww
}

