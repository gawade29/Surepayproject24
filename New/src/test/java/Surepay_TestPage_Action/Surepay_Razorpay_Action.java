package Surepay_TestPage_Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import CommonFunctions.CommonFunctions;
import Surepay_TestPage_Locator.Surepay_RazorpayPage_Locator;

public class Surepay_Razorpay_Action 
{

	public static WebDriver dr=null;
	public static ExtentTest logger=null;
	public static Surepay_RazorpayPage_Locator Surepay_RPL;
	
	public Surepay_Razorpay_Action(WebDriver dr, ExtentTest logger)
	{
		this.dr=dr;
		this.logger=logger;
		Surepay_RPL=new Surepay_RazorpayPage_Locator(dr, logger);
	}
	
	public static void RazorpayStatusPage(String StatusMethod) throws InterruptedException
	{
		if (StatusMethod.equalsIgnoreCase("Success"))
		{
			WebElement successTxn=Surepay_RPL.getSuccess();
			CommonFunctions.click(dr, logger, successTxn, "SuccessBtn");
			Thread.sleep(5000);
		}
		
		if (StatusMethod.equalsIgnoreCase("Failed"))
		{
			WebElement failureTxn=Surepay_RPL.getFailure();
			CommonFunctions.click(dr, logger, failureTxn, "FailureBtn");
			Thread.sleep(5000);
		}	
	}
}
