package tests;

//import java.util.regex.Pattern;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.support.ui.Select;
//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
//import pages.freeQuotePage;
//import check.driverWait;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import check.elementFind;
import pages.IndustriesPage;
import pages.MediaIndustriesPage;

/**
 * @author Aliaksandr Tozik
 */
public class MediaIndustriesPageTest {
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
  final static Logger log = Logger.getLogger(MediaIndustriesPageTest.class);

  @Test
  public void testIndustriesPage() throws Exception {
	  //driverWait myWaiter = new driverWait();
	  
	  log.debug("Open 'Industries' page");
	  page.openIndustriesPage();
	  //myWaiter.wait(1000);
	  elementFind waiterForElement= new elementFind(driver);
	  waiterForElement.waitForElement(page.getTitleXpath());
	  if(!page.getTitle().equals(PAGE_NAME)){
		  log.error("Incorrect page is opened");
		  fail("Incorrect page is opened");
	  }
	  
	  log.debug("Open 'Media' page");
	  	  
	  MediaIndustriesPage mediaPage = page.clickMediaHyperlink();
	  	  
	  //myWaiter.wait(2000);
	  waiterForElement=new elementFind(driver);
	  waiterForElement.waitForElement(mediaPage.getTitleXpath());
	  try{
		  assertTrue(mediaPage.checkTitleOfMediaPage());
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
