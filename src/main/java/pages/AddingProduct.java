package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingProduct {
    WebDriver driver;

    @FindBy(id="quantity")
    WebElement quantityTextBox;

    @FindBy(id="add-to-cart-button")
    WebElement addCartBtn;

    public AddingProduct(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addProductToCart(String quantity){

        quantityTextBox.clear();
        quantityTextBox.sendKeys(quantity);

        //here we are clicking on add to cart after sending the quantity value
        addCartBtn.click();
    }
}
