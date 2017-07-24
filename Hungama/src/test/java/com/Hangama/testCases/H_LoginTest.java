package com.Hangama.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.Hangama.pages.H_Downloads;
import com.Hangama.pages.H_LoginPage;
import com.Hangama.pages.H_RegistrationPage;
import com.Hangama.pages.H_Share;
import com.Hangama.pages.H_SocialLogin;
import com.Hangama.pages.H_WishList;
import com.Hangama.pages.H_PlayMovieFromFreeBucket;

public class H_LoginTest extends H_BaseTest{
	
	String uniqueID="H_01";
	String loginType="Gmail_001";
	@Test(priority=1)
	public void Register() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		H_RegistrationPage hlp=new H_RegistrationPage(driverMob);
		hlp.loginScreen(uniqueID);
		
	}
	
	@Test(priority=2)
	public void Login() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_LoginPage hlp=new H_LoginPage(driverMob);
		hlp.loginScreen(loginType);
		
	}
	
	@Test(priority=3)
	public void Play_Pause_RewindMovieFromFreeBucket() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_PlayMovieFromFreeBucket pm=new H_PlayMovieFromFreeBucket(driverMob);
		pm.playMovieScreen();
		
	}
	
	@Test(priority=4)
	public void Download() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_Downloads hd=new H_Downloads(driverMob);
		hd.downloadScreen();
		
	}
	
	@Test(priority=5)
	public void SocialLogin() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_SocialLogin hsl=new H_SocialLogin(driverMob);
		hsl.socialLoginScreen(loginType);
		
	}
	
	@Test(priority=6)
	public void Share() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_Share hs=new H_Share(driverMob);
		hs.shareScreen();
		
	}
	
	@Test(priority=7)
	public void Add_RemoverFromWishList() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{

		H_WishList hwl=new H_WishList(driverMob);
		hwl.addToWishList();
		
	}
	
	
}
