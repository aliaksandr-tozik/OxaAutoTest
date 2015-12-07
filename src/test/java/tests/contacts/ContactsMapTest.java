package tests.contacts;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.ContactsPage;
import tests.BaseTest;

import static org.junit.Assert.assertTrue;

public class ContactsMapTest extends BaseTest {

    @Override
    public void pageFactory(){
        contactsPage = PageFactory.initElements(driver, ContactsPage.class);
    }

    @Test
    public void sendOnlineRequest(){
        driver.get(baseURL + "contacts/");
        contactsPage.waitForPageLoad();
        String mapNY = contactsPage.mapCheckNY();
        String mapBL = contactsPage.mapCheckBL();

        assertTrue(mapNY.contains("York"));
        assertTrue(mapBL.contains("Belarus"));

    }
}

