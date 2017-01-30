package com.Paytm.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Recharge extends BasePage{

	public Recharge(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}

	@AndroidFindBy(name="Open navigation drawer")
	private MobileElement hamburger;
	
	@AndroidFindBy(name="Recharge or Pay for")
	private MobileElement rechargeFor;
	
	@AndroidFindBy(name="Mobile")
	private MobileElement mobile;
	
	@AndroidFindBy(id="net.one97.paytm:id/edit_no")
	private MobileElement enterNo;
	
	@AndroidFindBy(id="net.one97.paytm:id/text_mob_op")
	private MobileElement operator;
	
	@AndroidFindBy(name="Tata DOCOMO")
	private MobileElement selectOperator;
	
	@AndroidFindBy(name="Karnataka")
	private MobileElement selectState;
	
	@AndroidFindBy(id="net.one97.paytm:id/edit_amount")
	private MobileElement amount;
	
	@AndroidFindBy(name="Proceed to Recharge")
	private MobileElement proceed;
	
	@AndroidFindBy(id="net.one97.paytm:id/btn_pay_now")
	private MobileElement proceedToPay;
	
	
	public void rechargeScreen() throws InterruptedException{
		Thread.sleep(2000);
		hamburger.click();
		Thread.sleep(2000);
		rechargeFor.click();
		Thread.sleep(2000);
		mobile.click();
		Thread.sleep(2000);
		enterNo.clear();
		enterNo.sendKeys("8951350157");
		Thread.sleep(2000);
		operator.click();
		driverMob.scrollToExact("Tata DOCOMO");
		selectOperator.click();
		driverMob.scrollToExact("Karnataka");
		selectState.click();
		//operator.sendKeys("Tata Docomo");
		Thread.sleep(2000);
		amount.clear();
		amount.sendKeys("30");
		Thread.sleep(2000);
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){	
		}
		proceed.click();
		Thread.sleep(2000);
		proceedToPay.click();
		//return new Payment(driverMob);
		
	}
}
