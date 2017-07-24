package com.testNG.Practice;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class flipkartDemo2 {

	public WebDriver driverWeb;
	
	@Test(dataProvider="readData2")
	public void loginTest2(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	
		launchChromeBrowser();
		F_WebLogin(uniqueValue);
	}
	
	
	
	public WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		driverWeb=new ChromeDriver();
		driverWeb.get("http://www.flipkart.com");
		driverWeb.manage().window().maximize();	
		//return;
		return driverWeb;
	}
	
	
	
	
	@DataProvider(name="readData2",parallel=true)
	public Object[][] readData2() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj;
		try{
		FileInputStream fis=new FileInputStream(new File("E:\\Mahesh\\Data1.xlsx"));
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
	}
	
	
	
	

	@FindBy(xpath="//a[text()='Signup']")
	private WebElement loginLink;
	
	@FindBy(xpath="(//div[@class='new-login-form']//input)[1]")
	private WebElement mobileNo;
	
	@FindBy(xpath="(//div[@class='new-login-form']//input)[3]")
	private WebElement password;
	
	@FindBy(xpath="//a[text()='show'][1]")
	private WebElement show;
	
	@FindBy(xpath="(//input[@value='Login'])[2]")
	private WebElement Login;

	private HashMap<String, String> data;
	
	public String F_WebLogin(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		//System.out.println(uniqueValue);
		//String flowSheetName = data.get("Work Flow");
		//data = readData(flowSheetName, uniqueValue);
		
		data = readExcelData("Info", uniqueValue);
		//startTime=System.currentTimeMillis();
		//System.out.println(startTime);
		Thread.sleep(2000);
		loginLink.click();
		Thread.sleep(2000);
		mobileNo.clear();
		//mobileNo.sendKeys("8951350157");
		mobileNo.sendKeys(data.get("Email"));
		System.out.println(data.get("Email"));
		Thread.sleep(2000);
		//password.sendKeys("Qwerty@123");
		password.sendKeys(data.get("Password"));
		System.out.println(data.get("Password"));
		Thread.sleep(5000);
		try{
		if (show.isDisplayed()) {
			  Login.click();
			 // endTime=System.currentTimeMillis();
			  //System.out.println(endTime);
			  //System.out.println("Time taken to load page:"+(totalTime=(endTime-startTime)/1000)+" Seconds");
			}
		}
		catch(Exception e){
			
		}
	
		return uniqueValue;
		
	}
	
	public static HashMap<String,String> readExcelData(String sheetName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Row row=null;
		//String key,value;
		FileInputStream fis=new FileInputStream(new File("E:\\Mahesh\\Data1.xlsx"));
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
}
