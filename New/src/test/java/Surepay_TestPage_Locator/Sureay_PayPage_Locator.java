package Surepay_TestPage_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Sureay_PayPage_Locator 
{

	public static WebDriver driver;
	public static ExtentTest logger;
	
	public Sureay_PayPage_Locator(WebDriver dr, ExtentTest logger)
	{
		this.driver=dr;
		this.logger=logger;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//label[@id='channelCodelabel' and normalize-space(text())='Net Banking']") private WebElement NetBanking;
	@FindBy(xpath="//div[@id='ICIC']") private WebElement ICICIBank;
	@FindBy(xpath="//div[@id='INDB']") private WebElement IndusindBank;
	@FindBy(xpath="//div[@id='HDFC']") private WebElement HDFCBank;
	@FindBy(xpath="//div[@id='STXB']") private WebElement SutexBank;

	@FindBy(xpath="//label[@id='channelCodelabel' and normalize-space(text())='Wallet']") private WebElement Wallet;
	@FindBy(xpath="mobikwik") private WebElement WalletSelect;
	
	@FindBy(xpath="//span[text()='Pay Now']") public WebElement PayNow;
	
	public WebElement getNetBanking() 
	{
		return NetBanking;
	}
	
	public WebElement getICICIBank() 
	{
		return ICICIBank;
	}
	public WebElement getIndusindBank() 
	{
		return IndusindBank;
	}
	public WebElement getHDFCBank() 
	{
		return HDFCBank;
	}
	public WebElement getSutexBank() 
	{
		return SutexBank;
	}
	
	
	public WebElement getWallet() 
	{
		return Wallet;
	}
	
	public WebElement getWalletSelect() 
	{
		return WalletSelect;
	}
	
	public WebElement getPayNow() 
	{
		return PayNow;
	}
	
	
}
