package selenium_core;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String browser) throws Exception {
        DriverManager driverManager;

        switch (browser) {
            case "Vhrome": {
                driverManager = new ChromeDriverManager();
            }
            break;
            case "Firefox": {
                driverManager = new FirefoxDriverManager();
            }
            break;
            default:
                throw new Exception("Browser" + browser + " not supported");
        }
        return driverManager;
    }
}
