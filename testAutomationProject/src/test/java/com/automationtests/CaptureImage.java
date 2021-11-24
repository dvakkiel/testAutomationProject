package com.automationtests;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CaptureImage {
	public static void main(String[] args) throws IOException
	{
	System.setProperty("webdriver.chrome.driver","D://Chrome Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	WebElement logoImgElmnt = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img[1]"));
	Screenshot logoImgSceenshot = new AShot().takeScreenshot(driver, logoImgElmnt);
    //* To save the logo Image screenshot as an image and save it in a file format in some location
	ImageIO.write(logoImgSceenshot.getImage(), "png", new File("D://Logos/OrangeHRMLogo.png"));
	File f=  new File("D://Logos/OrangeHRMLogo.png");
	if (f.exists())
	{
		System.out.println("The logo image is captured");
		
	}
	else
	{
		System.out.println("The logo image is not captured");
	}
	driver.quit();
	
}
}
