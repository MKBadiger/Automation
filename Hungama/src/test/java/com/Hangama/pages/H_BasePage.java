package com.Hangama.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.Hangama.testCases.H_BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;





public class H_BasePage extends H_BaseTest{

	static AppiumDriver<MobileElement> driverMob;
	
	
	public H_BasePage(AppiumDriver<MobileElement> driverMob){
		H_BasePage.driverMob=driverMob;
	}
	
	public AppiumDriver<MobileElement> launchApp(){
		System.out.println("app");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("appPackage", "com.hungama.movies");
		capabilities.setCapability("appActivity", "com.hungama.movies.presentation.SplashScreenActivity");
		Reporter.log("Launched Sucess!!",true);
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
			FileInputStream fis=new FileInputStream(new File("E:\\Practice\\HungamaDetails.xlsx"));
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
