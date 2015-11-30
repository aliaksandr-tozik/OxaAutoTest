package pages;

import org.openqa.selenium.WebDriver;
/**
 * @author Aliaksandr Tozik
 */
public class FinanceIndustriesPage {
public WebDriver driver;
	
	private static final String FINANCE_URL = "http://redesign-qa.oxagile.com/industries/finance-banking/";
	private static final String PAGE_FINANCE_NAME="Banking Software Development - Financial Software Developers - Investment Banking Software Solutions";
	private static final String TITLE_XPATH = "//title";
	
	public FinanceIndustriesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	public boolean checkTitleOfFinancePage() {
		return driver.getTitle().equals(PAGE_FINANCE_NAME);
	}
	public void openFinanceIndustriesPage(){
		driver.get(FINANCE_URL);
	}
	public String getTitleXpath(){
		return TITLE_XPATH;
	}

}
