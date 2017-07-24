package com.flipkart.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.flipkart.pages.F_BasePage;

public class F_BaseTest {

	public WebDriver driverWeb;
	
	F_BasePage bp;
	@Parameters("myBrowser")
	@BeforeMethod
	public void setUp(String myBrowser) throws IOException, InterruptedException{
		if(myBrowser.equalsIgnoreCase("firefox")){
		/*bp=new F_BasePage(driverWeb);
		driverWeb=bp.launchFirefoxBrowser(mybrowser);*/
			driverWeb=new FirefoxDriver();
			driverWeb.get("http://www.flipkart.com");
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			/*bp=new F_BasePage(driverWeb);
			driverWeb=bp.launchChromeBrowser();*/
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driverWeb=new ChromeDriver();
			driverWeb.get("http://www.flipkart.com");
		}
	}
}
