package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserLoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/signup']")
    WebElement createNewUser;

    public CreateNewUserLoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createUser(){
        createNewUser.click();
    }
}
