package Surepay_TestPage_Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonFunctions.CommonFunctions;
import Surepay_TestPage_Locator.Surepay_TestPage_Locator;

public class Surepay_TestPage_Action 
{
	public static WebDriver driver;
	public static ExtentTest logger;
	public static Surepay_TestPage_Locator SurepayTPL;
	
	public Surepay_TestPage_Action(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		SurepayTPL=new Surepay_TestPage_Locator(dr,logger);
		
	}
	
	public static void selectMerchantID(String merchant)
	{
		WebElement selectmerchant=SurepayTPL.getMerchantID();
		CommonFunctions.selectElement(driver, logger, selectmerchant, merchant, "MerchantID");
	}
	
	public static void selectServiceID(String service)
	{
		WebElement selectservice=SurepayTPL.getServiceID();
		CommonFunctions.selectElement(driver, logger, selectservice, service, "SericeID");
	}
	
	public static void enterCustmerId(String customerid)
	{
		WebElement customerID=SurepayTPL.getCustomerID();
		CommonFunctions.enterText(driver, logger, customerID, customerid, "CustomerID");
	}
	
	public static void entertxnAmt(String txnAmt)
	{
		WebElement transactionAmt=SurepayTPL.getTransactionAmount();
		CommonFunctions.enterText(driver, logger, transactionAmt, txnAmt, "TransactionAMT");
	}
	
	public static void clickChecksumBtn()
	{
		WebElement generate=SurepayTPL.getGenerateChecksum();
		CommonFunctions.click(driver, logger, generate, "GenerateChecksum");
		
		WebElement submit=SurepayTPL.getSubmitChecksum();
		CommonFunctions.click(driver, logger, submit, "ChecksumSubmit");
	}
	public static void fillDetails(String merchant,String service,String customerid,String txnAmt)
	{
		selectMerchantID(merchant);
		selectServiceID(service);
		enterCustmerId(customerid);
		entertxnAmt(txnAmt);
	}
}
