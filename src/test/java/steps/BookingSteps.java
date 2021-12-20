package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BookingHomePage;

import tests.BaseTest;

import java.io.IOException;


public class BookingSteps extends BaseTest {


    @Before
    public void setUpCucumber() throws Exception {


        setUp("Chrome", "96", 30);


    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("I am on booking home page")
    public void iAmOnBookingHomePage() {

        driver.get("https://www.booking.com/");

    }

    @When("I change language to {string}")
    public void iChangeLanguageTo(String language) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.clickOnLanguageIcon();
        bookingHomePage.selectLanguage(language);
    }

    @And("I add destination {string}")
    public void iAddDestination(String destination) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.enterDestination(destination);
    }

    @And("I add start and end date {string} {string}")
    public void iAddStartAndEndDate(String startDate, String endDate) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.selectDates(startDate, endDate);
    }

    @And("I will increase num of kids by one and I will select age")
    public void iWillIncreaseNumOfKidsByOneAndIWillSelectAge() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.clickGuests();
        bookingHomePage.increaseKids();
        bookingHomePage.selectAgeOfKids("3");
    }

    @And("I will will click on search button")
    public void iWillWillClickOnSearchButton() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.clickSearch();
    }


    @Then("I will see results of my choosen destination")
    public void iWillSeeResultsOfMyChoosenDestination() throws IOException {

        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-searchbox__row.u-clearfix.-title")).getText(), "Traži");
        bookingHomePage.takeScreenshot("bookingDestination");
    }


}
