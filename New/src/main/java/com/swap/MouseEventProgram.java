package com.swap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseEventProgram {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swapnali.Gavade\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		WebDriver dr=new ChromeDriver();
		dr.get("https://pilot.surepay.ndml.in/SurePayPayment/testMerchantPage");
		dr.manage().window().maximize();
		WebElement label=dr.findElement(By.xpath("//label[text()=' Message Type ']"));

		Thread.sleep(8000);
		Actions act=new Actions(dr);
		act.doubleClick(label).build().perform();
		
		act.sendKeys(Keys.CONTROL).build().perform();
		act.sendKeys("a").build().perform();
		act.sendKeys(Keys.CONTROL).build().perform();
		act.sendKeys("c").build().perform();
		
		WebElement text=dr.findElement(By.id("//input[@id='customerId']"));
		act.sendKeys(text,Keys.CONTROL).build().perform();
		act.sendKeys(text,"v").perform();


		//System.out.println(copied+" and "+paste);
		
		
	}

}
