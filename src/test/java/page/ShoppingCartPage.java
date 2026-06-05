package page;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//button[normalize-space()='3']")
    WebElement thirdPage;

    @FindBy(xpath="//h2[normalize-space()='Shipping Details']")
    WebElement shippingDetails;

    @FindBy(xpath="//*[@id=\"pagination-controls\"]/nav/button[22]")
    WebElement nextPage;

    @FindBy(xpath="//span[text()='Cucumber']/following::button[1]")
    WebElement pd1;

    @FindBy(xpath="//span[text()='Eggs']/following::button[1]")
    WebElement pd2;

    @FindBy(xpath="//span[text()='Protein Powder']/following::button[1]")
    WebElement pd3;

    @FindBy(xpath="//button[normalize-space()='PROCEED TO CHECKOUT']")
    WebElement checkout;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void safeClick(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOf(element));

        js.executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        js.executeScript("arguments[0].click();", element);
    }

    public void addtoCart(String item) {

        if (item.trim().equalsIgnoreCase("cucumber")) {

            safeClick(thirdPage);
            safeClick(pd1);
        }

        else if (item.trim().equalsIgnoreCase("eggs")) {

            safeClick(thirdPage);
            safeClick(pd2);
        }

        else if (item.trim().equalsIgnoreCase("protein powder")) {

            safeClick(nextPage);
            safeClick(pd3);
        }

        else {
            System.out.println("Invalid choice: " + item);
        }
    }

    public void checkout() {
        safeClick(checkout);
    }

    public boolean isShippingDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(shippingDetails));
        return shippingDetails.isDisplayed();
    }
}