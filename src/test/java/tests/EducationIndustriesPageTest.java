package tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import check.ElementFind;
import pages.EducationIndustriesPage;
import pages.IndustriesPage;
import tests.BaseTest;

/**
 * @author Aliaksandr Tozik
 */
public class EducationIndustriesPageTest extends BaseTest {
  
  private static final String PAGE_NAME="Software Company Industry Expertise - IT Development Services - Oxagile";
  

  final static Logger log = Logger.getLogger(EducationIndustriesPageTest.class);
  
  @Override
	public void pageFactory() {
		industriesPage=PageFactory.initElements(driver, IndustriesPage.class);
		
	}
  
  @Test
  public void testIndustriesPage() throws Exception {
	  
	  
	  log.debug("Open 'Industries' page");
	  industriesPage.openIndustriesPage();
	  
	  
	  ElementFind waiterForElement= new ElementFind(driver);
	  waiterForElement.waitForElement(industriesPage.getTitleXpath());
	  if(!industriesPage.getTitle().equals(PAGE_NAME)){
		  log.error("Incorrect page is opened");
		  fail("Incorrect page is opened");
	  }
	  
	  log.debug("Open 'Education' page");
	  
	  EducationIndustriesPage educationPage = industriesPage.clickEducationHyperlink();
	  
	  	  
	  waiterForElement= new ElementFind(driver);
	  waiterForElement.waitForElement(educationPage.getTitleXpath());
	  try{
		  assertTrue(educationPage.checkTitleOfEducationPage());
	  }catch(AssertionError e){
	    	log.error("Incorrect page is opened");
	    	fail("Incorrect page is opened");
	  }	  
    
  }  
}