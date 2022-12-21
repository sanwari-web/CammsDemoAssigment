package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeader {

	WebDriver driver;

	By PageHeader = By.xpath("//span[text()='Products']");

	public PageHeader(WebDriver driver)
	{
	              this.driver = driver;
	}
	
	//Constructor to initialize object
	public String verifyPageHeader()
    {
                  return driver.findElement(PageHeader).getText();
     }
	             
}
