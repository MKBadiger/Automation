package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends F_BasePage{

	public CartPage(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[contains(text(),'Cart')]/..")
	private WebElement cart;
	
	@FindBy(xpath="(//span[contains(text(),'SAMSUNG MB-MC32DA/IN')]/../../../tr[2])//*[contains(text(),'Remove')]")
	private WebElement cartItemRemove;
	
	/*@FindBy(linkText="Remove")
	private WebElement remove;*/
	
	
	public void cartMethod() throws InterruptedException {
		Thread.sleep(5000);
		/*endTime=System.currentTimeMillis();
		System.out.println(endTime);
		System.out.println("Time taken to load page:"+(totalTime=(endTime-startTime)/1000));*/
		cart.click();
		Thread.sleep(2000);
		cartItemRemove.click();
		System.out.println("Item Removed");
		return;
	}
}
