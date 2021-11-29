package org.vapasi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "spree_user_email")
    WebElement userEmailTextBox;

    @FindBy(id = "spree_user_password")
    WebElement passwordTextBox;

    @FindBy(css="input[type='checkbox']")
    WebElement checkbox;

    @FindBy(css = "input[value='Login']")
    WebElement loginBtn;


    //parameterised constructor
    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userEmail, String password){

        userEmailTextBox.sendKeys(userEmail);
        passwordTextBox.sendKeys(password);
        checkbox.click();
        loginBtn.click();

    }





}
