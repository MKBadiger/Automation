package com.Hangama.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class H_Downloads extends H_BasePage{

	public H_Downloads(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(name="Hungama Play")
	MobileElement hamburger;
	
	/*@AndroidFindBy(className="android.widget.ImageButton")
	private MobileElement hamburger;*/
	
	@AndroidFindBy(name="TV Shows")
	private MobileElement clickOnTVShows;
	
	@AndroidFindBy(name="Latest on TV")
	private MobileElement tvShows;
	
	@AndroidFindBy(name="Sankatmochan Mahabali Hanumaan")
	private MobileElement clickOnShow;
	
	/*@AndroidFindBy(name="EP 340 - Halahala Vish ka Prabhav")
	private MobileElement episode340;
	*/
	@AndroidFindBy(id="com.hungama.movies:id/iv_action_btn")
	private MobileElement episode340Downoad;
	
	@AndroidFindBy(name = "My Downloads")
	private MobileElement clickOnDownloads;
	
	@AndroidFindBy(name = "DONE")
	private MobileElement done;
	
	@AndroidFindBy(id="com.hungama.movies:id/pb_media_download_progress")
	private MobileElement clickForPause;
	
	//@AndroidFindBy(name="Back")
	@AndroidFindBy(name="Back")
	MobileElement back;
	
	//@AndroidFindBy(id="com.hungama.movies:id/play_controller_lyt")
	@AndroidFindBy(id="com.hungama.movies:id/surface_view")
	MobileElement touchOnScreen;
	
	public AppiumDriver<MobileElement> downloadScreen() throws InterruptedException
	{
		//driverMob.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(6000);
		hamburger.click();
		clickOnTVShows.click();
		
		driverMob.scrollToExact("Latest on TV");
		clickOnShow.click();
		System.out.println(" clicked clickonshow");
		
		Thread.sleep(2000);
		touchOnScreen.click();
		Thread.sleep(2000);
		back.click();
		Thread.sleep(1000);
		
		driverMob.scrollToExact("EP 340 - Shri Narayan Ka Kurma Avtar ");
		//episode340Downoad.getAttribute("")
		episode340Downoad.click();
		Reporter.log("!!!...Started Downloading...!!!");
		Thread.sleep(2000);
		touchOnScreen.click();
		back.click();
		hamburger.click();
		clickOnDownloads.click();
		
	/*	Thread.sleep(2000);
		Thread.sleep(2000);
		clickOnDownload.click();
		Thread.sleep(2000);*/
		/*storage.click();
		Thread.sleep(2000);
		quality.click();
		Thread.sleep(2000);*/
		/*done.click();
		Thread.sleep(2000);*/
		/*clickForPause.click();
		Thread.sleep(2000);
*/		//back.click();
		back.click();
		return driverMob;
	}

}
