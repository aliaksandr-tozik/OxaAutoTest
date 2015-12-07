package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import check.ElementFind;
import pages.FinanceIndustriesPage;
import pages.IndustriesPage;

/**
 * @author Aliaksandr Tozik
 */
public class FinanceIndustriesPageTest extends BaseTest {
	 
	  private static final String PAGE_NAME="Software Company Industry Expertise - IT Development Services - Oxagile";
	  final static Logger log = Logger.getLogger(FinanceIndustriesPageTest.class);

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
		  
		  log.debug("Open 'Finance' page");
		  
		  FinanceIndustriesPage financePage = industriesPage.clickFinanceHyperlink();
		  
		  
		  
		  waiterForElement= new ElementFind(driver);
		  waiterForElement.waitForElement(financePage.getTitleXpath());
		  try{
			  assertTrue(financePage.checkTitleOfFinancePage());
		  }catch(AssertionError e){
		    	log.error("Incorrect page is opened");
		    	fail("Incorrect page is opened");
		  }		  
	    
	  }	  
	}
