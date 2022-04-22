package com.keypointTask.StepDefinitions;

import com.keypointTask.Pages.Widgets_page;
import com.keypointTask.Utilities.BrowserUtils;
import com.keypointTask.Utilities.Driver;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WidgetsStepDef {

    Widgets_page Widget = new Widgets_page();
    Actions action = new Actions(Driver.get());

    @Then("Confirm {string} that appears after hovering")
    public void confirm_that_appears_after_hovering_the_button(String message) {

        String ExpectedHoverMessage = message;

        BrowserUtils.waitFor(1);

        if(message.contains("Button")){

            action.moveToElement(Widget.HoverMeToSeeButton).perform();

        }else {

            action.moveToElement(Widget.HoverMeToSeeTextBox).perform();
        }

        WebElement ActualHover = Driver.get().findElement(By.className("tooltip-inner"));

        String ActualHoverMessage = ActualHover.getAttribute("innerHTML");

        assertEquals(ExpectedHoverMessage, ActualHoverMessage);

    }

}
