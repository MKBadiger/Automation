package com.flipkart.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.pages.F_WebLoginPage;

public class F_LoginTest extends F_BaseTest{
	
	//String uniqueValue="v001";
	//@Test(dataProvider="readData1")
	//@Parameters("myBrowser")
	@Test(dataProvider="readData1")
	public void loginTest1(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	
		F_WebLoginPage wlp=new F_WebLoginPage(driverWeb);
		wlp.F_WebLogin(uniqueValue);
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
	}
	
}
