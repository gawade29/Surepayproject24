package Surepay_TestPage_Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Surepay_TestPage_Locator.Surepay_ResponsePage_Locator;

public class Surepay_ResponsePage_Action 
{
	
	public static WebDriver driver;
	public static ExtentTest logger;
	public static Surepay_ResponsePage_Locator SurepayRPL;
	public Surepay_ResponsePage_Action(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		SurepayRPL=new Surepay_ResponsePage_Locator(dr,logger);
	}
	
	
	public static void getTransactionDetails()
	{
		try
		{
		String mechantID=SurepayRPL.getMerchId().getText();
		String serviceID=SurepayRPL.getMerchServiceId().getText();
		String bankTxnNO=SurepayRPL.getBankTransactionNo().getText();
		String orderID=SurepayRPL.getMerchantOrderID().getText();
		logger.log(LogStatus.PASS,"Transaction details are--> merchantID:"+mechantID+", "+ "ServiceID:"+serviceID+ ", " +"BankTransactionNo:"+bankTxnNO+", "+"OrderID:"+orderID);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL,"Some Exception occured at response page");

		}
	}
}
