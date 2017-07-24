package com.writeData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demofile {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
	}

}
