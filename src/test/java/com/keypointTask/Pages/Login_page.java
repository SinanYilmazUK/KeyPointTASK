package com.keypointTask.Pages;

import com.keypointTask.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page extends BasePage {

    public Login_page(){

        PageFactory.initElements(Driver.get(), this);

}
    @FindBy(id = "user-name")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    public void Login(String username, String password){
     Username.sendKeys(username);
     Password.sendKeys(password);
     loginButton.click();
    }

}
