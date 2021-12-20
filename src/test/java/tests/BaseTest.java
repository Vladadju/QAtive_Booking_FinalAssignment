package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    DriverManager driverManager;

    public void setUp(String browser, String version, int wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        this.driver = driverManager.getWebDriver(version);
        this.driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public void quitDriver(){
        driverManager.quitWebDriver();
    }
}
