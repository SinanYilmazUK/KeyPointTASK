package com.keypointTask.Pages;

import com.keypointTask.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

}
