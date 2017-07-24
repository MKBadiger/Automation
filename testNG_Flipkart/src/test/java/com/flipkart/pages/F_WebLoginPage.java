package com.flipkart.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

public class F_WebLoginPage extends F_BasePage{

	public F_WebLoginPage(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Signup']")
	private WebElement loginLink;
	
	@FindBy(xpath="(//div[@class='new-login-form']//input)[1]")
	private WebElement mobileNo;
	
	@FindBy(xpath="(//div[@class='new-login-form']//input)[3]")
	private WebElement password;
	
	@FindBy(xpath="//a[text()='show'][1]")
	private WebElement show;
	
	@FindBy(xpath="(//input[@value='Login'])[2]")
	private WebElement Login;

	private HashMap<String, String> data;
	
	public String F_WebLogin(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		//System.out.println(uniqueValue);
		//String flowSheetName = data.get("Work Flow");
		//data = readData(flowSheetName, uniqueValue);
		//System.out.println("value "+uniqueValue);
		data = readExcelData("Info", uniqueValue);
		startTime=System.currentTimeMillis();
		System.out.println(startTime);
		Thread.sleep(2000);
		loginLink.click();
		Thread.sleep(2000);
		mobileNo.clear();
		//mobileNo.sendKeys("8951350157");
		mobileNo.sendKeys(data.get("Email"));
		System.out.println(data.get("Email"));
		Thread.sleep(2000);
		//password.sendKeys("Qwerty@123");
		password.sendKeys(data.get("Password"));
		System.out.println(data.get("Password"));
		Thread.sleep(5000);
		try{
		if (show.isDisplayed()) {
			  Login.click();
			  endTime=System.currentTimeMillis();
			  System.out.println(endTime);
			  System.out.println("Time taken to load page:"+(totalTime=(endTime-startTime)/1000)+" Seconds");
			}
		}
		catch(Exception e){
			
		}
		
	    //WebDriver = new FirefoxDriver();

	   // WebElement menu = driver.findElement(By.xpath("")); // the triger event element
		/*Thread.sleep(5000);
	    Actions build = new Actions(driverWeb); // heare you state ActionBuider
	    build.moveToElement(Login).build().perform(); // Here you perform hover mouse over the needed elemnt to triger the visibility of the hidden
	    WebElement m2m= Login;//the previous non visible element
	    m2m.click();*/
		
		/*WebDriverWait wait = new WebDriverWait(driverWeb, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Login));*/
		
		//driverWeb.wait(2000);
		//Login.click();
		return uniqueValue;
		//return new CartPage(driverWeb);
		
	}
	

}
