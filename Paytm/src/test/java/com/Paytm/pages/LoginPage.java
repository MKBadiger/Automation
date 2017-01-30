package com.Paytm.pages;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.asprise.util.ocr.OCR;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage{
	
	
	public LoginPage(AppiumDriver<MobileElement> driverMob) {
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
		
	}

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

	private HashMap<String, String> data;
	
	//public LogOut loginScreen(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		public Recharge loginScreen() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
				
	/*	data=readExcelData("Main",uniqueValue);
		String sheetName=data.get("Flow");
		data=readExcelData(sheetName, uniqueValue);*/
		
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
		Thread.sleep(2000);
		//String text=(image(driverMob)).toString();
		//System.out.println(text);
		//Test(driverMob);
		return new Recharge(driverMob);
		
	}
		
		/*public static AppiumDriver<MobileElement> image(AppiumDriver<MobileElement> driver) throws IOException{
			File targetFile=null;
			try{
				
				File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						//getScreenShotAs(OutputType.FILE);
				String fileName=UUID.randomUUID().toString();
				targetFile=new File("./screenShots/"+fileName+".png");
				FileUtils.copyFile(srcFile, targetFile);
				System.out.println(fileName.toString());
				Test(fileName);
			}
			catch(Exception e){
				
			}
		
			return driver;
		}
		
		public static void Test(String fileName) throws IOException{
			//String imageUrl=fileName;
			 String imageUrl=driverWeb.findElement(By.xpath("net.one97.paytm:id/w_custom_dialog_btn_positive")).getAttribute("src");
			 System.out.println("Image source path : \n"+ imageUrl);

			 URL url = new URL(imageUrl);
			 Image image = ImageIO.read(url);
			 String s = new OCR().recognizeCharacters((RenderedImage) image);
			 System.out.println("Text From Image : \n"+ s);
			 System.out.println("Length of total text : \n"+ s.length());
			 driverWeb.quit();
		}*/
}
