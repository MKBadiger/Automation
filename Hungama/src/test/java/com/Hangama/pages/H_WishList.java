package com.Hangama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class H_WishList extends H_BasePage{

	public H_WishList(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}

	@AndroidFindBy(id="com.hungama.movies:id/cb_watchlist")
	private MobileElement wishList;
	
	
	public AppiumDriver<MobileElement> addToWishList(){
		wishList.click();
		Reporter.log("Successfully added in wishlist");
		return driverMob;
	}
}
