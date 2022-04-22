package com.keypointTask.StepDefinitions;

import com.keypointTask.Pages.Login_page;
import com.keypointTask.Utilities.BrowserUtils;
import com.keypointTask.Utilities.ConfigurationReader;
import com.keypointTask.Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SauceDemoLogin_StepDefinition {

    Login_page loginPage = new Login_page();


    @Given("The users should land on login page")
    public void the_users_should_land_on_login_page() {Driver.get().get(ConfigurationReader.get("url2"));

    }


    @Then("The users should login with {string} {string} successfully")
    public void the_users_should_login_with_and_successfully(String username, String password) {

        loginPage.Login(username,password);
        BrowserUtils.waitFor(1);
        String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals("User couldn't login successfully", ExpectedUrl,Driver.get().getCurrentUrl());

    }

    @Then("The users should not login with {string} {string}")
    public void the_users_should_not_login_with_and(String username, String password) {

        loginPage.Login(username, password);
        BrowserUtils.waitFor(1);
        String ExpectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(username+" shouldn't have logged in with invalid credentials",ExpectedUrl, Driver.get().getCurrentUrl());

    }
}
