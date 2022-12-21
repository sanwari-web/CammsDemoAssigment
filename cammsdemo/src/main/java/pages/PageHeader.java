package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeader {

	WebDriver driver;

	By PageHeader = By.xpath("//span[text()='Products']");

	//Constructor to initialize object
	public void PageHeader(WebDriver dr)
	              {
	                             this.driver=dr;
	               }
	              public String pageverify()
	              {
	                            return driver.findElement(PageHeader).getText();
	               }
	             
}
