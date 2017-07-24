package com.Hangama.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class H_PlayMovieFromFreeBucket extends H_BasePage{

	public H_PlayMovieFromFreeBucket(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}

	
	@AndroidFindBy(id="com.hungama.movies:id/play_controller_lyt")
	MobileElement touchScreen;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_pause")
	MobileElement play;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_pause")
	MobileElement pause;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_rewind")
	MobileElement rewind;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_forward")
	MobileElement forward;
	
	@AndroidFindBy(id="com.hungama.movies:id/tv_start_time")
	MobileElement startTime;
	
	@AndroidFindBy(id="com.hungama.movies:id/tv_start_time")
	MobileElement stopTime;
	
	@AndroidFindBy(id="com.hungama.movies:id/ll_time")
	MobileElement Timer;
	
	@AndroidFindBy(id="com.hungama.movies:id/sb_progress")
	MobileElement progressBar;
		
				
	public AppiumDriver<MobileElement> playMovieScreen() throws InterruptedException 
	{
		touchScreen.click();
		pause.click();
		Thread.sleep(3000);
		String time1=startTime.getAttribute("text");
		System.out.println(" paused time is : " + time1);
		
		String []strArray1=time1.split(":");
		for(int i=0; i<strArray1.length;i++) 
		{
			//System.out.println(strArray1[i]);
		}
		
		String splitTime1=strArray1[1];
		System.out.println(" splitTime1 is : " + splitTime1);
		 
		 int t1=Integer.parseInt(splitTime1);
		 System.out.println(" splitTime1 is converting string to Int : " + t1);
		
		 System.out.println("=================================================");
		forward.click();
		String time2=stopTime.getAttribute("text");
		System.out.println(" forwarded time is : " + time2);
		
		String []strArray2=time2.split(":");
		for(int i=0; i<strArray2.length;i++) 
		{
		   // System.out.println(strArray2[i]);
		    
		}

		String splitTime2=strArray2[1];
		
		int t2=Integer.parseInt(splitTime2);
		 System.out.println(" splitTime2 is converting string to Int : " + t2);
		
		System.out.println(" splitTime2 is : " + splitTime2);
		
			 
		int splittedTime1=t2-t1;
		System.out.println(" Difference between the paused time and forwarded time is : " + splittedTime1);
		//===================================
		touchScreen.click();
		rewind.click();
		
		String time3=stopTime.getAttribute("text");
		System.out.println(" rewinded time is : " + time3);
		
		String []strArray3=time3.split(":");
		for(int i=0; i<strArray3.length;i++) 
		{
		   // System.out.println(strArray3[i]);
		    
		}

		String splitTime3=strArray3[1];
		
		int t3=Integer.parseInt(splitTime3);
		 System.out.println(" splitTime2 is converting string to Int : " + t3);
		
		System.out.println(" splitTime3 is : " + splitTime3);
		
			 
		int splittedTime2=t2-t3;
		System.out.println(" Difference between the forwarded time and rewinded time is : " + splittedTime2);	
		
		return driverMob;
	}
	
	
	/*@AndroidFindBy(name="Free Movies")
	private MobileElement freeMovies;
	
	@AndroidFindBy(name="Main Tera Hero")
	private MobileElement clickOnMovieTitle;
	
	@AndroidFindBy(id = "com.hungama.movies:id/layout_play_btn")
	private MobileElement clickOnPlay;
	
	@AndroidFindBy(id="com.hungama.movies:id/play_controller_lyt")
	private MobileElement touchOnScreen;
	
	@AndroidFindBy(id = "com.hungama.movies:id/iv_play_pause")
	private MobileElement pause;
	
	@AndroidFindBy(id = "com.hungama.movies:id/iv_play_pause")
	private MobileElement play;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_forward")
	private MobileElement forward;
	
	@AndroidFindBy(id="com.hungama.movies:id/iv_play_rewind")
	private MobileElement rewind;
	
	@AndroidFindBy(id="com.hungama.movies:id/tv_start_time")
	private MobileElement startTime;
	
	@AndroidFindBy(id="com.hungama.movies:id/tv_start_time")
	private MobileElement forwardedTime;
	
	@AndroidFindBy(id="com.hungama.movies:id/tv_end_time")
	private MobileElement endTime;
	
	@AndroidFindBy(id="com.hungama.movies:id/sb_progress")
	private MobileElement progress;
	
	public AppiumDriver<MobileElement> playMovieScreen() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		driverMob.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driverMob.scrollToExact("Free Movies");
		
		clickOnMovieTitle.click();
		Thread.sleep(2000);
		clickOnPlay.click();
		Thread.sleep(5000);
		touchOnScreen.click();
		pause.click();
		String start=startTime.getAttribute("text");
		int s=Integer.parseInt(start);
		System.out.println("Start Time is: "+s);
		forward.click();
		String end=endTime.getAttribute("text");
		int e=Integer.parseInt(end);
		int Time=e-s;
		System.out.println("Start Time is: "+e);
		System.out.println("Time is: "+Time);
		try{
			if(play.isDisplayed())
			{
				String start=startTime.getAttribute("text");
				int s=Integer.parseInt(start);
				System.out.println("Start Time is: "+s);
				forward.click();
				String end=endTime.getAttribute("text");
				int e=Integer.parseInt(end);
				int Time=e-s;
				System.out.println("Start Time is: "+e);
				System.out.println("Time is: "+Time);
			//}
		}
		catch(Exception e){
			
		}
		
		forward.click();
		Thread.sleep(2000);
		rewind.click();
		Thread.sleep(2000);
		pause.click();
		Thread.sleep(2000);
		play.click();
		
		return driverMob;
	}*/
	
}
