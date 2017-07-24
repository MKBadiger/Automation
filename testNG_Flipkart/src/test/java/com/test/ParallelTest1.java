package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest1 {
	public WebDriver driverWeb;
	private HashMap<String, String> data;
	@Parameters("myBrowser")
	@BeforeClass
	//@Test(dataProvider="readData1")
	public void setUp(String myBrowser) throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		System.out.println("value"+myBrowser);
		//System.out.println("Browser Name"+data.get("Browser_Name"));
		//data = readExcelData("Info", myBrowser);
		//browserName=data.get("Browser_Name");
		//if(data.get("Browser_Name").equalsIgnoreCase("firefox")){
		if(myBrowser.equalsIgnoreCase("firefox")){
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.flipkart.com");
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driverWeb=new ChromeDriver();
			driverWeb.get("http://www.flipkart.com");
		}
	}
	
	@Test
	public void launch(){
		//driverWeb.get("http://www.flipkart.com");
	}
	
	/*public static HashMap<String,String> readExcelData(String sheetName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Row row=null;
		//String key,value;
		FileInputStream fis=new FileInputStream(new File("D:\\Browsers.xlsx"));
		HashMap<String,String> dataMap = new HashMap<String, String>();
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Iterator<Row> it=sheet.rowIterator();
		Row record=it.next();
		while(it.hasNext()){
			
			row=it.next();
			String value1=row.getCell(0).toString();
			for(int i=1;i<row.getLastCellNum();i++){
				if(value1.equalsIgnoreCase(uniqueValue))
				{
					String cellValue = record.getCell(i).toString();
					String cellHeader=row.getCell(i).toString();
					dataMap.put(cellValue, cellHeader);
				}
			}
		}
		return dataMap;
	}
	
	@DataProvider
	public Object[][] readData1() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj;
		try{
		FileInputStream fis=new FileInputStream(new File("D:\\Browsers.xlsx"));
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Info");
		int noOfRows=sheet.getLastRowNum();
		Iterator<Row> it=sheet.rowIterator();
		Row record=it.next();
		obj = new Object[noOfRows][1];
		int i=0;
		while(it.hasNext()){
			obj[i][0]=it.next().getCell(0).toString();
			i++;
		}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return obj;
	}*/
	
	
	
	
	/*@BeforeClass
	public void setUp(String myBrowser) throws IOException, InterruptedException{
		System.out.println("value"+myBrowser);
		if(myBrowser.equalsIgnoreCase("firefox")){
		bp=new F_BasePage(driverWeb);
		driverWeb=bp.launchFirefoxBrowser(mybrowser);
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.flipkart.com");
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			bp=new F_BasePage(driverWeb);
			driverWeb=bp.launchChromeBrowser();
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driverWeb=new ChromeDriver();
			driverWeb.get("http://www.flipkart.com");
		}
	}
	
	@Test
	public void launch(){
		driverWeb.get("http://www.flipkart.com");
	}*/

}
