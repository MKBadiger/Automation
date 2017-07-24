package com.SampleProjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindow {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\New_Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		// Storing parent window reference into a String Variable
		String Parent_Window = driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='content']/p[4]/button")).click();
		Thread.sleep(5000);
		// Switching from parent window to child window
		Set<String>  Child_Window =driver.getWindowHandles();
		int index=0;
		if(Child_Window.size()>index){
			String handle=Child_Window.toArray()[index+1].toString();
			System.out.println(Child_Window);
			System.out.println("--------------");
			System.out.println(handle);
			driver.switchTo().window(handle);
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='primary-menu']/li[1]/a/span[1]/span/span")).click();
		}
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(Parent_Window);
		Thread.sleep(5000);
		driver.findElement(By.id("button1")).click();
	}

}
