package com.basepackage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	public static  WebDriver driver = null;
	String baseURL = "https://demoqa.com";
	
	
  @BeforeTest
  public static WebDriver openChromeBrowser() {
		HashMap<String, Object> prefs = new HashMap<String, Object>();
 		// Create object of Chrome option class
 		ChromeOptions chromeOptions = new ChromeOptions();		
	
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("profile.default_content_settings.cookies", 2);
		//prefs.put("profile.default_content_setting_values.cookies",1); argument 1 is allow and argument 2 is to block
		prefs.put("profile.cookie_controls_mode", 2);
	    prefs.put("profile.default_content_setting_values.notifications",2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", 2);				
	    // Sets the experimental option
		chromeOptions.setExperimentalOption("prefs", prefs);
		// incognito and maximize
		chromeOptions.addArguments("--incognito", "start-maximized");		 
		chromeOptions.addArguments("--disable-popup-blocking");
		System.setProperty("webdriver.chrome.driver","D://Chrome Driver/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		System.out.println("The chrome browser is open now !!");
		return driver;
		
  }
  
  public WebDriver openFirefoxBrowser() {
	 System.setProperty("webdriver.gecko.driver", "D://Drivers/geckodriver.exe");
      driver = new FirefoxDriver();
      driver.manage().window().maximize();
      return driver;
		
  }
  
  public void gotoURL()
  {
	 driver.get(baseURL); 
  }
  
  @AfterTest()
  public static void loseBrowser()
  {
	  driver.quit();
  }
  
  
}
