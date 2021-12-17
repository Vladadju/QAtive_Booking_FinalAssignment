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
import pages.BookingHomePage;
import tests.BaseTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookingSteps extends BaseTest {
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
    public void iAddStartAndEndDate(String startDate, String endDate) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.selectDates(startDate, endDate);
    }

    @And("I will increase num of kids by one")
    public void iWillIncreaseNumOfKidsByOne() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.increaseKids();
    }

    @And("I will select age of child")    public void iWillSelectAgeOfChild() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        bookingHomePage.selectAgeOfKids("3");
    }

    @Then("I will see results of my choosen destination")
    public void iWillSeeResultsOfMyChoosenDestination() throws IOException {
        BookingHomePage bookingHomePage = new BookingHomePage(driver,wait);
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-searchbox__row.u-clearfix.-title")).getText(), "Traži");
        bookingHomePage.takeScreenshot("bookingDestination");
    }










}
