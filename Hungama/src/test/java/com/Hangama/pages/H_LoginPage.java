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

public class H_LoginPage extends H_BasePage{

	public H_LoginPage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(name="Hungama Play")
	private MobileElement hamburger;
	
	@AndroidFindBy(name="Login / Register")
	private MobileElement clickOnLogin;
	
	//Login With Email
	@AndroidFindBy(name = "LOG IN WITH EMAIL / MOBILE")
	private MobileElement loginWithEmail;
	
	@AndroidFindBy(name="com.hungama.movies:id/rad_btn_email")
	private MobileElement E_emailText;
	
	@AndroidFindBy(id = "com.hungama.movies:id/et_email_address")
	private MobileElement E_email;
	
	@AndroidFindBy(id="com.hungama.movies:id/et_password_email")
	private MobileElement E_Pwd;
	
	@AndroidFindBy(name="Show Password")
	private MobileElement E_showPwd;
	
	@AndroidFindBy(name="Login")
	private MobileElement E_login;
	
	
	//Login With Mobile Number
	@AndroidFindBy(name = "MOBILE")
	private MobileElement LoginWithMobileNo;
	
	@AndroidFindBy(id = "com.hungama.movies:id/et_mobileno")
	private MobileElement M_mobileNo;
	
	@AndroidFindBy(id = "com.hungama.movies:id/et_password_mobile")
	private MobileElement M_MobilePwd;
	
	@AndroidFindBy(name="com.hungama.movies:id/show_hide_password_mobile")
	private MobileElement M_showPwd;
	
	@AndroidFindBy(name="com.hungama.movies:id/btn_sign_in")
	private MobileElement M_Login;
	
	//Forget Password
	@AndroidFindBy(name="Forgot Password?")
	private MobileElement M_ForgetPwd;
	
	@AndroidFindBy(id="com.hungama.movies:id/et_mobileno")
	private MobileElement forgetMobNo;
	
	@AndroidFindBy(id="com.hungama.movies:id/btn_submit")
	private MobileElement f_submit;
	
	@AndroidFindBy(id="com.hungama.movies:id/btn_cancel")
	private MobileElement f_cancel;
	
	//Email
	@AndroidFindBy(name="EMAIL")
	private MobileElement f_Email;
	
	@AndroidFindBy(id="com.hungama.movies:id/btn_submit")
	private MobileElement f_emailSubmit;
	
	@AndroidFindBy(id="com.hungama.movies:id/btn_cancel")
	private MobileElement f_emailCancel;
	
	
	
	
	//Login with Google Account
	@AndroidFindBy(name="com.hungama.movies:id/layout_sign_with_googleplus")
	private MobileElement G_Icon;
	
	@AndroidFindBy(name="Enter your email")
	private MobileElement G_Emial;
	
	@AndroidFindBy(name="Next")
	private MobileElement G_Next;

	private HashMap<String, String> data;
	
	public   AppiumDriver<MobileElement> loginScreen(String loginType) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		
		data=readExcelData("Login",loginType);
		
		//System.out.println(data.get("Email/MobileNo")+"and"+data.get("Password"));
		Thread.sleep(2000);
		hamburger.click();
		Thread.sleep(2000);
		clickOnLogin.click();
		Thread.sleep(2000);
		/*if(loginType.equalsIgnoreCase("Facebook"))
		{
			f_Icon.click();
		}
		else if(loginType.equalsIgnoreCase("Google+")){
			G_Icon.click();
		}
			
		else
		{*/
			/*if(E_emailText.getAttribute("text") == "EMAIL")
			{*/
				Thread.sleep(2000);
				loginWithEmail.click();
				Thread.sleep(2000);
				E_email.clear();
				E_email.sendKeys(data.get("Email/MobileNo"));
				//E_email.sendKeys("t@gmail.com");
				driverMob.hideKeyboard();
				Thread.sleep(2000);
				E_Pwd.clear();
				E_Pwd.sendKeys(data.get("Password"));
				driverMob.hideKeyboard();
				//E_Pwd.sendKeys("*******");
				Thread.sleep(2000);
				E_showPwd.click();
				Thread.sleep(2000);
				E_login.click();
				Reporter.log("Login With Registered Email.");
			//}
			/*else
			{
				LoginWithMobileNo.click();
				Thread.sleep(2000);
				M_mobileNo.clear();
				M_mobileNo.sendKeys(data.get(""));
				driverMob.hideKeyboard();
				Thread.sleep(2000);
				M_MobilePwd.clear();
				M_MobilePwd.sendKeys(data.get(""));
				Thread.sleep(2000);
				M_showPwd.click();
				M_Login.click();
			}*/
		//}
		
		return (driverMob);
			
	}
	

}
