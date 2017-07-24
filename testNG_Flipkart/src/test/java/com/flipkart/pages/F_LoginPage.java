package com.flipkart.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class F_LoginPage extends F_BasePage{
	String uniqueValue="L_001";
	public F_LoginPage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	//@FindBy(id="com.flipkart.android:id/search_widget_textbox")
	
	@AndroidFindBy(id="com.flipkart.android:id/mobileNo")
	private MobileElement mobileNo;
	
	@AndroidFindBy(id="com.flipkart.android:id/btn_msignup")
	private MobileElement signUp;
	
	@AndroidFindBy(id="com.flipkart.android:id/et_password")
	private MobileElement password;
	
	@AndroidFindBy(name="SIGN IN")
	private  MobileElement signIn;
	
/*	@AndroidFindBy(name="Open Drawer")
	private MobileElement clickHB;
	
	@AndroidFindBy(name="My Account")
	private MobileElement myAccount;*/
	
	/*@AndroidFindBy(id="com.flipkart.android:id/mobileNo")
	private MobileElement mobileNo;*/
	
	
	@AndroidFindBy(name="Flipkart home")
	private MobileElement flipkart;
	
	
	@AndroidFindBy(name="Navigate up")
	private MobileElement back;

	public F_HomePage F_Login() throws InterruptedException {
		Thread.sleep(5000);
		mobileNo.clear();
		mobileNo.sendKeys("8951350157");
		//mobileNo.click();
		signUp.click();
		Thread.sleep(2000);
		password.sendKeys("Qwerty@123");
		Thread.sleep(2000);
		signIn.click();
		while(true)
		{
			try{
				
				F_BasePage.startTime=System.currentTimeMillis();
				flipkart.isDisplayed();
				//endTime=System.currentTimeMillis();
				//System.out.println("Time taken to load page:"+(totalTime=(endTime-startTime)/1000));
				Thread.sleep(5000);
				break;
			}
			catch(Exception e)
			{
		}
		
	}
		return null;
		//return new F_HomePage(driverMob);
	}
}
