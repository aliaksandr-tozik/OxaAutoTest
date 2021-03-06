package pages;

import org.openqa.selenium.WebDriver;
/**
 * @author Aliaksandr Tozik
 */
public class MediaIndustriesPage {
	public WebDriver driver;
	
	private static final String MEDIA_URL = "http://redesign-qa.oxagile.com/industries/entertainment-media/";
	private static final String PAGE_MEDIA_NAME="Media Software Development Services - Entertainment Solutions - IP Video Application Projects";
	private static final String TITLE_XPATH = "//title";
	
	
	public MediaIndustriesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	public boolean checkTitleOfMediaPage() {
		return driver.getTitle().equals(PAGE_MEDIA_NAME);
	}
	public void openMediaIndustriesPage(){
		driver.get(MEDIA_URL);
	}
	public String getTitleXpath(){
		return TITLE_XPATH;
	}

}
