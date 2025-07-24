package Surepay_TestPage_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Surepay_ResponsePage_Locator 
{
	public static WebDriver driver;
	public static ExtentTest logger;
	public Surepay_ResponsePage_Locator(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[b[text()='Merchant Id :']]//following-sibling::span") public static WebElement merchId;
	@FindBy(xpath="//span[b[text()='Bank Transaction No :']]//following-sibling::span") public static WebElement bankTransactionNo;
	@FindBy(xpath="//span[b[text()='Status :']]//following-sibling::span") public static WebElement transactionStatus;
	@FindBy(xpath="//span[b[text()='Order Id :']]//following-sibling::span") public static WebElement merchantOrderID;
	@FindBy(xpath="//span[b[text()='Merchant Service Id :']]/following-sibling::span") public static WebElement merchServiceId;
	
	public static WebElement getMerchServiceId() {
		return merchServiceId;
	}

	public static WebElement getMerchId() {
		return merchId;
	}

	public static WebElement getBankTransactionNo() {
		return bankTransactionNo;
	}

	public static WebElement getTransactionStatus() {
		return transactionStatus;
	}

	public static WebElement getMerchantOrderID() {
		return merchantOrderID;
	}

	
}
