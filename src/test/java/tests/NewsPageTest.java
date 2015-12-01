package tests;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.NewsPage;
import static org.junit.Assert.fail;

/**
 * Created by Nika on 30.11.2015.
 */
public class NewsPageTest {

    public WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    NewsPage newsPage;
    public static Logger log = Logger.getLogger(NewsPageTest.class);


    @Before
    public void setUp() throws Exception {
        BasicConfigurator.configure();
        driver = new FirefoxDriver();
        baseUrl = "http://www.oxagile.com/company/news/";
        driver.get(baseUrl);
        newsPage = PageFactory.initElements(driver, pages.NewsPage.class);
    }

    @Test
    public void testNewsPage(){
        log.debug("-----------Open NewsPage------------");
        newsPage.waitForPageLoad();
        log.debug("-----------Check Header-----------");
        newsPage.checkHeader();
        log.debug("-----------Check the Last News Title-----------");
        newsPage.checkLastNewsTitle();
        log.debug("-----------Check the Last News Image-----------");
        newsPage.checkLastNewsImage();
        log.debug("-----------Check the Last News Date-----------");
        newsPage.checkLastNewsDate();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
