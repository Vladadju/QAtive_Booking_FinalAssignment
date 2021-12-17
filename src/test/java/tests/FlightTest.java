package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FlightsPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://booking.com/";

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver96.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(URL);
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(URL);
        } else {
            System.out.println("Browser not supported");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    // Verify that user will see available flights if he/she fill form correctly
    @Test
    public void bookingFlight() throws InterruptedException, IOException {

        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.fillFlightForm("Rome", "Belgrade","January 10","January 17");
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@id,'stops-title')]"))
                .getText(),"Stops");
        flightsPage.takeScreenshot("Booking Flight positive test");
    }
    // Verify that user will not see available flights if he/she do not enter airport destination
    @Test
    public void bookingFlight2() throws InterruptedException, IOException {

        FlightsPage flightsPage = new FlightsPage(driver, wait);
        flightsPage.fillFlightForm("Rome", "","January 10","January 17");
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'errorContent')]/ul/li/ul/li"))
                .getText(),"Please enter a 'To' airport.");
        flightsPage.takeScreenshot("Booking Flight negative test");
    }
}