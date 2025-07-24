package TestNGPack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest 
{
  
  
  @Test
  public void inbox()
  {
	  WebDriver dr=new ChromeDriver();
	  dr.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  
  }
  
  @Test
  public void compose()
  {
	  System.out.println("Executing: compose " + System.currentTimeMillis());
	  System.out.println("compose method");
  }
  
  @Test(dependsOnMethods="signin")
  public void logout()
  {
	  System.out.println("Executing: logout " + System.currentTimeMillis());
	  System.out.println("logout method");
  }
  
  @Test
  public void signin()
  {
	  System.out.println("Executing: signin " + System.currentTimeMillis());
	  System.out.println("signin method");
  }
}
