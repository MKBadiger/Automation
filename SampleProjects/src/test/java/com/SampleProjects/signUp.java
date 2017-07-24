package com.SampleProjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class signUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\New_Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//a[text()='Signup']"));
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7892159224");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		WebElement otp=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the OTP");
		String otpNumber=scan.nextLine();
		otp.sendKeys(otpNumber);
		
	}

}
