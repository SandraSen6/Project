package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import utility.ConfigReader;

public class ShoppingCartTest extends Base {

    @Test
    public void cart() {

        cart.addtoCart(ConfigReader.getProperty("item1"));
        cart.addtoCart(ConfigReader.getProperty("item2"));
        cart.addtoCart(ConfigReader.getProperty("item3"));

        cart.checkout();

        Assert.assertTrue(
                cart.isShippingDisplayed(),
                "Shipping Details page is not displayed");
    }
}