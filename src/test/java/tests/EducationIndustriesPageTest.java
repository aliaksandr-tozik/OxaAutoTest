package tests;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import check.driverWait;
import pages.EducationIndustriesPage;
import pages.IndustriesPage;
import pages.MediaIndustriesPage;
import pages.freeQuotePage;

public class EducationIndustriesPageTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private IndustriesPage page;
  private static final String PAGE_NAME="Software Company Industry Expertise - IT Development Services - Oxagile";
  

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();	  
    baseUrl = "http://redesign-qa.oxagile.com/industries/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    page = PageFactory.initElements(driver, IndustriesPage.class);
  }
  final static Logger log = Logger.getLogger(EducationIndustriesPageTest.class);

  @Test
  public void testIndustriesPage() throws Exception {
	  driverWait myWaiter = new driverWait();
	  
	  log.debug("Open 'Industries' page");
	  page.openIndustriesPage();
	  myWaiter.wait(1000);
	  if(!page.getTitle().equals(PAGE_NAME)){
		  log.error("Incorrect page is opened");
		  fail("Incorrect page is opened");
	  }
	  
	  log.debug("Open 'Education' page");
	  
	  EducationIndustriesPage educationPage = page.clickEducationHyperlink();
	  
	  myWaiter.wait(2000);
	  try{
		  assertTrue(educationPage.checkTitleOfEducationPage());
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