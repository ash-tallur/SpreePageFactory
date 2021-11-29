package org.vapasi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyCartPage {
    WebDriver driver;

    @FindBy(css="td[class='lead']")
    WebElement totalText;

    @FindBy(id = "checkout-link")
    WebElement checkoutBtn;

    public VerifyCartPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String verifyTotal(){

        //getting the text of the total and putting in actual
        String actual = totalText.getText();
        return actual;

    }

    public void checkout(){
        checkoutBtn.click();
    }



}
