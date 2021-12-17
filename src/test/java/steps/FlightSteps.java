package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.FlightsPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FlightSteps extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUpCucumber() throws Exception {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver96.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        setUp("Chrome","96",30);



    }
    @After
    public void tearDown(){
        quitDriver();
    }
    @Given("I am on a booking home page")
    public void iAmOnABookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @When("I will click on flight button end enter in flight page")
    public void iWillClickOnFlightButtonEndEnterInFlightPage() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.clickFlightButton();
        driver.navigate().to("https://booking.kayak.com/");
        Thread.sleep(1000);
    }

    @And("I will enter destination from {string}")
    public void iWillEnterDestinationFrom(String destinationFrom) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.enterAirportFrom(destinationFrom);
    }

    @And("I will enter destination to {string}")
    public void iWillEnterDestinationTo(String destinationTo) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.enterAirportTo(destinationTo);
    }

    @And("I will enter dates {string} {string}")
    public void iWillEnterDates(String startDate, String endDate) {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.selectDatesOfDepartureAndReturn(startDate, endDate);
    }

    @And("I will enter flying class")
    public void iWillEnterFlyingClass() {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.selectFirstClass();
    }

    @And("I will select numb of passengers")
    public void iWillSelectNumbOfPassengers() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.selectPassengers();
    }

    @And("I will click on search button")
    public void iWillClickOnSearchButton() {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.clickSearchButton();
    }

    @Then("I will se results of my choices flight tickets")
    public void iWillSeResultsOfMyChoicesFlightTickets() throws IOException {
        FlightsPage flightsPage = new FlightsPage(driver, wait);
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@id,'stops-title')]"))
                .getText(),"Stops");
        flightsPage.takeScreenshot("Booking Flight positive test");
    }
}
