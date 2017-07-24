package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest2 {
	
	public WebDriver driverWeb;
	@Test
	public void t3(){
		System.out.println("third test");
	}
	
	public void t4(){
		System.out.println("fouth test");
	}
	
	@Parameters("myBrowser")
	@BeforeClass
	public void setUp(String myBrowser) throws IOException, InterruptedException{
		System.out.println("value"+myBrowser);
		if(myBrowser.equalsIgnoreCase("firefox")){
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.flipkart.com");
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driverWeb=new ChromeDriver();
			driverWeb.get("http://www.flipkart.com");
		}
	}

}
