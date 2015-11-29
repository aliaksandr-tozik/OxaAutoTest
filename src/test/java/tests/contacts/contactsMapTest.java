package tests.contacts;

import check.elementFind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by zholnerkevichns on 29.11.2015.
 */
public class contactsMapTest {
    private WebDriver driver;
    private String baseURL;
    private pages.contactsPage contactsPage;


    @Before
    public void setUP() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        baseURL = "http://redesign-qa.oxagile.com/contacts/";
        driver.get(baseURL);
        contactsPage = PageFactory.initElements(driver, pages.contactsPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void sendOnlineRequest(){
        contactsPage.waitForPageLoad();
        contactsPage.mapCheck();

    }


    @After
    public void tearDown(){
        driver.quit();
    }
}

