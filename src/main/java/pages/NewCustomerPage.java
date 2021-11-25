package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

    WebDriver driver;

    @FindBy(id = "spree_user_email")
    WebElement userEmailInputBox;

    @FindBy(id = "spree_user_password")
    WebElement passwordInputBox;

    @FindBy(id="spree_user_password_confirmation")
    WebElement passwordConfirm;

    @FindBy(css = "input[value='Create']")
    WebElement createBtn;

    public NewCustomerPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewLoginCredentials(String userEmail, String password,String passwordConfirmation){

        userEmailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        passwordConfirm.sendKeys(passwordConfirmation);
        createBtn.click();
    }
}
