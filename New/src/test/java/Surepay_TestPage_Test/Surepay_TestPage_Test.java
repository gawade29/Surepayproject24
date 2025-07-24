package Surepay_TestPage_Test;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import CommonFunctions.CommonFunctions;
import Surepay_TestPage_Action.Surepay_PayPage_Action;
import Surepay_TestPage_Action.Surepay_Razorpay_Action;
import Surepay_TestPage_Action.Surepay_ResponsePage_Action;
import Surepay_TestPage_Action.Surepay_TestPage_Action;

public class Surepay_TestPage_Test extends BaseClass

{

	@Test(dataProvider ="FormData", dataProviderClass = BaseClass.class)
	public void TC_01(String merchantID, String serviceID, String customerID, String TxnAmt, String channelmode, String entity, String status) throws IOException, InterruptedException, SQLException
	{
		Surepay_TestPage_Action SurepayTPA=new Surepay_TestPage_Action(dr,logger);
		Surepay_PayPage_Action SurepayPPA=new Surepay_PayPage_Action(dr,logger);
		Surepay_Razorpay_Action SurepayRPA=new Surepay_Razorpay_Action(dr,logger);
		Surepay_ResponsePage_Action SurepayResPL=new Surepay_ResponsePage_Action(dr, logger);
		
		SurepayTPA.fillDetails(merchantID, serviceID, customerID, TxnAmt);
		SurepayTPA.clickChecksumBtn();
		SurepayPPA.selectChannelCode(channelmode, entity);
		SurepayPPA.pay();
		SurepayRPA.RazorpayStatusPage(status);
		Thread.sleep(9000);
		SurepayResPL.getTransactionDetails();
		Thread.sleep(9000);
		//DBConnection(customerID);
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshot(dr, "TC_01")));
	}
}
