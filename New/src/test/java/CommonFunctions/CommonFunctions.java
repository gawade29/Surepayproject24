package CommonFunctions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jdk.jfr.internal.Logger;

public class CommonFunctions 
{
	
	public static void selectElement(WebDriver dr, ExtentTest logger, WebElement webEle, String selectValue, String fieldname)
	{
		try
		{
			WebDriverWait wt=new WebDriverWait(dr, Duration.ofSeconds(10));
		
		WebElement elementchecked=wt.until(ExpectedConditions.elementToBeClickable(webEle));
		Select sel=new Select(webEle);
		sel.selectByValue(selectValue);
		logger.log(LogStatus.PASS, fieldname+ "is Selected");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public static void enterText(WebDriver dr, ExtentTest logger, WebElement webEle, String Value,String fieldname)
	{
		try
		{
		WebDriverWait wt=new WebDriverWait(dr, Duration.ofSeconds(10));
		WebElement elementPresent=wt.until(ExpectedConditions.visibilityOf(webEle));
		elementPresent.sendKeys(Value);
		logger.log(LogStatus.PASS, fieldname+ "is entered");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Occured some Error"+fieldname+ "is not selected");
		}
		
	}
	
	public static void click(WebDriver dr, ExtentTest logger, WebElement webEle, String fieldname)
	{
		try {
			WebDriverWait wt=new WebDriverWait(dr,Duration.ofSeconds(10));
			WebElement elementClicable=wt.until(ExpectedConditions.elementToBeClickable(webEle));
			elementClicable.click();
			logger.log(LogStatus.PASS, fieldname+"is clickable");
		} 
		
		catch (Exception e) 
		{
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	


	
	
}
