package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='bui-header bui-header--logo-large bui-u-hidden-print bui-header--rounded-tabs']/nav[2]/ul[1]/li[2]")
    WebElement flightButton;
    ////div[contains(@id,'origin-airport-display-inner')]
    @FindBy(xpath = "//input[contains(@id,'origin-airport')]")
    List<WebElement> airportInputFrom;
    @FindBy(xpath = "//div[contains(@id,'origin-airport-display-inner')]")
    WebElement airportFrom;
    @FindBy(xpath = "//div[contains(@id,'destination-airport-display-inner')]")
    WebElement airportTo;
    @FindBy(xpath = "//input[contains(@id,'destination-airport')]")
    List<WebElement> airportToInputForm;
    @FindBy(xpath = "//ul[contains(@id, 'destination-airport-nearbyOptions')]")
    WebElement checkNearbyAirports;
    @FindBy(xpath = "//ul[contains(@id, 'origin-airport-nearbyOptions')]")
    WebElement checkOriginNearbyAirports;
    @FindBy(xpath = "//div[contains(@class, 'destination-images')]")
    WebElement destinationAirportImage;
    @FindBy(css = "#CJaQ-dateRangeInput-display-start-inner")
    WebElement dayOfDeparture;
    @FindBy(xpath = "//div[contains(@id,'nextMonth')]")
    WebElement nextButton;
    @FindBy(xpath = "//div[contains(@id,'dateRangeInput-display-start-inner')]")
    WebElement clickDateField;
    @FindBy(xpath = "//div[contains(@id,'dateRangeInput-start')]")
    List<WebElement> dateFieldFill;
    @FindBy(css = "iV8D-switch-display-status")
    WebElement RoundTrip;
    @FindBy(xpath = "//div[@class='keel-grid v-c-p ']")
    WebElement clickAgeOfPassenger;
    @FindBy(xpath = "//div[contains(@id, 'travelersAboveForm-youth')]/div[1]/div[3]/button")
    WebElement selectYouthByOne;
    @FindBy(xpath = "//div[contains(@id,'cabinType-widget-display-status')]")
    WebElement clickTravelClass;
    @FindBy(xpath = "//div[contains(@id,'cabinType-widget-list-wrapper')]/ul[1]/li[4]")
    WebElement firstClassInput;
    @FindBy(xpath = "//div[contains(@id,'cabinType-widget-list-wrapper')]/ul[1]/li[3]")
    WebElement businessClassInput;
    @FindBy(xpath = "//div[contains(@id,'cabinType-widget-list-wrapper')]/ul[1]/li[2]")
    WebElement premiumClassInput;
    @FindBy(xpath = "//div[contains(@id,'cabinType-widget-list-wrapper')]/ul[1]/li[1]")
    WebElement economyClassInput;
    @FindBy(xpath = "//div[contains(@class,'keel-container s-t-bp')]")
    WebElement clickEmptySpace;

    @FindBy(xpath = "//div[contains(@id, 'col-button-wrapper')]")
    WebElement searchButton;
    String travelClass = "//div[contains(@id,'cabinType-widget-list-wrapper')]/ul[1]/li[$]";

    String date = "//div[@aria-label='$']";

    public void clickFlightButton() {
        flightButton.click();
    }

    public void enterAirportFrom(String airportFromText) throws InterruptedException {
        airportFrom.click();
        Thread.sleep(500);
        airportInputFrom.get(0).sendKeys(airportFromText);
        Thread.sleep(500);
        //checkOriginNearbyAirports.click();
       // destinationAirportImage.click();
        clickEmptySpace.click();
    }
    public void enterAirportTo(String airportToText) throws InterruptedException {
        airportTo.click();
        Thread.sleep(500);
        airportToInputForm.get(0).sendKeys(airportToText);
        Thread.sleep(500);
       // checkNearbyAirports.click();
        clickEmptySpace.click();
    }
    public void selectDatesOfDepartureAndReturn(String startDate, String endDate) {
        clickDateField.click();
        dateFieldFill.get(1).click();
        while (true) {
            List<WebElement> startDataList = driver.findElements(By.xpath("//div[@aria-label='"+startDate+"']"));

            if (startDataList.size() == 0) {
                nextButton.click();
            } else {
                driver.findElement(By.xpath("//div[@aria-label='" + startDate + "']")).click();
                break;

            }
        }
        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//div[@aria-label='" + endDate + "']"));

            if (endDateList.size() == 0) {
                nextButton.click();
            } else {
                driver.findElement(By.xpath("//div[@aria-label='"+endDate+"']")).click();
                break;
            }
        }
        clickEmptySpace.click();

    }
    public void selectFirstClass(){
        clickTravelClass.click();
        firstClassInput.click();

    }
    public void selectBusinessClass(){
        clickTravelClass.click();
        businessClassInput.click();

    }
    public void selectPremiumClass(){
        clickTravelClass.click();
        premiumClassInput.click();

    }
    public void selectEconomyClass(){
        clickTravelClass.click();
        economyClassInput.click();

    }
    public void selectPassengers() throws InterruptedException {
        clickAgeOfPassenger.click();
        selectYouthByOne.click();

        clickEmptySpace.click();
    }
    public void clickSearchButton(){
        searchButton.click();
    }

    public void fillFlightForm(String airportFromText, String airportToText,String startDate, String endDate) throws InterruptedException {
        clickFlightButton();
        driver.navigate().to("https://booking.kayak.com/");
        Thread.sleep(1000);
        enterAirportFrom(airportFromText);
        enterAirportTo(airportToText);
        selectDatesOfDepartureAndReturn(startDate, endDate);
        selectBusinessClass();
        selectPassengers();
        clickSearchButton();



    }





}
