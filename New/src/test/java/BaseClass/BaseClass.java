package BaseClass;

import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	public static WebDriver dr=null;
	public static ExtentReports extentReport=null;
	public static ExtentTest logger=null;
	public static String path="C:\\Users\\Swapnali.Gavade\\SurepayResult.html";
	public static String Screenshot_path="C:\\Users\\Swapnali.Gavade\\";
	
	 
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		extentReport=new ExtentReports(path,true);// it concatenates the file path(test Report) and file name and creates final file name. m
	}
	 
	@BeforeMethod
	public void beforeMethod(Method testMethodName) throws IOException
	{
	logger=extentReport.startTest(testMethodName.getName());//
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swapnali.Gavade\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

	dr=new ChromeDriver();
	dr.manage().window().maximize();
	dr.get("https://pilot.surepay.ndml.in/SurePayPayment/testMerchantPage");
	}
	 
	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException
	{
		extentReport.endTest(logger);
		extentReport.flush();
		
	}
	
	public static String screenshot(WebDriver dr, String ScreenshotName) throws IOException
	{
		String timestamp = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
		TakesScreenshot takeSs=(TakesScreenshot)dr; //driver takes control to capture SS of website
		File opFile=takeSs.getScreenshotAs(OutputType.FILE); // it defines the format of output type
		File dest= new File(".//ScreenShots//"+ScreenshotName+timestamp+".png"); // it defines on which destination file will gets saved along with SS Name
		FileUtils.copyFile(opFile, dest);// it copies the created output file to destination path
		return dest.getAbsolutePath();
	}
	 
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow readRow;
	public XSSFCell readCell;
	
	public void setExcelFile(String fileName, String SheetName) throws IOException	// Set excel file path
	{
		FileInputStream excelFile=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(excelFile);
		sheet=workbook.getSheet(SheetName);
	}

	public Object[][] readMultipleTestfile(String fileName, String SheetName) throws IOException		// To read multiple records from excel
	{
		setExcelFile(fileName,SheetName);
		int totalRow=sheet.getPhysicalNumberOfRows();		// Total no of rows
		//int totalRow=sheet.getLastRowNum()+1;		// Total no of rows

		int totalCols=sheet.getRow(0).getPhysicalNumberOfCells();//Total no of columns in one row
		//int totalCols=sheet.getRow(0).getLastCellNum();//Total no of columns in one row

		System.out.println("Total row"+ totalRow);
		System.out.println("Total cols"+totalCols);
		Object[][] data=new Object[totalRow][totalCols];	// created 2 dimensional array of Data
		
		for(int i=0; i<totalRow; i++)
		{
			XSSFRow readRow=sheet.getRow(i);
			
			for(int j=0;j<totalCols;j++)
			{
				XSSFCell readCell=readRow.getCell(j);
				DataFormatter format=new DataFormatter();
				String cellVal=format.formatCellValue(readCell);
				data[i][j]=cellVal;
			}
		}
		return data;
				
	}
	
	@DataProvider(name="FormData")
	public Object readMultipleTestData() throws IOException
	{
		Object[][] data=readMultipleTestfile("C:\\Users\\Swapnali.Gavade\\Documents\\TestData.xlsx","TC");
		return data;
	}
	
	
	private static final String URL = "jdbc:postgresql://10.250.10.241:5432/SUREPAYDB-PROD";
    private static final String USER = "SureAdmin";
    private  static final String PASSWORD = "ndml@1234";
	
	public static void DBConnection(String bankRefCode) throws SQLException
	{
	   String query="Select spt_txn_id,spt_transaction_status,spt_surepay_mid,spt_bank_ref_code from txn_sp_payment_transaction where spt_bank_ref_code=?";
	   	
	       Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             stmt.setString(1,bankRefCode);
	             ResultSet rs = stmt.executeQuery();
	             
	           while(rs.next())
	           {
	        	   String txn_id=rs.getString("spt_txn_id");
	        	   String txn_status=rs.getString("spt_transaction_status");
	        	   String surepay_mid=rs.getString("spt_surepay_mid");
	        	   String bank_ref_code=rs.getString("spt_bank_ref_code");

	        	   System.out.println(txn_id);
	        	   System.out.println(txn_status);
	        	   System.out.println(surepay_mid);
	        	   System.out.println(bank_ref_code);
	           }
	}
	
	public static void TransactionMaster(String table_name,String txn_id, String transaction_status, String surepay_mid, String bankRefCode, String whereCols, String whereValue) throws SQLException
	{
	   String query="Select "+txn_id+","+transaction_status+","+surepay_mid+","+bankRefCode+" from "+table_name+" where "+whereCols+" =?";
	   	
	   //String query="Select spt_txn_id,spt_transaction_status,spt_surepay_mid,spt_bank_ref_code from txn_sp_payment_transaction where spt_bank_ref_code=?";

	       Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query);
	             stmt.setString(1,whereValue);
	             ResultSet rs = stmt.executeQuery();
	             
	           while(rs.next())
	           {
	        	   String txnId=rs.getString("spt_txn_id");
	        	   String txn_status=rs.getString("spt_transaction_status");
	        	   String surepayMid=rs.getString("spt_surepay_mid");
	        	   String bankrefcode=rs.getString("spt_bank_ref_code");

	        	   System.out.println(txnId);
	        	   System.out.println(txn_status);
	        	   System.out.println(surepayMid);
	        	   System.out.println(bankrefcode);
	           }
	}
	
	public static List<String> fetchTableAttributes(String col1, String col2,String col3, String col4, String col5)
	{
		List<String> columns=Arrays.asList(col1,col2,col3,col4,col5);
		return columns;
	}
	
	public static void fetchQueryData(String tableName, List<String> colNames, String whereColName, String whereValue) throws SQLException
	{
		String colsJoined=String.join(",", colNames);
		String query="Select "+colsJoined+" from "+tableName+" Where "+whereColName+"= ?";
		try
		{
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement state=con.prepareStatement(query);
		state.setString(1, whereValue);
		ResultSet rs=state.executeQuery();
		while(rs.next())
		{
			for(String col:colNames)
			{
				String attributeName=rs.getString(col);
				System.out.println(col+" -> "+attributeName);
				logger.log(LogStatus.PASS, col+" -> "+attributeName);
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
}
