package Surepay_TestPage_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Surepay_RazorpayPage_Locator 
{
	public static WebDriver dr=null;
	public static ExtentTest logger=null;
	
	public Surepay_RazorpayPage_Locator(WebDriver dr, ExtentTest logger)
	{
		this.dr=dr;
		this.logger=logger;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//button[text()='Success']") private WebElement Success;
	@FindBy(xpath="//button[text()='Failure']") private WebElement Failure;

	public WebElement getSuccess() 
	{
		return Success;
	}

	public WebElement getFailure() 
	{
		return Failure;
	}
	
}
