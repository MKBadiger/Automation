package com.SampleProjects;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumLaunch {

	static AppiumDriver<MobileElement> driverMob;

	public static void main(String args[]) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");

		String host = "http://127.0.0.1";
		int port = 4723;
		String Appium_Node_Path = "D:/Appium/node.exe";
		String Appium_JS_Path = "D:/Appium/node_modules/appium/bin/appium.js";

		AppiumDriverLocalService appiumService;
		appiumService = new AppiumServiceBuilder().usingDriverExecutable(new File(Appium_Node_Path))
				.withAppiumJS(new File(Appium_JS_Path)).withIPAddress(host.split("//")[1]).usingPort(port).build();

		appiumService.stop();
		appiumService.start();

		driverMob = new AndroidDriver<MobileElement>(new URL(host + ":" + port + "/wd/hub"), capabilities);
		driverMob.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	//// WebDriver driver;
	// AppiumDriverLocalService appiumService;
	//// String "http://127.0.0.1:4723/wd/hub";
	// @BeforeTest
	// public void setUp() throws MalformedURLException {
	//
	//
	// AppiumDriverLocalService appiumService;
	//
	// appiumService = AppiumDriverLocalService.buildService(new
	//// AppiumServiceBuilder().
	// usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
	// withAppiumJS(new File(Appium_JS_Path)));
	// appiumService.start();
	//
	//// appiumService = AppiumDriverLocalService.buildDefaultService();
	//// appiumService.start();
	//// appiumServiceUrl = appiumService.getUrl().toString();
	//// System.out.println("Appium Service Address : - "+ appiumServiceUrl);
	//
	//
	// }
	//
	// @Test
	// public void Sum() {
	// System.out.println("Calculate sum of two numbers");
	// // Locate elements to enter data and click +/= buttons
	//// driver.findElement(By.xpath("//*[@text='1']")).click();
	//// driver.findElement(By.xpath("//*[@text='+']")).click();
	//// driver.findElement(By.xpath("//*[@text='2']")).click();
	//// driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
	////
	//// // Get the result text
	//// WebElement sumOfNumbersEle =
	//// driver.findElement(By.className("android.widget.EditText"));
	//// String sumOfNumbers = sumOfNumbersEle.getText();
	////
	//// // verify if result is 3
	//// Assert.assertTrue(sumOfNumbers.endsWith("3"));
	// }

}
