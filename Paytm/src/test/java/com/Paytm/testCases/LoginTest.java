package com.Paytm.testCases;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Paytm.pages.LoginPage;
import com.Paytm.pages.MoastMassage;
import com.Paytm.pages.Payment;
import com.Paytm.pages.Recharge;
import com.Paytm.pages.W_AddDeliveryAddress;
import com.Paytm.pages.W_LoginPage;
import com.Paytm.pages.W_SearchProduct;


public class LoginTest extends BaseTest{
	
	//String uniqueValue="s001";
		@Test
		//@Test(dataProvider="readData")
		public void loginTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
			
		
			
			LoginPage lp=new LoginPage(driverMob);
			Recharge rc=lp.loginScreen();
			rc.rechargeScreen();		
			
			
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.paytm.com/");
			
			W_LoginPage wlp=new W_LoginPage(driverWeb);
			W_SearchProduct sp=wlp.webLoginPage();
			W_AddDeliveryAddress ada=sp.SearchProductPage();
			ada.DeliveryAddressPage();
			
			
			/*LoginPage lp=new LoginPage(driverMob);
			Recharge rc=lp.loginScreen();
			Payment p=rc.rechargeScreen();		
			p.paymentScreen();
			
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.paytm.com/");
			
			W_LoginPage wlp=new W_LoginPage(driverWeb);
			W_SearchProduct sp=wlp.webLoginPage();
			W_AddDeliveryAddress ada=sp.SearchProductPage();
			ada.DeliveryAddressPage();*/
			
		}
		
		
		@DataProvider
		public Object[][] readData() throws EncryptedDocumentException, InvalidFormatException, IOException{
			Object[][] obj;
			try{
			FileInputStream fis=new FileInputStream(new File("E:\\Test.xlsx"));
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
