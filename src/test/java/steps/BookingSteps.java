package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BookingHomePage;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;

public class BookingSteps extends BaseTest {

    @Before
    public void setUpCucumber() throws Exception {
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver95.exe");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        setUp("Chrome","95",30);



    }
    @After
    public void tearDown(){
       // quitDriver();
    }


    @Given("I am on booking home page")
    public void iAmOnBookingHomePage() {
        driver.get("https://www.booking.com/");

    }

    @When("I change language to {string}")
    public void iChangeLanguageTo(String language) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.selectLanguage(language);
    }

    @And("I add destination {string}")
    public void iAddDestination(String destination) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.enterDestination(destination);

    }

    @And("I add start and end date {string} {string}")
    public void iAddStartAndEndDate(String start, String end) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.selectDates(start, end);
    }
}
