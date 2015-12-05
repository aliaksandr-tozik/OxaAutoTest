package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactsPage;
import pages.FreeQuotePage;

import java.util.concurrent.TimeUnit;


public abstract class BaseTest {
    protected WebDriver driver;
    public FreeQuotePage freeQuotePage;
    public ContactsPage contactsPage;
    public String baseURL;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "http://redesign-qa.oxagile.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        contactsPage = PageFactory.initElements(driver, ContactsPage.class);
        freeQuotePage = PageFactory.initElements(driver, FreeQuotePage.class);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
