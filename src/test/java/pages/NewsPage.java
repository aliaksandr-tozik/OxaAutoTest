package pages;

import check.elementFind;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nika on 30.11.2015.
 */
public class NewsPage {
    public WebDriver driver;
    elementFind waitForPageLoad;
    public static Logger log = Logger.getLogger(NewsPage.class);
    public NewsPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoad = new elementFind(driver);
    }

    private static final String header_xpath = "//div[contains(@class ,'inner-wrapper')]//h1";
    private static final String lastNewsTitle_xpath = "//a[@href='http://www.oxagile.com/news/oxagile-included-into-software-magazines-2015-software-500-ranking/']";
    private static final String lastNewsImage_xpath = "//img[@src='/wp-content/uploads/2015/11/Sofrtware_500-2015-300x209.png']";
    private static final String lastNewsDate_xpath = "//div[@class='news-list-item-date' and contains(text(), 'November 12, 2015')]";

    @FindBy(xpath = header_xpath)
    WebElement header;
    @FindBy(xpath = lastNewsTitle_xpath)
    WebElement lastNewsTitle;
    @FindBy(xpath = lastNewsImage_xpath)
    WebElement lastNewsImage;
    @FindBy(xpath = lastNewsDate_xpath)
    WebElement lastNewsDate;

    public void checkHeader() {
        assertEquals(header.getText(), "News");
        log.debug("Header is displayed");
    }
    public void checkLastNewsTitle() {
        assertEquals(lastNewsTitle.getText(), "Oxagile Included into Software Magazine’s 2015 Software 500 Ranking");
        log.debug("The last News Title is displayed");
    }
    public void checkLastNewsImage() {
        assertTrue(lastNewsImage.isDisplayed());
        log.debug("The last News Image is displayed");
    }
    public void checkLastNewsDate() {
        assertEquals(lastNewsDate.getText(), "November 12, 2015");
        log.debug("The last News Date is displayed");
    }

    public void waitForPageLoad() {
        waitForPageLoad.waitForElement(header_xpath);
    }
}
