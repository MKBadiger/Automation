package com.Paytm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class W_LoginPage extends BasePage{

	public W_LoginPage(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
	}
	
	@FindBy(xpath="//a[text()='Log In / Sign Up']")
	private WebElement SignUpLink;
	
	@FindBy(id="input_0")
	private WebElement email;
	
	@FindBy(id="input_1")
	private WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Secure Login')]")
	private WebElement login;
	
	@FindBy(xpath="//iframe[@ng-hide='showVerificationScreen']")
	private WebElement frame;
	
	public W_SearchProduct webLoginPage() throws InterruptedException{
		
		Thread.sleep(2000);
		SignUpLink.click();

	
		driverWeb.switchTo().frame(frame);
		
		Thread.sleep(2000);
		email.clear();
		email.sendKeys("arti.kote8808@gmail.com");
		Thread.sleep(2000);
		//password.clear();
		password.sendKeys("a7411578808");
		Thread.sleep(2000);
		login.click();
		Thread.sleep(20000);
		 /* }
		 catch (Exception e) {
		    }*/
		
		return new W_SearchProduct(driverWeb);
		
	}

}
