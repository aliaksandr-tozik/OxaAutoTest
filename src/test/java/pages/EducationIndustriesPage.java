package pages;

import org.openqa.selenium.WebDriver;

public class EducationIndustriesPage {
public WebDriver driver;
	
	private static final String EDUCATION_URL = "http://redesign-qa.oxagile.com/industries/education-elearning/";
	private static final String PAGE_EDUCATION_NAME="Elearning Software Development - Educational Application Development - E-learning Software Solutions";
	
	
	public EducationIndustriesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	public boolean checkTitleOfEducationPage() {
		return driver.getTitle().equals(PAGE_EDUCATION_NAME);
	}
	public void openEducationIndustriesPage(){
		driver.get(EDUCATION_URL);
	}

}
