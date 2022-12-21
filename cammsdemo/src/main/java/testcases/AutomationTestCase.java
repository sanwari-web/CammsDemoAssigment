package testcases;

import java.util.concurrent.TimeUnit;
import library.Browser;
import library.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.LoginPage;
import pages.PageHeader;

public class AutomationTestCase {
	
    WebDriver driver;
    LoginPage lp;
    ProductPage pp;
    PageHeader ph;
    
   int i = 0;
   // Launch of the given browser.
   @BeforeTest
   public void browserlaunch()
   {
                  driver = Browser.StartBrowser("Chrome", "https://www.saucedemo.com/");
                  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                  lp = new LoginPage(driver);
                  pp = new ProductPage(driver);
                  ph = new PageHeader(driver);
    }
  // Login to the Site.
  @Test(priority = 1)
  public void Login()
   {
   lp.loginToSite("performance_glitch_user","secret_sauce");
   }
  @Test(priority = 2)
  public void HomePageVerify()
  {
                 String HomeText = ph.verifyPageHeader();
                 Assert.assertEquals(HomeText, "PRODUCTS");
  }
  
  @Test(priority = 3)
  public void selectProducts()
  {
             String price=pp.verifyProductPrice();
             Assert.assertEquals(price, "$49.99");
             pp.clickAddToCart();
             pp.clickShoppingCart();
   }
  
  @Test(priority = 4)
  public void buyProducts()
  {
             String product1=pp.verifyCartProduct1();
             Assert.assertEquals(product1, "Sauce Labs Fleece Jacket");
             String product2=pp.verifyCartProduct2();
             Assert.assertEquals(product2, "Sauce Labs Backpack");
             pp.clickCheckOut();
             pp.enterFirstName("Test1");
             pp.enterLastName("CammsAutoTest");
             pp.enterPostalCode("12536");
             pp.clickContinue();
             pp.clickFinish();
   }
  
  

//Taking Screen shot on test fail
   @AfterMethod
   public void screenshot(ITestResult result)
   {
              i = i+1;
              String name = "ScreenShot";
              String x = name+String.valueOf(i);
             if(ITestResult.FAILURE == result.getStatus())
               {
                              Screenshot.captureScreenShot(driver, x);
                }
}
@AfterTest
public void closeBrowser()
{
       driver.close();
}

}
