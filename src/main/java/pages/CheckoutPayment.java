package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPayment {

    WebDriver driver;

    @FindBy(css = "input[id='order_payments_attributes__payment_method_id_3']")
    WebElement paymentOption;

    @FindBy(css="input[value='Save and Continue']")
    WebElement saveBtn;

    public CheckoutPayment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void choosePayment(){
        paymentOption.click();
        saveBtn.click();

    }
}
