package com.keypointTask.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Interaction_page extends BasePage {

    @FindBy(id = "draggable")
    public WebElement SourceItem;

    @FindBy(id = "droppable")
    public WebElement TargetItem;

}
