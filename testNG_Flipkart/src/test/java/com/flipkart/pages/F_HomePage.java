package com.flipkart.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class F_HomePage extends F_BasePage{

	public F_HomePage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(name="Open Drawer")
	private MobileElement clickHB;
	
	@AndroidFindBy(name="My Account")
	private MobileElement myAccount;
	
	@AndroidFindBy(name="Flipkart home")
	private MobileElement flipkart;
	
	@AndroidFindBy(name="Electronics")
	private MobileElement electronics;
	
	@AndroidFindBy(name="Mobile Accessories")
	private MobileElement mobileAcc;
	
	@AndroidFindBy(name="Memory Cards")
	private MobileElement memoryCards;
	
	@AndroidFindBy(name="SAMSUNG Evo Plus 32 GB MicroSDHC Class 10 80 MB/s  Memory Card")
	private MobileElement sandisk32gb;
	
	@AndroidFindBy(name="GO TO CART")
	private MobileElement addToCart;
	
	/*@AndroidFindBy(id="com.flipkart.android:id/cart_bg_icon")
	private MobileElement clickCart;*/
	long totalTime;
	public void homePage() throws InterruptedException {
		//Thread.sleep(2000);
		//waitUntilElementAppears(flipkart);
		//System.out.println("hi");
		/*endTime=System.currentTimeMillis();
		long totalTime=startTime-endTime;
		System.out.println("Total time duration is:"+totalTime);*/
		//pageLoad.stop();
		//System.out.println("Totla time is:"+pageLoad.getTime());
		Thread.sleep(2000);
		//Thread.sleep(2000);
		clickHB.click();
		Thread.sleep(2000);
		/*myAccount.click();
		Thread.sleep(2000);*/
		electronics.click();
		Thread.sleep(2000);
		mobileAcc.click();
		Thread.sleep(2000);
		memoryCards.click();
		Thread.sleep(2000);
		//driverMob.scrollToExact("SanDisk Ultra 32 GB MicroSDHC Class 10 48 MB/s  Memory Card");
		sandisk32gb.click();
		Thread.sleep(2000);
		addToCart.click();
		F_BasePage.endTime=System.currentTimeMillis();
		System.out.println("Time taken to load page:"+(F_BasePage.totalTime=(F_BasePage.endTime-F_BasePage.startTime)/1000));
		Thread.sleep(3000);
		/*clickHB.click();
		Thread.sleep(2000);*/
		return;
	}

	/*private void waitUntilElementAppears(MobileElement flipkart2) {
		// TODO Auto-generated method stub
		
	}*/

}
