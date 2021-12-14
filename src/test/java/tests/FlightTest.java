package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;

import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://booking.kayak.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver96.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void bookingFlight() throws InterruptedException {

        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.enterAirportFrom("Rome");
        flightsPage.enterAirportTo("Paris");
        // month dd
        flightsPage.selectDatesOfDepartureAndReturn("January 10", "January 17");
        flightsPage.selectClass();
        flightsPage.selectPassengers();
        flightsPage.clickSearchButton();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@id, 'stops-title')]"))
                .getText(),"Stops");
    }
}