package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ContactsPage;
import pages.FreeQuotePage;
import java.util.concurrent.TimeUnit;


public abstract class BaseTest {
    protected WebDriver driver;
    public FreeQuotePage freeQuotePage;
    public ContactsPage contactsPage;
    public String baseURL;

    public abstract void pageFactory();

    @Before
    public void setUp() throws Exception {
        pageFactory();
        driver = new FirefoxDriver();
        baseURL = "http://redesign-qa.oxagile.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

