package tests.contacts;

import org.junit.Test;
import tests.BaseTest;

import static org.junit.Assert.assertTrue;

public class ContactsMapTest extends BaseTest {


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

