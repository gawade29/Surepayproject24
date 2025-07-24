package Surepay_TestPage_Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctions.CommonFunctions;
import Surepay_TestPage_Locator.Sureay_PayPage_Locator;

public class Surepay_PayPage_Action 
{
	public static WebDriver driver;
	public static ExtentTest logger;
	
	public static Sureay_PayPage_Locator SurepayPPL;
	
	public Surepay_PayPage_Action(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		SurepayPPL=new Sureay_PayPage_Locator(dr,logger);
	}
	
	public static void selectChannelCode(String channelMode, String entity)
	
	{
		if(channelMode.equals("IBANK"))
		{
		WebElement PaymentMode=SurepayPPL.getNetBanking();
		CommonFunctions.click(driver, logger, PaymentMode, "Payment Mode-IBANK");
		
		if(entity.equals("ICICI"))
		{
		WebElement paymentEntity=SurepayPPL.getICICIBank(); 
		CommonFunctions.click(driver, logger, paymentEntity, "ICICI-Bank");
		}
		else if(entity.equals("HDFC"))
		{
			WebElement paymentEntity=SurepayPPL.getHDFCBank(); 
			CommonFunctions.click(driver, logger, paymentEntity, "HDFC-Bank");
		}
		else
		{
			logger.log(LogStatus.ERROR, "Invalid bank is selected");
		}
		
		}
		else
		{
			logger.log(LogStatus.ERROR, "Invalid Channelmode is selected");

		}
	}
	
	public static void pay()
	{
		WebElement pay=SurepayPPL.getPayNow();
		CommonFunctions.click(driver, logger, pay, "PayButton");
	}
}
