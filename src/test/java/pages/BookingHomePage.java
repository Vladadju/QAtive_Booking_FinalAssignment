package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHomePage extends BasePage {
    public BookingHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
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

    @FindBy(css = ".bui-button.bui-button--secondary.bui-stepper__add-button ")
    WebElement increaseByOneAdults;

    @FindBy(css = ".bui-button.bui-button--secondary.bui-stepper__subtract-button ")
    WebElement decreaseByOneAdults;

    @FindBy(css = ".bui-button.bui-button--secondary.bui-stepper__add-button ")
    WebElement increaseByOneKids;







}
