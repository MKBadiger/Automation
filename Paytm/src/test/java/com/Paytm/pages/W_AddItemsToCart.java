package com.Paytm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W_AddItemsToCart extends BasePage{

	public W_AddItemsToCart(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
	}

	@FindBy(linkText="Electronics")
	private WebElement electonics;
	
	@FindBy(xpath=".//*[@id='c1carouselhome']/div[1]/div[1]/home-page-main-menu/div/div[2]/div[1]/ul/div[6]/ul/li/a")
	private WebElement selectHardDisk;
	
	@FindBy(xpath="//div[text()='Adata Classic HV620 2 TB External Hard Drive (Silver)']")
	private WebElement HardDisk;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement buyButton;
	
}
