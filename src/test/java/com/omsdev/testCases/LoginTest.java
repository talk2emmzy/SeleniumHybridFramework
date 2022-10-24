package com.omsdev.testCases;

import com.omsdev.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass
{
    @Test
    public void loginTest()
    {
        logger.info("Url is Opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username is entered");
        lp.setPassword(password);
        logger.info("Password is entered");

        lp.clickLogin();
        logger.info("Login button is clicked");

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Test Passed");
        }
        else
        {
            Assert.assertTrue(false);
            logger.info("Test Failed");
        }
    }


}
