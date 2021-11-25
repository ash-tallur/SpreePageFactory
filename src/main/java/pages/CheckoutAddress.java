package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutAddress {

    WebDriver driver;

    @FindBy(css = "input#order_bill_address_attributes_firstname")
    WebElement firstNameTextBox;

    @FindBy(css = "input#order_bill_address_attributes_lastname")
    WebElement lastNameTextBox;

    @FindBy(css = "input#order_bill_address_attributes_address1")
    WebElement address1TextBox;

    @FindBy(css = "input#order_bill_address_attributes_address2")
    WebElement address2TextBox;

    @FindBy(css = "input#order_bill_address_attributes_city")
    WebElement cityTextBox;

    @FindBy(css = "select#order_bill_address_attributes_state_id")
    WebElement stateDropdown;

    @FindBy(css = "input#order_bill_address_attributes_zipcode")
    WebElement zipcodeTextBox;

    @FindBy(css="select[id ='order_bill_address_attributes_country_id']")
    WebElement countryDropdown;

    @FindBy(css="input#order_bill_address_attributes_phone")
    WebElement phoneTextBox;

    @FindBy(css="input[id = 'save_user_address']")
    WebElement saveAddressUncheck;

    @FindBy(css="form#checkout_form_address > div:nth-of-type(3) > div > input")
    WebElement saveBtn;

    @FindBy(css="input[id='order_bill_address_id_0']")
    WebElement otherAddress;

    public CheckoutAddress(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAddress(String fname,String lname,String address1,String address2,String city,String state,String zipcode,String country,String phone){

        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(fname);
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys(lname);
        address1TextBox.clear();
        address1TextBox.sendKeys(address1);
        address2TextBox.clear();
        address2TextBox.sendKeys(address2);
        cityTextBox.clear();
        cityTextBox.sendKeys(city);
        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText(state);
        zipcodeTextBox.clear();
        zipcodeTextBox.sendKeys(zipcode);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(country);
        phoneTextBox.clear();
        phoneTextBox.sendKeys(phone);
        saveAddressUncheck.click();
    }

    public void saveAddress(){
        saveBtn.click();
    }

    public void chooseOtherAddress(){
        otherAddress.click();
    }



}
