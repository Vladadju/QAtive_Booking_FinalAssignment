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
    String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME");
    public FlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='bui-header bui-header--logo-large bui-u-hidden-print bui-header--rounded-tabs']/nav[2]/ul[1]/li[2]")
    WebElement flightButton;
    @FindBy(css = "#vL5s-origin-airport-display-inner")
    WebElement airportFrom;
    @FindBy(css = "#vL5s-destination-airport-display")
    WebElement airportTo;
    @FindBy(css = "#CJaQ-dateRangeInput-display-start-inner")
    WebElement dayOfDeparture;
    @FindBy(css = "#stl-jam-cal-nextMonth")
    WebElement nextButton;
    @FindBy(css = "vL5s-dateRangeInput-display-end-inner")
    WebElement dayOfReturn;
    @FindBy(css = "iV8D-switch-display-status")
    WebElement RoundTrip;
    @FindBy(xpath = "//div[@class='keel-grid v-c-p ']")
    WebElement ageOfPassenger;
    @FindBy(xpath = "//ul[@id='dSTr-cabinType-widget-list']")
    WebElement travellingClass;

    @FindBy(css = "#vL5s-submit")
    WebElement searchButton;
    String travellClass = "//div[@id='dSTr-cabinType-widget-list-wrapper']/ul[1]/li[$]";
    String date = "//div[@aria-label='$']";

    public void clickFlightButton() {
        flightButton.click();
    }

    public void enterAirportFrom(String airportFromText) {
        airportFrom.sendKeys(airportFromText);
    }

    public void enterAirportTo(String airpotToText) {
        airportTo.sendKeys(airpotToText);
    }

    public void selectDatesOfDeparture(String startDate, String endDate) {
        dayOfReturn.click();
        while (true) {
            List<WebElement> startDataList = driver.findElements(By.xpath("//div[@aria-label='" + startDate + "']"));

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
                driver.findElement(By.xpath("//div[@aria-label='" + endDate + "']")).click();
                break;
            }
        }

    }
    public void selectDates(String startDate, String endDate) {
       dayOfDeparture.click();
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
                driver.findElement(By.xpath("//div[@aria-label='" + endDate + "']")).click();
                break;
            }
        }



}

    public void clickSearchButton(){
        searchButton.click();
    }





}
