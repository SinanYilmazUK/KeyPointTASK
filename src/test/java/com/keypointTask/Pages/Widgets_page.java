package com.keypointTask.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Widgets_page extends BasePage {

    @FindBy(id = "toolTipButton")
    public WebElement HoverMeToSeeButton;

    @FindBy(id = "texFieldToolTopContainer")
    public WebElement HoverMeToSeeTextBox;




}
