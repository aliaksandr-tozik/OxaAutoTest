package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


/**
 * Created by zholnerkevichns on 26.11.2015.
 */
public class freeQuotePage {

    WebDriver driver;
    public freeQuotePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    static final String FIELD_NAME_XPATH = "//input[contains(@id ,'user-name')]";
    static final String FIELD_COMPANY_XPATH = "//input[contains(@id ,'user-company')]";
    static final String FIELD_CITY_XPATH = "//input[contains(@id ,'user-city')]";
    static final String FIELD_PHONE_XPATH = "//input[contains(@id ,'user-phone')]";
    static final String FIELD_EMAIL_XPATH = "//input[contains(@id ,'user-email')]";
    static final String FIELD_COUNTRY_XPATH = "//input[contains(@id ,'country')]";
    static final String FIELD_MESSAGE_XPATH = "//div[contains(@id ,'textarea-wrapper')]";
    static final String BTN_RESET_XPATH = "//input[contains(@class ,'Reset Form')]";
    static final String BTN_SEND_XPATH = "//input[contains(@value ,'Send Request')]";
    static final String SLIDER_CAPTURE_XPATH = "//div[contains(@class ,'noUi-origin')]";
    static final String SLIDER_POINTER_XPATH = "//div[contains(@class ,'noUi-origin')]//div";

    @FindBy(xpath = FIELD_NAME_XPATH)         WebElement fieldName;
    @FindBy (xpath = FIELD_COMPANY_XPATH)     WebElement fieldCompany;
    @FindBy (xpath = FIELD_CITY_XPATH)        WebElement fieldCity;
    @FindBy (xpath = FIELD_PHONE_XPATH)       WebElement fieldPhone;
    @FindBy (xpath = FIELD_EMAIL_XPATH)       WebElement fieldEmail;
    @FindBy (xpath = FIELD_COUNTRY_XPATH)     WebElement fieldCountry;
    @FindBy (xpath = FIELD_MESSAGE_XPATH)     WebElement fieldMessage;
    @FindBy (xpath = BTN_RESET_XPATH)         WebElement btnReset;
    @FindBy (xpath = BTN_SEND_XPATH)          WebElement btnSend;
    @FindBy (xpath = SLIDER_CAPTURE_XPATH)    WebElement sliderCapture;
    @FindBy (xpath = SLIDER_POINTER_XPATH)    WebElement sliderPointer;

    public void sendRequest() {

    }

    public void mandatoryFields(){

    }

    public void fileAttach(){

    }

    public void captureDrag(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script = "document.getElementsByClassName(\"intro\").setAttribute(class, noUi-handle noUi-handle-lower noUi-active);";

        js.executeScript(script,sliderPointer);




        String fieldValue = sliderPointer.getAttribute("class");

        System.out.println(fieldValue);
    }

    public void formReset(){

    }



}
//noUi-handle noUi-handle-lower noUi-active