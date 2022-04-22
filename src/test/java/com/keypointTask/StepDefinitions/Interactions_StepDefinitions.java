package com.keypointTask.StepDefinitions;

import com.keypointTask.Pages.Interaction_page;
import com.keypointTask.Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Interactions_StepDefinitions {

    Interaction_page Interactions = new Interaction_page();

    Actions action = new Actions(Driver.get());

    @Then("Verify that source item is on the target")
    public void verify_that_source_item_is_on_the_target() {

        String ExpectedMessage = "Dropped!";

        action.dragAndDrop(Interactions.SourceItem,Interactions.TargetItem).perform();

        Assert.assertEquals("Verify that source is dragged or not.",Interactions.TargetItem.getText(),ExpectedMessage);

    }


}
