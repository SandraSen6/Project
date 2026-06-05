package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import utility.ConfigReader;

public class ShippingDetailsTest extends Base {

    @Test
    public void details() {

        detail.enterPhone(ConfigReader.getProperty("phno"));
        detail.enterStreet(ConfigReader.getProperty("street"));
        detail.enterCity(ConfigReader.getProperty("city"));
        detail.selectCountry(ConfigReader.getProperty("country"));

        detail.clickSubmit();

        String actualMsg = detail.getSuccessMessage();

        Assert.assertTrue(
                actualMsg.toLowerCase().contains("congrats"),
                "Order confirmation message not displayed: " + actualMsg);
    }
}