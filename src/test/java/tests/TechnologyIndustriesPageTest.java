package tests;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.apache.log4j.Logger;
//import org.junit.Test;
import org.testng.annotations.*;

import org.openqa.selenium.support.PageFactory;
import check.ElementFind;
import pages.IndustriesPage;
import pages.TechnologyIndustriesPage;

/**
 * @author Aliaksandr Tozik
 */
public class TechnologyIndustriesPageTest extends BaseTest {
	  
	  private static final String PAGE_NAME="Software Company Industry Expertise - IT Development Services - Oxagile";
	  final static Logger log = Logger.getLogger(TechnologyIndustriesPageTest.class);
	  
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
		  
		  log.debug("Open 'Technology' page");
		  
		  TechnologyIndustriesPage technologyPage = industriesPage.clickTechnologyHyperlink();
		  
		  
		  
		  waiterForElement= new ElementFind(driver);
		  waiterForElement.waitForElement(technologyPage.getTitleXpath());
		  try{
			  assertTrue(technologyPage.checkTitleOfTechnologyPage());
		  }catch(AssertionError e){
		    	log.error("Incorrect page is opened");
		    	fail("Incorrect page is opened");
		  }	    
	  }	  
	}
