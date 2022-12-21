package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
WebDriver driver;
By UserID = By.xpath("//input[@id ='user-name']");
By password = By.xpath("//input[@id ='password']");
By Login = By.xpath("//input[@id ='login-button']");
//Constructor to initialize object
public LoginPage(WebDriver driver)
{
              this.driver = driver;
}
public void loginToSite(String Username, String Password)
{
                this.enterUsername(Username);
                this.enterPasssword(Password);
                this.clickLogIn();
}
public void enterUsername(String Username)
{
                driver.findElement(UserID).sendKeys(Username);
}
public void enterPasssword(String Password)
{
                driver.findElement(password).sendKeys(Password);
}
public void clickLogIn()
{
                driver.findElement(Login).click();
}
}