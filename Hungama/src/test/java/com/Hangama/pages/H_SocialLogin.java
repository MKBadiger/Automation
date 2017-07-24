package com.Hangama.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class H_SocialLogin extends H_BasePage{

	public H_SocialLogin(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(name="Hungama Play")
	private MobileElement hamburger;
	
	@AndroidFindBy(name="Login / Register")
	private MobileElement clickOnLogin;

		//Login With FaceBook
		@AndroidFindBy(id="com.hungama.movies:id/layout_sign_with_facebook")
		private MobileElement f_Icon;
		
		@AndroidFindBy(name="Email address or phone number")
		private MobileElement f_email;
		
		@AndroidFindBy(id="u_0_2")
		private MobileElement f_password;
		
		@AndroidFindBy(name="Log In ")
		private MobileElement f_submit;
		
		//Login through google+
		@AndroidFindBy(id="com.hungama.movies:id/layout_sign_with_googleplus")
		private MobileElement googleplus;

		@AndroidFindBy(name="Enter your email")
		private MobileElement g_email;
		
		@AndroidFindBy(name="Next")
		private MobileElement g_next;
		
		@AndroidFindBy(id="//android.widget.EditText[@index='2']")
		private MobileElement g_password;
		
		@AndroidFindBy(name="Sign in")
		private MobileElement g_signIn;
		
		private HashMap<String, String> data;
		
		public void socialLoginScreen(String loginType) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
			
			Thread.sleep(2000);
			hamburger.click();
			Thread.sleep(2000);
			clickOnLogin.click();
			
			data=readExcelData("Login",loginType);
			
		if (loginType == "Facebook") 
		{
			Reporter.log("Login through Facebook");
			Thread.sleep(2000);
			f_Icon.click();
			Thread.sleep(2000);
			f_email.clear();
			f_email.sendKeys(data.get(""));
			Thread.sleep(2000);
			f_password.clear();
			f_password.sendKeys(data.get(""));
			Thread.sleep(2000);
			f_submit.click();
		}
			else if(loginType=="Google+"){
				Reporter.log("Login through google+");
				Thread.sleep(2000);
				googleplus.click();
				Thread.sleep(2000);
				g_email.sendKeys(data.get(""));
				Thread.sleep(2000);
				g_next.click();
				Thread.sleep(2000);
				g_password.sendKeys(data.get(""));
				Thread.sleep(2000);
				g_signIn.click();
			}
		}
}

