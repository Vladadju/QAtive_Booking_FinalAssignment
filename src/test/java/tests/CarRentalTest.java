package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarRentalsPage;

import java.util.concurrent.TimeUnit;

public class CarRentalTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://www.booking.com/";

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
    //Positive test
    @Test
    public void rentingCar() throws InterruptedException {
        CarRentalsPage carRentalsPage = new CarRentalsPage(driver,wait);
        //carRentalsPage.fillCarRentalFormFull("Srpski","Beograd","Novi Sad","10", "17","29");
        carRentalsPage.clickCarRentalIcon();
        carRentalsPage.clickOnLanguageIcon();
        carRentalsPage.selectLanguage("Srpski");
        carRentalsPage.checkDifferentLocation();
        carRentalsPage.enterStartLocation("Beograd");
        carRentalsPage.enterEndLocation("Novi Sad");
        carRentalsPage.selectDates("10", "17");

    }
}
