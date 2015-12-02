package pages;

import check.DriverWait;
import check.ElementFind;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nika on 02.12.2015.
 */
public class PortfolioByTechnologyPage {
    public WebDriver driver = null;
    Actions action;
    ElementFind waitForPageLoad;
    DriverWait waiter;
    public static Logger log = Logger.getLogger(NewsPage.class);
    public PortfolioByTechnologyPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoad = new ElementFind(driver);
        action = new Actions(driver);
        waiter = new DriverWait();
    }

    public static final String header_xpath = "//div[contains(@class ,'inner-wrapper')]//h1";
    public static final String mobileButton_xpath = "//div/a[@href='/portfolio/tag/mobile/']";
    public static final String javaButton_xpath = "//div/a[@href='/portfolio/tag/java/']";
    public static final String dotNetButton_xpath = "//div/a[@href='/portfolio/tag/net/']";
    public static final String phpButton_xpath = "//div/a[@href='/portfolio/tag/php/']";

    @FindBy(xpath = header_xpath)
    WebElement header;
    @FindBy(xpath = mobileButton_xpath)
    public WebElement mobileButton;
    @FindBy(xpath = javaButton_xpath)
    public WebElement javaButton;
    @FindBy(xpath = dotNetButton_xpath)
    public WebElement dotNetButton;
    @FindBy(xpath = phpButton_xpath)
    public WebElement phpButton;

    public void checkHeader() {
        assertEquals(header.getText(), "By Technology");
        log.debug("Header is displayed");
    }
    public void checkButtonHover(WebElement webelement) {
        action.moveToElement(webelement).perform();
        assertTrue(webelement.getCssValue("color").contains("201, 42, 58"));
        log.debug("Hover is displayed");
    }
    public void checkButtonClick(WebElement webElement) {
        action.click(webElement).perform();
        waiter.wait(1000);
        assertEquals(driver.getTitle(), "Portfolio - Oxagile");
        log.debug("Button is clicked");
    }
    public void waitForPageLoad() {
        waitForPageLoad.waitForElement(header_xpath);
    }
}
