package com.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//a[@class='gb_P']")).click();
		driver.findElement(By.id("Email")).sendKeys("m@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("*********");
		Thread.sleep(2000);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(5000);
		driver.getTitle();
		System.out.println("Title"+driver.getTitle());
		
	}
	
	
	
}
