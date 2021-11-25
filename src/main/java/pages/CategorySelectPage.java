package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySelectPage {
    WebDriver driver;

    @FindBy(linkText = "Bags")
    WebElement selectCategory;

    @FindBy(css= "img[alt='Ruby on Rails Tote']")
    WebElement selectProduct;

    public CategorySelectPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectCategory(){

        selectCategory.click();
    }

    public void selectProduct(){

        selectProduct.click();
    }
}
