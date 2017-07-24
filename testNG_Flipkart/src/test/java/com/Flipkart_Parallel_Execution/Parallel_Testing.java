package com.Flipkart_Parallel_Execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import utility.AdbUitls;

public class Parallel_Testing {

	
	static AppiumDriver<MobileElement> driver;
	DesiredCapabilities capabilities = null;
	String udid;

	@BeforeClass
	public void setup() throws MalformedURLException {
		
		
		System.out.println("*****Launching the app*****");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		capabilities.setCapability("app-wait-activity", "MainActivity");

	}


	@Test(priority = 3,dataProvider="getDevices")
	public void buyTrade(String deviceId) throws Exception {
		udid = deviceId;
		capabilities.setCapability("udid", deviceId);

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void displayDeviceName() throws IOException{
		String line = getDeviceName(udid);
	    Reporter.log("Test Executed on : "+line,true);
	}
	
	@DataProvider(parallel=true)
	public Object[][] getDevices(){
		ArrayList<String> al;
		String line = "";
		int lines = 0;
		Object[][] obj = null;
		try {
		    al = getConnetedDevices();
		    obj = new Object[al.size()][1];
		    int i=0;
		    for(String str:al){
		    	obj[i][0]=str;
		    	i++;
		    }
		        
		} catch (Exception e) {
		    System.err.println("Error");
		}
		return obj;
	}
	
	

	@AfterClass
	public void tearDown() {
		//driver.quit();

	}
	
	
	public static String getDeviceName(String udid) throws IOException{
		ProcessBuilder proc = new ProcessBuilder("adb", "-s", udid, "shell", "getprop", "ro.product.model");
	    Process p = proc.start();
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    String line = br2.readLine();
	    return line;
	}
	
	public static ArrayList<String> getConnetedDevices() throws IOException{
		ArrayList<String> al = new ArrayList<String>();
		int lines = 0;
		ProcessBuilder proc = new ProcessBuilder("adb", "devices");
	    Process p = proc.start();
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    String line;
		while ( (line = br2.readLine()) != null){
	    	if(lines>0&&line.contains("device")){
	    		al.add(line.substring(0, line.indexOf("\t")));
	    		System.out.println();
	    	}
	    	lines++;
	    }
		return al;
	}

}
