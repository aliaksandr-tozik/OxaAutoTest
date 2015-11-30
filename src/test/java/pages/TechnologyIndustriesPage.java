package pages;

import org.openqa.selenium.WebDriver;
/**
 * @author Aliaksandr Tozik
 */
public class TechnologyIndustriesPage {
public WebDriver driver;
	
	private static final String TECHNOLOGY_URL = "http://redesign-qa.oxagile.com/industries/information-technology/";
	private static final String PAGE_TECHNOLOGY_NAME="IT Industry Software Company Services - Web Application Development Solutions";
	private static final String TITLE_XPATH = "//title";
	
	public TechnologyIndustriesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	public boolean checkTitleOfTechnologyPage() {
		return driver.getTitle().equals(PAGE_TECHNOLOGY_NAME);
	}
	public void openTechnologyIndustriesPage(){
		driver.get(TECHNOLOGY_URL);
	}
	public String getTitleXpath(){
		return TITLE_XPATH;
	}

}
