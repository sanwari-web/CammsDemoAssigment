package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	WebDriver driver;
	//xpath of the objects
	By ProductPrice = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following::div[text()='49.99']");
	By AddToCart1 = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following::button[text()='Add to cart']");
	By AddToCart2 = By.xpath("//div[text()='Sauce Labs Backpack']/../../following::button[text()='Add to cart']");
	By ShoppingCart = By.xpath("//a[@class='shopping_cart_link']");
	By CartProducts1 = By.xpath("//div[@class='cart_item']//child::div[text()='Sauce Labs Fleece Jacket']");
	By CartProducts2 = By.xpath("//div[@class='cart_item']//child::div[text()='Sauce Labs Backpack']");
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
	
	public void buyProducts(String Firstname, String Lastname, String Postalcode)
	{
	                this.verifyCartProduct1();
	                this.verifyCartProduct2();
	                this.clickCheckOut();
	                this.enterFirstName(Firstname);
	                this.enterLastName(Lastname);
	                this.enterPostalCode(Postalcode);
	                this.clickContinue();
	                this.clickFinish();
	                
	}
	public String verifyProductPrice()
    {
                  return driver.findElement(ProductPrice).getText();
     }
	public String verifyCartProduct1()
    {
                  return driver.findElement(CartProducts1).getText();
     }
	public String verifyCartProduct2()
    {
                  return driver.findElement(CartProducts2).getText();
     }
    public void clickAddToCart()
    {
               driver.findElement(AddToCart1).click();
               driver.findElement(AddToCart2).click();
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
