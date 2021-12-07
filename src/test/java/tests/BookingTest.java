package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookingTest {
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
        driver.quit();
    }

    // Positive test
    @Test
    public void bookingDestination() throws IOException {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.fillUpAccommodationForm("Srpski", "Kopaonik", "31 decembar 2021", "15 januar 2022", "3");
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-searchbox__row.u-clearfix.-title")).getText(), "Traži");
        bookingHomePage.takeScreenshot("bookingDestination");
    }

    // Negative test
    @Test

    public void bookingNegativeDestination() throws IOException {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wait);
        bookingHomePage.fillUpAccommodationForm("Srpski", "", "31 decembar 2021", "15 januar 2022", "3");
        Assert.assertEquals(driver.findElement(By.cssSelector("#destination__error")).getText(), "Greška:\nUnesite destinaciju da biste počeli pretragu.");
        bookingHomePage.takeScreenshot("NegativeDestination");
    }


}

