package Surepay_TestPage_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Surepay_TestPage_Locator 
{
	public static WebDriver driver;
	public static ExtentTest logger;
	
	public Surepay_TestPage_Locator(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="merchantId") 
	public WebElement merchantID;
	
	@FindBy(id="serviceId") 
	public WebElement serviceID;
	
	@FindBy(id="customerId") 
	public WebElement customerID;
	
	@FindBy(id="transactionAmount") 
	public WebElement transactionAmount;
	
	@FindBy(id="generateChecksum") public WebElement generateChecksum;
	@FindBy(id="submitbtn") public WebElement submitChecksum;


	public WebElement getMerchantID() 
	{
		return merchantID;
	}

	public WebElement getServiceID() 
	{
		return serviceID;
	}

	public WebElement getCustomerID() 
	{
		return customerID;
	}

	public WebElement getTransactionAmount() 
	{
		return transactionAmount;
	}
	public WebElement getGenerateChecksum() 
	{
		return generateChecksum;
	}
	public WebElement getSubmitChecksum() 
	{
		return submitChecksum;
	}
	
}
