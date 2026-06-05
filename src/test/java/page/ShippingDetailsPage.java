package page;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//input[@id='phone']")
    WebElement phno;

    @FindBy(xpath="//input[@name='street']")
    WebElement street;

    @FindBy(xpath="//*[@id=\"shippingForm\"]/div[3]/input")
    WebElement city;

    @FindBy(xpath="//*[@id=\"countries_dropdown_menu\"]")
    WebElement country;

    @FindBy(xpath="//*[@id=\"submitOrderBtn\"]")
    WebElement subBtn;

    @FindBy(xpath="//div[contains(text(),'Congrats!')]")
    WebElement successMsg;

    public ShippingDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phno));
        phno.clear();
        phno.sendKeys(phone);
    }

    public void enterStreet(String streetName) {
        wait.until(ExpectedConditions.visibilityOf(street));
        street.clear();
        street.sendKeys(streetName);
    }

    public void enterCity(String cityName) {
        wait.until(ExpectedConditions.visibilityOf(city));
        city.clear();
        city.sendKeys(cityName);
    }

    public void selectCountry(String countryName) {
        wait.until(ExpectedConditions.visibilityOf(country));
        new org.openqa.selenium.support.ui.Select(country)
                .selectByVisibleText(countryName);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(subBtn));
        subBtn.click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg))
                .getText();
    }
}