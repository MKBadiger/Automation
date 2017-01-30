package com.Paytm.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MoastMassage extends BasePage{

	public MoastMassage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}

	public AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(id="net.one97.paytm:id/img_tab_bar_profile")
	private MobileElement profile;
	
	@AndroidFindBy(id="net.one97.paytm:id/lyt_user")
	private MobileElement clickOnSignIn;
	
	@AndroidFindBy(name="Email or Mobile")
	private MobileElement emailID;
	
	@AndroidFindBy(id="net.one97.paytm:id/edit_password")
	private MobileElement password;
	
	@AndroidFindBy(id="net.one97.paytm:id/lyt_sign_in_button")
	private MobileElement loginButton;
	
	public AppiumDriver<MobileElement> loginScreen() throws InterruptedException{
			Thread.sleep(2000);
			profile.click();
			Thread.sleep(2000);
			clickOnSignIn.click();
			Thread.sleep(2000);
			emailID.clear();
			emailID.sendKeys("arti.kote8808@gmail.com");
			//emailID.sendKeys(data.get("Email"));
			Thread.sleep(2000);
			password.clear();
			password.sendKeys("a741157880");
			//password.sendKeys(data.get("Password"));
			Thread.sleep(2000);
			loginButton.click();
			
			image(driver);
			return driver;
			
		}
	public void test(){
		
	}
	
	public static AppiumDriver<MobileElement> image(AppiumDriver<MobileElement> driver){
	File targetFile=null;
	try{
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				//getScreenShotAs(OutputType.FILE);
		String fileName=UUID.randomUUID().toString();
		targetFile=new File("./screenShots/"+fileName+".png");
		FileUtils.copyFile(srcFile, targetFile);
		System.out.println(targetFile.toString());
	}
	catch(Exception e){
		
	}
	return driver;
	}
}
