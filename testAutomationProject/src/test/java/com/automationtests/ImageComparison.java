package com.automationtests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparison {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D://Chrome Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		/* Capturing the location where image is stored - Expected Image*/
        BufferedImage  ExpectedImage = ImageIO.read(new File("D://Logos/OrangeHRMLogo.png"));
        /* Capturing the image from application - Actual  Image*/
        WebElement logoImgElmnt = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img[1]"));
    	Screenshot logoImgSceenshot = new AShot().takeScreenshot(driver, logoImgElmnt);
    	BufferedImage ActualImage = logoImgSceenshot.getImage();
    	/*Comparison of images*/
    	ImageDiffer imgDiffer= new ImageDiffer();
    	ImageDiff diff = imgDiffer.makeDiff(ExpectedImage, ActualImage);
    	if(diff.hasDiff() == true)
    	{
    		System.out.println("The images are NOT SAME");   		
    	} else
    	{
    		System.out.println("Images are Same");    		
    	}
    		
    	driver.quit();		
    	
	}

}
