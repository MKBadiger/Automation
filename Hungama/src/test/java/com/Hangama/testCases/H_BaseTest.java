package com.Hangama.testCases;

import org.testng.annotations.BeforeClass;

import com.Hangama.pages.H_BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class H_BaseTest {
	

	public AppiumDriver<MobileElement> driverMob;
	
	H_BasePage basePage;
	
	@BeforeClass
	public void setUp(){
		basePage=new H_BasePage(driverMob);
		driverMob=basePage.launchApp();
	}

}
