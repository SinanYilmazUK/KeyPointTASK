package com.keypointTask.StepDefinitions;

import com.keypointTask.Utilities.BrowserUtils;
import com.keypointTask.Utilities.ConfigurationReader;
import com.keypointTask.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before ("@demoQA")
    public void demoSetUp(){
        Driver.get().get(ConfigurationReader.get("url1"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Before ("@sauceDemo")
    public void SauceSetUp(){
        Driver.get().get(ConfigurationReader.get("url2"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }
}
