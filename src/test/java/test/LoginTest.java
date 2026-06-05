package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import utility.ConfigReader;

public class LoginTest extends Base {

    @Test
    public void login() {

        // Step 1: Verify Title
        Assert.assertEquals(
                login.getTitle(),
                ConfigReader.getProperty("expectedTitle"),
                "Title mismatch");

        // Step 2: Login Action
        login.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("pswd"));

        // Step 3: Validate Dashboard / Cart page
        Assert.assertTrue(
                login.isShoppingCartDisplayed(),
                "Shopping Cart section is not displayed");
    }
}