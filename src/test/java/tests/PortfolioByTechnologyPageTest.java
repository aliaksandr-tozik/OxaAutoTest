package tests;

import check.DriverWait;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PortfolioByTechnologyPage;

import static org.junit.Assert.fail;

/**
 * Created by Nika on 02.12.2015.
 */
public class PortfolioByTechnologyPageTest {
    public WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    PortfolioByTechnologyPage portfolioByTechnology;
    public static Logger log = Logger.getLogger(NewsPageTest.class);
    DriverWait waiter = new DriverWait();


    @Before
    public void setUp() throws Exception {
        BasicConfigurator.configure();
        driver = new FirefoxDriver();
        baseUrl = "http://www.oxagile.com/portfolio/by-technology/";
        driver.get(baseUrl);
        portfolioByTechnology = PageFactory.initElements(driver, pages.PortfolioByTechnologyPage.class);
    }

    @Test
    public void testPortfolioByTechnologyPage() {
        log.debug("-----------Open NewsPage------------");
        portfolioByTechnology.waitForPageLoad();
        log.debug("-----------Check Header-----------");
        portfolioByTechnology.checkHeader();
        log.debug("-----------Check Mobile Button Hover Effect-----------");
        portfolioByTechnology.checkButtonHover(portfolioByTechnology.mobileButton);
        log.debug("-----------Check Java Button Hover Effect-----------");
        portfolioByTechnology.checkButtonHover(portfolioByTechnology.javaButton);
        log.debug("-----------Check .Net Button Hover Effect-----------");
        portfolioByTechnology.checkButtonHover(portfolioByTechnology.dotNetButton);
        log.debug("-----------Check PHP Button Hover Effect-----------");
        portfolioByTechnology.checkButtonHover(portfolioByTechnology.phpButton);
        log.debug("-----------Check Mobile Button click-----------");
        portfolioByTechnology.checkButtonClick(portfolioByTechnology.mobileButton);
        driver.get(baseUrl);
        waiter.wait(1000);
        log.debug("-----------Check Java Button click-----------");
        portfolioByTechnology.checkButtonClick(portfolioByTechnology.javaButton);
        driver.get(baseUrl);
        waiter.wait(1000);
        log.debug("-----------Check .Net Button click-----------");
        portfolioByTechnology.checkButtonClick(portfolioByTechnology.dotNetButton);
        driver.get(baseUrl);
        waiter.wait(1000);
        log.debug("-----------Check PHP Button click-----------");
        portfolioByTechnology.checkButtonClick(portfolioByTechnology.phpButton);


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