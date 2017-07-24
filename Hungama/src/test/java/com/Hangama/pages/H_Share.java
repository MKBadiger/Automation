package com.Hangama.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

public class H_Share extends H_BasePage{

	public H_Share(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='Hungama Play']")
	MobileElement hamburger;
	
	/*@AndroidFindBy(name="The First Ladies")
	private MobileElement clickOnShow;*/
	
	@AndroidFindBy(name="TV Shows")
	private MobileElement clickOnTVShows;
	
	@AndroidFindBy(name="The First Ladies")
	private MobileElement clickOnShow;
	
	/*@AndroidFindBy(name="Main Tera Hero")
	private MobileElement clickOnMovieTitle;*/

	@AndroidFindBy(name="Share")
	private MobileElement share;
	
	@AndroidFindBy(name="Share using…")
	private MobileElement scroll;
	
	@AndroidFindBy(name="Gmail")
	private MobileElement selectGmail;
	
	@AndroidFindBy(id="com.google.android.gm:id/subject")
	private MobileElement shareContent;
	
	public AppiumDriver<MobileElement> shareScreen() throws InterruptedException{
		//driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driverMob.scrollToExact("Free Movies");
		Thread.sleep(2000);
		hamburger.click();
		Thread.sleep(2000);
		clickOnTVShows.click();
		Thread.sleep(2000);
		clickOnShow.click();
		Thread.sleep(2000);
		share.click();
		Thread.sleep(2000);
		scroll.click();
		Thread.sleep(2000);
		driverMob.scrollToExact("Gmail");
		selectGmail.click();
		//Assert.assertEquals("Content Matching", "The First Ladies", shareContent.getAttribute("text"));
		return driverMob;
	}
	
}
