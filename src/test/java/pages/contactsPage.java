package pages;

import check.elementFind;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by zholnerkevichns on 28.11.2015.
 */
public class contactsPage {

    WebDriver driver;
    private elementFind check;
    public contactsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        check = new elementFind(driver);

    }

    static final String HEADER_H1_XPATH = "//div[contains(@class ,'inner-wrapper')]//h1";
    static final String IMAGE_MAP_HEADQUARTERS_XPATH = "//img[contains(@alt ,'Map for New York office')]";
    static final String IMAGE_MAP_DEVELOPMENT_XPATH = "//img[contains(@alt ,'Map for Belarus office')]";


    @FindBy(xpath = IMAGE_MAP_HEADQUARTERS_XPATH)      WebElement imageMapHeadquarters;
    @FindBy(xpath = IMAGE_MAP_DEVELOPMENT_XPATH)       WebElement imageMapDevelopment;




    public void mapCheck(){
        String srcMapHeadquarters;
        srcMapHeadquarters = imageMapHeadquarters.getAttribute("src");
        assertTrue(srcMapHeadquarters.contains("York"));

        String srcMapDevelopment;
        srcMapDevelopment = imageMapDevelopment.getAttribute("src");
        assertTrue(srcMapDevelopment.contains("Belarus"));
    }

    public void waitForPageLoad(){
        check.waitForElement(HEADER_H1_XPATH);
    }




}
