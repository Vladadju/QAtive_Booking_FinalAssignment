package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    public abstract void createWebdriver(String browserVersion);

    public void quitWebrdriver(){
        if (null != driver){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver(String browserVersion){
        if (null==driver){
            createWebdriver(browserVersion);
        }
        return driver;
    }

}
