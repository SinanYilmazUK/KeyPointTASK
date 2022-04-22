package com.keypointTask.StepDefinitions;

import com.keypointTask.Pages.Alert_page;
import com.keypointTask.Utilities.BrowserUtils;
import com.keypointTask.Utilities.ConfigurationReader;
import com.keypointTask.Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class Alerts_StepDefinition {

    Alert_page Alerts = new Alert_page();

    @Given("The user goes to ToolsQA url")
    public void the_user_goes_to_ToolsQA_url() {Driver.get().get(ConfigurationReader.get("url1"));

    }


    @When("The user click the {string} module and clicks on {string} tag")
    public void the_user_click_the_module_and_clicks_on_tag(String tags, String modules) {

        WebElement tag = Driver.get().findElement(By.xpath("//h5[contains(text(),'"+tags+"')]"));

        BrowserUtils.scrollToElement(tag);

        tag.click();

        List<WebElement> headerText = Driver.get().findElements(By.xpath("//div[@class = 'header-text']"));

        List<String> headerTextList = BrowserUtils.getElementsText(headerText);


        int indexofheader = headerTextList.indexOf(tags) + 1;

        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[contains(text(), '" + tags + "')]/../../../div/ul/li"));

        List<String> moduleList = BrowserUtils.getElementsText(elements);

        int indexofmodule = moduleList.indexOf(modules);

        WebElement module = Driver.get().findElement(By.xpath("(//ul[@class='menu-list'])[" + indexofheader + "]//li[@id = 'item-" + indexofmodule + "']"));

        BrowserUtils.waitFor(2);

        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("arguments[0].click()", module);

    }

    @Then("Handling the Click Button to See alert")
    public void handling_the_Click_Button_to_See_alert() {

        Alerts.AlertSeeClickButton.click();

        Alert alert = Driver.get().switchTo().alert();

        alert.accept();

    }

    @Then("Handling the Click Button appears after 5 seconds alert")
    public void handling_the_Click_Button_appears_after_5_seconds_alert() {

        Alerts.WaitForAlertButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.get(),30);

        wait.until  (ExpectedConditions.alertIsPresent()).accept();

    }

    @Then("Handling the confirm box appear alert")
    public void handling_the_confirm_box_appear_alert() {

        Alerts.AlertConfirmButton.click();

        Alert alert = Driver.get().switchTo().alert();

        alert.accept();

        String ExpectedResult = "You selected Ok";

        Assert.assertEquals("Verify that selection matches with expected result ", Alerts.confirmResult.getText(),ExpectedResult);

    }


    @Then("Handling prompt box appear alert")
    public void handling_prompt_box_appear_alert() {

        Alerts.AlertPromptButton.click();

        Alert alert = Driver.get().switchTo().alert();

        String message = "ToolsQA";
        String ExpectedResult = "You entered " + message;

        alert.sendKeys(message);
        alert.accept();

        Assert.assertEquals("Verify the message matches with the written in the text box", Alerts.promptResult.getText(),ExpectedResult);

    }


}
