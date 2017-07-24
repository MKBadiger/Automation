package com.flipkart.pages;

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

public class F_BasePage {
	
public WebDriver driverWeb;
	
	
	static long startTime;
	static long endTime;
	static long totalTime;
	
	 //StopWatch pageLoad = new StopWatch();
	
	public F_BasePage(WebDriver driverWeb)
	{
		this.driverWeb=driverWeb;
	}
	
	public WebDriver launchFirefoxBrowser() {
		driverWeb=new FirefoxDriver();
		driverWeb.get("http://www.flipkart.com");
		driverWeb.manage().window().maximize();	
		//return;
		return driverWeb;
	}
	
	public WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		driverWeb=new ChromeDriver();
		driverWeb.get("http://www.flipkart.com");
		driverWeb.manage().window().maximize();	
		//return;
		return driverWeb;
	}
	

	
	public static HashMap<String,String> readExcelData(String sheetName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Row row=null;
		System.out.println("value"+uniqueValue);
			FileInputStream fis=new FileInputStream(new File("E:\\BMS.xlsx"));
			HashMap<String, String> dataMap=new HashMap<String, String>();
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet=wb.getSheet(sheetName);
			Iterator<Row> it=sheet.rowIterator();
			Row record=it.next();
			while(it.hasNext()){
					row=it.next();
					String value=row.getCell(0).toString();
					for(int i=1;i<row.getLastCellNum();i++){
						if(value.equalsIgnoreCase(uniqueValue)){
							String cellValue=record.getCell(i).toString();
							String cellHeader=row.getCell(i).toString();
							dataMap.put(cellValue,cellHeader);
							System.out.println(cellValue+""+cellHeader);
						}
					}
					//return dataMap;
			}
			return dataMap;
	}

}
