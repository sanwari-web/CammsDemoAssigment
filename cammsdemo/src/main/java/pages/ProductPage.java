package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	WebDriver driver;
	By ProductPrice = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following::div[text()='49.99']");
	By AddToCart = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following::button[text()='Add to cart']");
	By ShoppingCart = By.xpath("//a[@class='shopping_cart_link']");
	By CartProducts = By.xpath("//div[@class='cart_item']//child::div[text()='Sauce Labs Backpack']");
	By CheckOutButton = By.xpath("//button[@id='checkout']");
	By FirstName = By.xpath("//input[@id='first-name']");
	By LastName = By.xpath("//input[@id ='last-name']");
	By PostalCode = By.xpath("//input[@id='postal-code']");
	By ContinueButton = By.xpath("//input[@id='continue']");
	By FinishButton = By.xpath("//button[@id='finish']");
	//Constructor to initialize object
	public ProductPage(WebDriver driver)
	{
	              this.driver = driver;
	}
	public void selectProducts()
	{
	                this.verifyProductPrice();
	                this.clickAddToCart();
	                this.clickShoppingCart();
	}
	public String verifyProductPrice()
    {
                  return driver.findElement(ProductPrice).getText();
     }
	public String verifyCartProducts()
    {
                  return driver.findElement(CartProducts).getText();
     }
    public void clickAddToCart()
    {
               driver.findElement(AddToCart).click();
    }
	public void clickShoppingCart()
	{
	                driver.findElement(ShoppingCart).click();
	}
	public void clickCheckOut()
    {
               driver.findElement(CheckOutButton).click();
    }
	public void enterFirstName(String Firstname)
	{
	                driver.findElement(FirstName).sendKeys(Firstname);
	}
	public void enterLastName(String Lastname)
	{
	                driver.findElement(LastName).sendKeys(Lastname);
	}
	public void enterPostalCode(String Postalcode)
	{
	                driver.findElement(PostalCode).sendKeys(Postalcode);
	}
	public void clickContinue()
    {
               driver.findElement(ContinueButton).click();
    }
	public void clickFinish()
    {
               driver.findElement(FinishButton).click();
    }
}
