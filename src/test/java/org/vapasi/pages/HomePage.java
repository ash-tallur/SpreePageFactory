package org.vapasi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "div[class = 'alert alert-notice']")
    WebElement loginSuccessMsg;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyLogin(){

        String actualText = loginSuccessMsg.getText();
        return actualText;
    }

}
