package com.Paytm.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.Paytm.pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	public WebDriver driverWeb;
	public AppiumDriver<MobileElement> driverMob;
	
	BasePage basePage;
	
	@BeforeClass
	public void setUp(){
		basePage=new BasePage(driverMob);
		driverMob=basePage.launchApp();
	}
}
