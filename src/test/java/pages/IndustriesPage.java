package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndustriesPage {
	
	public WebDriver driver;
	
		
	private static final String URL = "http://redesign-qa.oxagile.com/industries/";
	
	private static final String MEDIA_LINK = "//a[contains(@title, 'Media software development')]";
	private static final String TECHNOLOGY_LINK = "//a[contains(@title, 'IT industry software company')]";
	private static final String EDUCATION_LINK = "//a[contains(@title, 'E-learning software development')]";
	private static final String FINANCE_LINK = "//a[contains(@title, 'Finance web application')]";
	
	@FindBy(xpath=MEDIA_LINK)
	WebElement mediaHyperlink;
	
	@FindBy(xpath=TECHNOLOGY_LINK)
	WebElement technologyHyperlink;
	
	@FindBy(xpath=EDUCATION_LINK)
	WebElement educationHyperlink;
	
	@FindBy(xpath=FINANCE_LINK)
	WebElement financeHyperlink;
	
	
	
	public IndustriesPage(WebDriver driver){
		this.driver=driver;
	}
	public void openIndustriesPage(){
		driver.get(URL);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public MediaIndustriesPage clickMediaHyperlink(){
		mediaHyperlink.click();
		return new MediaIndustriesPage(driver);
	}	
	
	public TechnologyIndustriesPage clickTechnologyHyperlink(){
		technologyHyperlink.click();
		return new TechnologyIndustriesPage(driver);
	}
	
	public EducationIndustriesPage clickEducationHyperlink(){
		educationHyperlink.click();
		return new EducationIndustriesPage(driver);
	}
	
	public FinanceIndustriesPage clickFinanceHyperlink(){
		financeHyperlink.click();
		return new FinanceIndustriesPage(driver);
	}

}