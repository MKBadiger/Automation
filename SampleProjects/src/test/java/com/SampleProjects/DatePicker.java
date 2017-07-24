package com.SampleProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	static WebDriver driver;
	static String checkInday;
	static String checkInYear;
	static String checkOutday;
	static String checkOutYear;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\New_Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tripadvisor.in/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".typeahead_input")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[data-datetype='CHECKIN'] .picker-label.target")).click();
		//Here assigning the date format in the variable and
		//splitting based on the web site calendar format.
		String dateFormat = "25-Sep 2017";
		String[] split = dateFormat.split("-");
		System.out.println("day " + split[0] + " " + "Month-Year " + split[1]);
		
		//Here assigning the month and year in the variables
		checkInday = split[0];
		checkInYear = split[1];
		Thread.sleep(3000);
		selectDate(checkInYear,checkInday);
		
		driver.findElement(By.cssSelector("[data-datetype='CHECKOUT'] .picker-label.target")).click();
		dateFormat = "25-Oct 2017";
		split = dateFormat.split("-");
		System.out.println("day " + split[0] + " " + "Month-Year " + split[1]);
		checkOutday = split[0];
		checkOutYear = split[1];
		selectDate(checkOutYear,checkOutday);
		

	}
	public static void selectDate(String year, String day) throws InterruptedException{
	
		List<WebElement> ele = driver.findElements(By.cssSelector(".dsdc-month-title"));
		Thread.sleep(1000);
		for (int i = 0; i <= ele.size(); i++) {
			if (ele.get(i).getText().equals(year)) {
				System.out.println(ele.get(i).getText());
				Thread.sleep(1000);
				List<WebElement> days = driver.findElements(
						By.xpath("(//div[@class='dsdc-months']/span)[" + i+1 + "]/span[@class='dsdc-cell dsdc-day']"));
//				 List<WebElement>days=driver.findElements(By.cssSelector(".dsdc-months .dsdc-month:nth-child("+i+") .dsdc-cell.dsdc-day"));

				Thread.sleep(1000);
				for (WebElement d : days) {
					// System.out.println("days"+d.getText());
					if (d.getText().equals(day)) {
						d.click();
						return;
					}
				}
			}
		}
		driver.findElement(By.xpath("html/body/span/div[3]/div/div[2]")).click();
		driver.findElement(By.xpath("html/body/span/div[3]/div/div[2]")).click();
		Thread.sleep(2000);
		selectDate(year, day);
	}

}
