package com.Paytm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	static AppiumDriver<MobileElement> driverMob;
	static WebDriver driverWeb;
	
	public BasePage(WebDriver driverWeb){
		BasePage.driverWeb=driverWeb;
	}
	
	public BasePage(AppiumDriver<MobileElement> driverMob){
		BasePage.driverMob=driverMob;
	}
	
	public AppiumDriver<MobileElement> launchApp(){
		//System.out.println("app");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("appPackage", "net.one97.paytm");
		capabilities.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
		
		try{
			driverMob=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			//driverMob=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:9515/wd/hub"),capabilities);
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
		return driverMob;
		
	}
	public static HashMap<String,String> readExcelData(String sheetName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		//System.out.println("HAspMap"+uniqueValue);
		Row row=null;
System.out.println("value"+uniqueValue);
			FileInputStream fis=new FileInputStream(new File("E:\\Test.xlsx"));
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
						}
					}
					//return dataMap;
			}
			return dataMap;
			
		
		
	}

	
	public WebDriver launchBrowser() {
		driverWeb=new FirefoxDriver();
		driverWeb.get("http://www.shopclues.com");
		driverWeb.manage().window().maximize();
		return driverWeb;
	}
	
	
/*	public static AppiumDriver<MobileElement> image(AppiumDriver<MobileElement> driver){
		File targetFile=null;
		try{
			
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//getScreenShotAs(OutputType.FILE);
			String fileName=UUID.randomUUID().toString();
			targetFile=new File("./screenShots/"+fileName+".png");
			FileUtils.copyFile(srcFile, targetFile);
			System.out.println(targetFile.toString());
		}
		catch(Exception e){
			
		}
		return driver;
		}*/

}
