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
import pages.BookingHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookingTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://www.booking.com/";

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        if (browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver98.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(URL);
        }else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(URL);
        }else {
            System.out.println("Browser not supported");
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Positive test
    @Test
    public void bookingDestination() throws IOException {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.fillUpAccommodationForm("Srpski", "Kopaonik", "20 februar 2022", "25 februar 2022", "3");
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-searchbox__row.u-clearfix.-title")).getText(), "Traži");
        bookingHomePage.takeScreenshot("bookingDestination");
    }

    // Negative test , empty destination field
    @Test

    public void bookingNegativeDestination() throws IOException {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.fillUpAccommodationForm("Srpski", "", "20 februar 2022", "25 februar 2022", "3");
        Assert.assertEquals(driver.findElement(By.cssSelector("#destination__error")).getText(), "Greška:\nUnesite destinaciju da biste počeli pretragu.");
        bookingHomePage.takeScreenshot("NegativeDestination");
    }




}

