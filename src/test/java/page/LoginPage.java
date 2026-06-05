package page;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submitLoginBtn")
    WebElement submit;

    @FindBy(id = "message")
    WebElement errorMsg;

    private By shoppingCartBy = By.xpath("//h2[@class='section-header']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Title validation
    public String getTitle() {
        return driver.getTitle();
    }

    // Login action
    public void login(String user, String pass) {

        email.clear();
        email.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        submit.click();

        // wait for page transition
        wait.until(ExpectedConditions.urlContains("ecommerce"));
    }

    // Verify shopping cart section
    public boolean isShoppingCartDisplayed() {

        WebElement cart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(shoppingCartBy));

        return cart.isDisplayed();
    }

    // Error validation
    public boolean isErrorDisplayed() {
        try {
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}