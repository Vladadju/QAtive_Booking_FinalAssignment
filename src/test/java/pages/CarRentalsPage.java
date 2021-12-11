package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CarRentalsPage extends BasePage{
    public CarRentalsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Car rentals')]")
    WebElement carRentalsButton;
    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    WebElement languageButton;
    String languageLinkXpath = "//div[@class='bui-group bui-group--large']/div[2]//div[contains(text(),'$')]/../..";
    @FindBy(css = "#return-location-different")
    WebElement returnToDifferentLocation;
    @FindBy(css = "#ss_origin")
    WebElement startLocation;
    @FindBy(css = "#ss")
    WebElement endLocation;
    @FindBy(xpath = "//div[@class='sb-searchbox__input sb-date-field__field sb-date__field-svg_icon']/button[contains(@aria-label,'Otvorite kalendar')]")
    WebElement date;
    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;
    @FindBy(xpath = "//span[@class='bui-checkbox__label']")
    WebElement checkAgeOfDriver;
    @FindBy(css = "#driverAgeInput")
    WebElement driverAgeInput;
    @FindBy(xpath = "//div[@class='c2-wrapper c2-wrapper-s-position-undefined c2-wrapper-s-checkin c2-wrapper-s-has-arrow']/div[2]/div[2]/div[2]")
    WebElement next;

    public void clickCarRentalIcon(){
        carRentalsButton.click();
    }
    public void clickOnLanguageIcon(){
        languageButton.click();
    }
    public void selectLanguage(String language) {
        driver.findElement(By.xpath(languageLinkXpath.replace("$", language))).click();
    }
    public void checkDifferentLocation(){
        returnToDifferentLocation.click();
    }
    public void enterStartLocation(String startLocationText){
        startLocation.sendKeys(startLocationText);
    }
    public void enterEndLocation(String finishLocationText){
        endLocation.sendKeys(finishLocationText);
    }
    public void selectDates(String startDate, String endDate) {
        date.click();
        while (true) {
            List<WebElement> startDataList = driver.findElements(By.xpath("//td[@class='c2-day c2-day-s-in-range']/span[contains(text(),'" + startDate + "']"));
////td[@class='c2-day c2-day-s-in-range']/span[contains(text(),'3')]
            if (startDataList.size() == 0) {
                next.click();
            } else {
                driver.findElement(By.xpath("//td[@class='c2-day c2-day-s-in-range']/span[contains(text(),''" + startDate + "']")).click();
                break;

            }
        }
        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//td[@class='c2-day c2-day-s-in-range']/span[contains(text(),'" + endDate + "']"));

            if (endDateList.size() == 0) {
                next.click();
            } else {
                driver.findElement(By.xpath("//td[@class='c2-day c2-day-s-in-range']/span[contains(text(),'" + endDate + "']")).click();
                break;
            }
        }

    }
    public void setCheckAgeOfDriver(){
        checkAgeOfDriver.click();
    }
    public void enterAgeOfDriver(String ageOfDriverText){
        driverAgeInput.sendKeys(ageOfDriverText);
    }









}
