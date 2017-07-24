package com.flipkart_Mobile;

import java.awt.RenderingHints.Key;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Home_Page {
	static AppiumDriver<MobileElement> mdriver;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("*****Launching the app*****");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		// capabilities.setCapability("app", apkPath);
		try {
			mdriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			// PageFactory.initElements(new AppiumFieldDecorator(mdriver),
			// this);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		search_result();
	}

	public static void search_result() throws InterruptedException {
		//mdriver.findElement(By.name(" Search for Products, Brands and More")).click();
		
		Thread.sleep(3000);
		mdriver.findElement(By.name("Open Drawer")).click();
		Thread.sleep(3000);
		mdriver.findElement(By.name("Lifestyle")).click();
		Thread.sleep(3000);
		mdriver.findElement(By.name("Kids & Baby")).click();
		Thread.sleep(3000);
		mdriver.findElement(By.name("Toys & Games")).click();
		Thread.sleep(3000);
		mdriver.findElement(By.name("Search")).click();
		Thread.sleep(5000);
		MobileElement ele = mdriver.findElement(By.id("search_autoCompleteTextView"));
		ele.sendKeys("mobile");
		Thread.sleep(3000);
		((AndroidDriver<MobileElement>) mdriver).pressKeyCode(AndroidKeyCode.ENTER);     

	}
}