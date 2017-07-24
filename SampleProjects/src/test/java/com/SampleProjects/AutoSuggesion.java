package com.SampleProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggesion {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\New_Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//Here i am entering 'g' and selecting 'gmail' in the auto suggestion list or else select based on the value or index
		driver.findElement(By.id("lst-ib")).sendKeys("g");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='gstl_0 sbdd_a']//b[contains(text(),'ail')]")).click();

	}
}
