package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingHomePage extends BasePage {
    public BookingHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    WebElement languageButton;

    String languageLinkXpath = "//div[@class='bui-group bui-group--large']/div[2]//div[contains(text(),'$')]/../..";

    @FindBy(css = "#ss")
    WebElement destination;
    @FindBy(css = ".xp__dates.xp__group")
    WebElement dates;
    @FindBy(css = ".bui-calendar__control.bui-calendar__control--next")
    WebElement next;
    @FindBy(css = ".xp__input-group.xp__guests")
    WebElement numbOfGuests;
    @FindBy(xpath = "//div[@class='bui-stepper__wrapper sb-group__stepper-a11y']/button[contains(@aria-label, 'Odrasli: povećajte broj')] ")
    WebElement increaseByOneAdults;
    @FindBy(xpath = "//div[@class='bui-stepper__wrapper sb-group__stepper-a11y']/button[contains(@aria-label, 'Odrasli: smanjite broj')]")
    WebElement decreaseByOneAdults;
    @FindBy(xpath = "//div[@class='bui-stepper__wrapper sb-group__stepper-a11y']/button[contains(@aria-label, 'Deca: povećajte broj')]")
    WebElement increaseByOneKids;
    @FindBy(xpath = "//div[@class='bui-stepper__wrapper sb-group__stepper-a11y']/button[contains(@aria-label, 'Deca: smanjite broj')]")
    WebElement decreaseByOneKids;
    @FindBy(css = ".sb-group-field-has-error")
    WebElement ageOfKids;
    @FindBy(xpath = "//div[@class='bui-stepper__wrapper sb-group__stepper-a11y']/button[contains(@aria-label, 'Jedinice: povećajte broj')]")
    WebElement rooms;

    public void selectLanguage(String language) {
        click(languageButton);
        click(driver.findElement(By.xpath(languageLinkXpath.replace("$", language))));
    }

    public void enterDestination(String destinationText) {
        typeText(destination, destinationText);
    }

    public void selectDates(String startDate, String endDate) {
        click(dates);
        while (true) {
            List<WebElement> startDataList = driver.findElements(By.xpath("//span[@aria-label='" + startDate + "']"));

            if (startDataList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + startDate + "']")));
                break;

            }
        }
        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//span[@aria-label='" + endDate + "']"));

            if (endDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + endDate + "']")));
                break;
            }
        }

    }



}
