package pages;

import check.driverWait;
import check.elementFind;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


/**
 * Created by zholnerkevichns on 26.11.2015.
 */
public class freeQuotePage {

    WebDriver driver;
    private check.driverWait driverWait;
    public freeQuotePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    static final String FIELD_NAME_XPATH = "//input[contains(@id ,'user-name')]";
    static final String FIELD_COMPANY_XPATH = "//input[contains(@id ,'user-company')]";
    static final String FIELD_CITY_XPATH = "//input[contains(@id ,'user-city')]";
    static final String FIELD_PHONE_XPATH = "//input[contains(@id ,'user-phone')]";
    static final String FIELD_EMAIL_XPATH = "//input[contains(@id ,'user-email')]";
    static final String DROPDOWN_COUNTRY_XPATH = "//select[contains(@id ,'country')]";
    static final String FIELD_MESSAGE_XPATH = "//textarea[contains(@id ,'_message')]";
    static final String BTN_RESET_XPATH = "//input[contains(@class ,'Reset Form')]";
    static final String BTN_SEND_XPATH = "//input[contains(@value ,'Send Request')]";
    static final String BTN_ATTACH_FILE = "//input[contains(@class ,'files-input')]";
    static final String SLIDER_CAPTURE_XPATH = "//div[contains(@class ,'noUi-origin')]";
    static final String SLIDER_POINTER_XPATH = "//div[contains(@class ,'noUi-origin')]//div";
    static final String ERROR_MESSAGE_NAME = "//div[contains(@id ,'request-error-message-name')]";
    static final String ERROR_MESSAGE_EMAIL = "//div[contains(@id ,'request-error-message-email')]";

    @FindBy(xpath = FIELD_NAME_XPATH)         WebElement fieldName;
    @FindBy (xpath = FIELD_COMPANY_XPATH)     WebElement fieldCompany;
    @FindBy (xpath = FIELD_CITY_XPATH)        WebElement fieldCity;
    @FindBy (xpath = FIELD_PHONE_XPATH)       WebElement fieldPhone;
    @FindBy (xpath = FIELD_EMAIL_XPATH)       WebElement fieldEmail;
    @FindBy (xpath = DROPDOWN_COUNTRY_XPATH)  WebElement dropdownCountry;
    @FindBy (xpath = FIELD_MESSAGE_XPATH)     WebElement fieldMessage;
    @FindBy (xpath = BTN_ATTACH_FILE)         WebElement btnAttachFile;
    @FindBy (xpath = BTN_RESET_XPATH)         WebElement btnReset;
    @FindBy (xpath = BTN_SEND_XPATH)          WebElement btnSend;
    @FindBy (xpath = SLIDER_CAPTURE_XPATH)    WebElement sliderCapture;
    @FindBy (xpath = SLIDER_POINTER_XPATH)    WebElement sliderPointer;
    @FindBy (xpath = ERROR_MESSAGE_NAME)      WebElement errorMsgName;
    @FindBy (xpath = ERROR_MESSAGE_EMAIL)     WebElement errorMsgEmail;


    public void sendRequest() {
        fieldName.sendKeys("Mikalai");
        fieldCompany.sendKeys("Oxagile");
        fieldCity.sendKeys("Minsk");
        fieldPhone.sendKeys("233-333-2332");
        fieldEmail.sendKeys("nikolay.zholnerkevich@oxagile.com");

        Select countryDropdown = new Select(dropdownCountry);
        countryDropdown.selectByValue("Belarus");
        fieldMessage.sendKeys("AutomationTest");
        fileAttach();
        captureDrag();
        btnSend.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {}
    }

    public void mandatoryFields(){
        btnSend.click();
        driverWait.wait(3000);
        assertTrue(errorMsgName.getText().contains("Enter your name"));
        fieldName.sendKeys("Mikalai");
        btnSend.click();
        assertTrue(errorMsgEmail.getText().contains("Enter your email"));
    }

    public void fileAttach(){
        btnAttachFile.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
    }

    public void captureDrag(){

        Actions move = new Actions(driver);
        for (int i = 0; i<20; i++){
            Action action = move.dragAndDropBy(sliderPointer, 30, 0).build();
            action.perform();
        }
    }

    public void formReset(){
        btnReset.click();
    }



}


