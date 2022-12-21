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
    }
  // Login to the Site.
  @Test(priority = 1)
  public void Login()
   {
   lp.loginToSite("performance_glitch_user","secret_sauce");
   }
//  @Test(priority = 2)
//  public void HomePageVerify()
//  {
//                 String HomeText = ph.pageverify();
//                 Assert.assertEquals(HomeText, "Product");
//   }

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
