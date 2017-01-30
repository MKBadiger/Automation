package com.Paytm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W_SearchProduct extends BasePage{

	public W_SearchProduct(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
	}
	
	@FindBy(id="input_0")
	private WebElement searchProduct;
	
	/*@FindBy(xpath="//span[@aria-valuenow='5000']")
	private WebElement minPrice;
	
	@FindBy(xpath="//span[@aria-valuenow='15000']")
	private WebElement maxPrice;*/
	
	@FindBy(xpath="(//i[@class='fa fa-search'])[2]")
	private WebElement searchBrand;
	
	@FindBy(xpath="(//div[@class='md-container'])[3]/div")
	private WebElement selectSandiskBrand;
	
	@FindBy(xpath="//div[text()='Adam Elements ADRAD16GIKLSL USB 3.0 16 GB Utility Pendrive (Silver)']")
	private WebElement pendrive;
	
	@FindBy(xpath="//span[contains(text(),'Buy for Rs')]/../..")
	private WebElement buy;
	
	
	public W_AddDeliveryAddress SearchProductPage() throws InterruptedException{
		Thread.sleep(20000);
		searchProduct.clear();
		searchProduct.sendKeys("PenDrive",Keys.ENTER);
		/*Thread.sleep(2000);
		minPrice.click();
		Thread.sleep(2000);
		maxPrice.click();*/
		Thread.sleep(2000);
		searchBrand.click();
		Thread.sleep(2000);
		selectSandiskBrand.click();
		Thread.sleep(2000);
		pendrive.click();
		Thread.sleep(2000);
		buy.click();

	    
		
		return new W_AddDeliveryAddress(driverWeb);
		
	}

}
