package com.Hangama.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

public class H_RegistrationPage extends H_BasePage{

	public H_RegistrationPage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
		// TODO Auto-generated constructor stub
	}

	
	@AndroidFindBy(name="Hungama Play")
	private MobileElement hamburger;
	
	@AndroidFindBy(name="Login / Register")
	private MobileElement clickOnLogin;
	
	@AndroidFindBy(id="tv_signup")
	private MobileElement register;
	
	@AndroidFindBy(id="et_first_name")
	private MobileElement firstName;
	
	@AndroidFindBy(id="et_last_name")
	private MobileElement lastName;
	
	@AndroidFindBy(id="com.hungama.movies:id/et_emailId")
	private MobileElement email;
	
	@AndroidFindBy(id="et_password")
	private MobileElement password;
	
	@AndroidFindBy(id="et_mobileno")
	private MobileElement mobileNo;
	
	@AndroidFindBy(id="btn_submit")
	private MobileElement submit;

	@AndroidFindBy(id="com.hungama.movies:id/btn_cancel")
	private MobileElement cancel;
	
	@AndroidFindBy(id="show_hide_password")
	private MobileElement showPwd;

	private HashMap<String, String> data;

	public AppiumDriver<MobileElement> loginScreen(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		data=readExcelData("Registration",uniqueValue);
		Thread.sleep(3000);
		hamburger.click();
		Thread.sleep(2000);
		clickOnLogin.click();
		Thread.sleep(2000);
		register.click();
		Thread.sleep(2000);
		firstName.clear();
		//firstName.sendKeys("Mahesh");
		firstName.sendKeys(data.get("First Name"));
		Thread.sleep(2000);
		lastName.clear();
		//lastName.sendKeys("B");
		lastName.sendKeys(data.get("Last Name"));
		driverMob.hideKeyboard();
		Thread.sleep(2000);
		email.clear();
		//email.sendKeys("maheshbadiger");
		email.sendKeys(data.get("Email"));
		driverMob.hideKeyboard();
		Thread.sleep(2000);
		password.clear();
		//password.sendKeys("123456");
		password.sendKeys(data.get("Password"));
		driverMob.hideKeyboard();
		Thread.sleep(2000);
		showPwd.click();
		String Expwrd=data.get("Password");
		Thread.sleep(2000);
		mobileNo.clear();
		//mobileNo.sendKeys("8553551284");
		mobileNo.sendKeys(data.get("Mobile Number"));
		driverMob.hideKeyboard();
		try{
			if(submit.isEnabled()){
			
				submit.click();
			}
		}
		catch(Exception e){
			
		}
		
		//cancel.click();
		
		return driverMob;
	}
}
	




