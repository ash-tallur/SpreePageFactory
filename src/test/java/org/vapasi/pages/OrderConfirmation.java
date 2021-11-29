package org.vapasi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {

    WebDriver driver;

    @FindBy(css="main#content > div")
    WebElement confirmMessage;

    public OrderConfirmation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String confirmOrderMsg(){

        String actualValue = confirmMessage.getText();
        return actualValue;
    }

}
