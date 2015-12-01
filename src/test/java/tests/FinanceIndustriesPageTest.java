package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import check.ElementFind;
import pages.FinanceIndustriesPage;
import pages.IndustriesPage;

/**
 * @author Aliaksandr Tozik
 */
public class FinanceIndustriesPageTest {
	  private WebDriver driver;
	  //private String baseUrl;
	  //private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private IndustriesPage page;
	  private static final String PAGE_NAME="Software Company Industry Expertise - IT Development Services - Oxagile";
	  

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();	  
	    //baseUrl = "http://redesign-qa.oxagile.com/industries/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    page = PageFactory.initElements(driver, IndustriesPage.class);
	  }
	  final static Logger log = Logger.getLogger(FinanceIndustriesPageTest.class);

	  @Test
	  public void testIndustriesPage() throws Exception {
		  
		  
		  log.debug("Open 'Industries' page");
		  page.openIndustriesPage();
		  
		  
		  ElementFind waiterForElement= new ElementFind(driver);
		  waiterForElement.waitForElement(page.getTitleXpath());
		  if(!page.getTitle().equals(PAGE_NAME)){
			  log.error("Incorrect page is opened");
			  fail("Incorrect page is opened");
		  }
		  
		  log.debug("Open 'Finance' page");
		  
		  FinanceIndustriesPage financePage = page.clickFinanceHyperlink();
		  
		  
		  
		  waiterForElement= new ElementFind(driver);
		  waiterForElement.waitForElement(financePage.getTitleXpath());
		  try{
			  assertTrue(financePage.checkTitleOfFinancePage());
		  }catch(AssertionError e){
		    	log.error("Incorrect page is opened");
		    	fail("Incorrect page is opened");
		  }
		  
		  
		  
		  
	    
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
