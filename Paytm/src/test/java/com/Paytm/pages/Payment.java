package com.Paytm.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Payment extends BasePage{

	public Payment(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(id="card-number")
	private MobileElement cardNo;
	
	@AndroidFindBy(name="MM")
	private MobileElement month;
	
	@AndroidFindBy(name="11")
	private MobileElement selectMonth;
	
	@AndroidFindBy(name="YY")
	private MobileElement year;
	
	@AndroidFindBy(name="2023")
	private MobileElement selectYear;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='2']")
	private MobileElement cvv;

	@AndroidFindBy(id="saveCard")
	private MobileElement uncheck;
	
	@AndroidFindBy(name="Pay now")
	private MobileElement payNow;
	
	public void paymentScreen() throws InterruptedException{
		Thread.sleep(3000);
		cardNo.clear();
		cardNo.sendKeys("1234567891234567");
		Thread.sleep(2000);
		month.click();
		driverMob.scrollToExact("11");
		selectMonth.click();
		Thread.sleep(2000);
		year.clear();
		driverMob.scrollToExact("2023");
		selectYear.click();
		Thread.sleep(2000);
		cvv.sendKeys("123");
		uncheck.click();
		Thread.sleep(2000);
		payNow.click();
		
		
	}
}
