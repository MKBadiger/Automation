package com.Paytm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W_AddDeliveryAddress extends BasePage{

	public W_AddDeliveryAddress(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
	}
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.address1']")
	private WebElement address1;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.address2']")
	private WebElement address2;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.pin']")
	private WebElement pincode;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@ng-model='cart.addressForm.mobile']")
	private WebElement mobileNo;
	
	@FindBy(xpath="//button[@ng-click='cart.saveAddress()']")
	private WebElement saveAddress;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to Pay Rs')]/..")
	private WebElement proceedToPay;
	
	public WebDriver DeliveryAddressPage() throws InterruptedException{
		Thread.sleep(2000);
		name.clear();
		
		name.sendKeys("Qwerty");
		Thread.sleep(2000);
		address1.clear();
		address1.sendKeys("VijayNagar");
		Thread.sleep(2000);
		address2.clear();
		address2.sendKeys("Bangalore");
		Thread.sleep(2000);
		pincode.clear();
		pincode.sendKeys("560090");
		Thread.sleep(2000);
		city.clear();
		city.sendKeys("Bangalore");
		Thread.sleep(2000);
		state.clear();
		state.sendKeys("Karnataka");
		Thread.sleep(2000);
		mobileNo.clear();
		mobileNo.sendKeys("8553551284");
		Thread.sleep(2000);
		saveAddress.click();
		Thread.sleep(2000);
		
		proceedToPay.click();
		return driverWeb;
		
	}

}
