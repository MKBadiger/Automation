package com.SampleProjects;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SampleScript {
	static AppiumDriver<MobileElement> mdriver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		String host="http://127.0.0.1";
		int portNumber=4723;
		//Local appium node.exe and appium.js file paths
		String Appium_Node_Path="D:/Appium/node.exe";
		String AppiumJS_Path="D:/Appium/node_modules/appium/bin/appium.js";
		
		AppiumDriverLocalService appiumService;
		appiumService=new AppiumServiceBuilder().usingDriverExecutable(new File(Appium_Node_Path))
				.withAppiumJS(new File(AppiumJS_Path)).withIPAddress(host.split("//")[1])
				.usingPort(portNumber).build();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		
		appiumService.stop();
		appiumService.start();

		mdriver = new AndroidDriver<MobileElement>(new URL(host + ":" + portNumber + "/wd/hub"), capabilities);
		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//
		mdriver.findElement(By.xpath("//*[@content-desc='Open Drawer']")).click();
		Thread.sleep(2000);
	}
//	public static AppiumDriver<MobileElement> launchApp() throws MalformedURLException{
//		String host="http://127.0.0.1";
//		int portNumber=4723;
//		//Local appium node.exe and appium.js file paths
//		String Appium_Node_Path="D:/Appium/node.exe";
//		String AppiumJS_Path="D:/Appium/node_modules/appium/bin/appium.js";
//		
//		AppiumDriverLocalService appiumService;
//		appiumService=new AppiumServiceBuilder().usingDriverExecutable(new File(Appium_Node_Path))
//				.withAppiumJS(new File(AppiumJS_Path)).withIPAddress(host.split("//")[1])
//				.usingPort(portNumber).build();
//		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("deviceName", "Android");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("platformVersion", "6.0.1");
//		capabilities.setCapability("appPackage", "com.flipkart.android");
//		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
//		
//		appiumService.stop();
//		appiumService.start();
//
//		mdriver = new AndroidDriver<MobileElement>(new URL(host + ":" + portNumber + "/wd/hub"), capabilities);
//		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		return mdriver;
//		
//	}
}
