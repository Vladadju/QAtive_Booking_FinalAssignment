package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends BasePage {
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
    @FindBy(css = "#vL5s-dateRangeInput-display-start")
    WebElement dayOfDeparture;
    @FindBy(css = "vL5s-dateRangeInput-display-end-inner")
    WebElement dayOfReturn;
    @FindBy(css = "iV8D-switch-display-status")
    WebElement RoundTrip;
    @FindBy(xpath = "//div[@class='keel-grid v-c-p ']")
    WebElement ageOfPassenger;
    @FindBy(xpath = "//div[@class='col-cabin _iXn']")
    WebElement travellingClass;
    @FindBy(css = "#vL5s-submit")
    WebElement searchButton;










}
