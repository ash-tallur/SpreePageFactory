package org.vapasi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AppTest extends BaseClassTest{

    HomePage loggedSuccess = new HomePage(driver);
    CategorySelectPage selectCategory = new CategorySelectPage(driver);
    AddingProduct addProduct = new AddingProduct(driver);
    VerifyCartPage checkCart = new VerifyCartPage(driver);
    CheckoutAddress addressFilling = new CheckoutAddress(driver);
    CheckoutDelivery selectShipment = new CheckoutDelivery(driver);
    CheckoutPayment selectPayment = new CheckoutPayment(driver);
    OrderConfirmation confirmOrder = new OrderConfirmation(driver);
    //This is the test case which creates a new user then with same credentials adds a product and does checkout
    @Test
    public void assertCart() {
        CreateNewUserLoginPage createLoginUser = new CreateNewUserLoginPage(driver);
        NewCustomerPage newLogin = new NewCustomerPage(driver);

        //Creating a new login user
        createLoginUser.createUser();
        newLogin.createNewLoginCredentials("newUser2@testbackend.com","123456","123456");
        Assert.assertEquals(loggedSuccess.verifyLogin(),"Welcome! You have signed up successfully.","The login message is not matching");

        //The new user selects the respective category and adds product
        selectCategory.selectCategory();
        selectCategory.selectProduct();
        addProduct.addProductToCart("5");
        Assert.assertEquals(checkCart.verifyTotal(), "$79.95", "The total of the products are not matching");
        checkCart.checkout();

        //After checkout we are saving the address and then placing order
        addressFilling.fillAddress("ash","tallur","56,4th block","5th Main","Seattle","Washington","98101","United States of America","5467879856");
        addressFilling.saveAddress();
        selectShipment.saveShipment();
        selectPayment.choosePayment();
        Assert.assertEquals(confirmOrder.confirmOrderMsg(),"Your order has been processed successfully","The order message is not similar");
     }

     //Test for already logged user
     @Test
    public void loginAndOrder(){

        LoginPage login = new LoginPage(driver);

        login.login("helloash@hello.com","123456");

         selectCategory.selectCategory();
         selectCategory.selectProduct();
         addProduct.addProductToCart("10");
         Assert.assertEquals(checkCart.verifyTotal(), "$159.90", "The total of the products are not matching");
         checkCart.checkout();

         //selecting the other address option and saving the address
         addressFilling.chooseOtherAddress();
         addressFilling.fillAddress("ash","tallur","56,4th block","5th Main","Seattle","Washington","98101","United States of America","5467879856");
         addressFilling.saveAddress();
         selectShipment.saveShipment();
         selectPayment.choosePayment();
         Assert.assertEquals(confirmOrder.confirmOrderMsg(),"Your order has been processed successfully","The order message is not similar");

     }

}


