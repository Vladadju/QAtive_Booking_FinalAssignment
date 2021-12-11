package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;

import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://www.booking.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver95.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void bookingFlight() {

        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.clickFlightButton();
        //flightsPage.selectClass("b");

        //driver.findElement(By.cssSelector(".Flights-Search-FlightCabinSelect")).click();
       // driver.findElement(By.xpath("//div[@aria-label='Departure date input']")).click();
        flightsPage.selectDates("16 January", "22 January 31");
        //driver.findElement(By.xpath("//div[@aria-label='Departure date input']")).click();
        //("16 January", "22 February");
    }
}