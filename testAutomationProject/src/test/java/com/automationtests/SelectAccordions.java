package com.automationtests;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;


public class SelectAccordions extends BaseTest {
	
	@Test( priority=1, enabled=false) 
	public void selectAccordion() throws InterruptedException {
		  
		    gotoURL();		    
		    driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();						
			WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
			 widgets.click();
			System.out.println("Clicked Widgets here!!");
//			WebElement widgets = driver.findElement(By.xpath("//div[@class='category-cards']/div[4]"));
//			widgets.click();
			WebElement accordian = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Accordian')]"));
			accordian.click();			
			WebElement accordian1 = driver.findElement(By.xpath("//div[@class='card-header' and @id='section2Heading']"));
			accordian1.click();
			System.out.print("Clicked Accordian here!!");
			String accodianContent= driver.findElement(By.xpath("//div[@id='section2Content']//p[2]")).getAttribute("innerHTML");			
			System.out.println(accodianContent);			
}
	
	@Test(priority=2)
	public void selectAutoSuggestionInputText() throws InterruptedException
	{
		    gotoURL();
		    driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();						
			WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
			 widgets.click();
			System.out.println("Clicked Widgets here!!");
            WebElement autoCmplete = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Auto Complete')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", autoCmplete);
			autoCmplete.click();
			/* Entering values in a multiple input textbox */
			WebElement txtbox = driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));			   
			txtbox.click();
			System.out.print("Clicked Textbox here!!");
//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement txtbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='autoCompleteMultiple']//div[@class='auto-complete__placeholder css-1wa3eu0-placeholder']")));
		txtbox.sendKeys("Magenta");
		Thread.sleep(2000);
		txtbox.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		txtbox.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		
		txtbox.click();
		txtbox.sendKeys("Green");
		Thread.sleep(2000);
		txtbox.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		txtbox.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		/* Entering values in a Single input textbox */
		WebElement txtbox1 = driver.findElement(By.xpath("//input[@id='autoCompleteSingleInput']"));
		txtbox1.click();
		txtbox1.sendKeys("Yellow");
		Thread.sleep(2000);
		txtbox1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		txtbox1.sendKeys(Keys.ENTER);
		Thread.sleep(500);
	}
	
	
}
