package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutDelivery {

    WebDriver driver;

    @FindBy(css = "input[data-cost = '$5.00']")
    WebElement shipmentType;

    @FindBy(css = "input[value='Save and Continue']")
    WebElement saveBtn;

    public CheckoutDelivery(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void saveShipment(){
        shipmentType.click();
        saveBtn.click();
    }

}
