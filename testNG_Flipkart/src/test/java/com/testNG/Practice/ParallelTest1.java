package com.testNG.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest1 {
	public WebDriver driverWeb;
	@Parameters("myBrowser")
	@BeforeClass
	public void setUp(String myBrowser) throws IOException, InterruptedException{
		if(myBrowser.equalsIgnoreCase("firefox")){
		/*bp=new F_BasePage(driverWeb);
		driverWeb=bp.launchFirefoxBrowser(mybrowser);*/
			driverWeb=new FirefoxDriver();
			//driverWeb.get("http://www.flipkart.com");
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			/*bp=new F_BasePage(driverWeb);
			driverWeb=bp.launchChromeBrowser();*/
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driverWeb=new ChromeDriver();
			//driverWeb.get("http://www.flipkart.com");
		}
	}
	
	@Test
	public void launch(){
		driverWeb.get("http://www.flipkart.com");
	}
}
