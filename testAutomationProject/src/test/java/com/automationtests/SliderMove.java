package com.automationtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class SliderMove extends BaseTest{

@Test(enabled = false)
public void testSlider() throws InterruptedException {
	
	gotoURL();		    
	 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
	 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
		 widgets.click();
	System.out.println("Clicked Widgets here!!");
	
	/* Click Slider Option*/

		WebElement SliderOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Slider')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SliderOption);
		SliderOption.click();
		WebElement Slider = driver.findElement(By.xpath("//input[@class=\"range-slider range-slider--primary\"]"));
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(Slider, 112, 0).build().perform();
		Thread.sleep(5000);
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='sliderValue']"));
		String SliderValue = inputBox.getAttribute("value");
		System.out.println("The slidervalue is " + SliderValue);
				
}

@Test(enabled = true)
public void ProgressBar() throws InterruptedException {
	boolean flag = false;
	gotoURL();		    
	 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
	 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
		 widgets.click();
	System.out.println("Clicked Widgets here!!");
	/* Click Progress Bar Option*/
	WebElement PrgssBarOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Progress Bar')]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PrgssBarOption);
	PrgssBarOption.click();
	System.out.println("Clicked Progress Bar option here!!");
	WebElement StartBtn= driver.findElement(By.xpath("//button[@id='startStopButton']"));
	 StartBtn.click();
	System.out.println("The button value is:" + StartBtn.getText());
	WebElement PrgssBar = driver.findElement(By.xpath("//div[@id='progressBar']/div[@role='progressbar']"));
	System.out.println("The class attribute is " + PrgssBar.getAttribute("class"));
/*   

    do {  	
   	if(PrgssBar.getAttribute("class").equalsIgnoreCase("progress-bar bg-success"))
    	{
    	flag = true;
   		break;
    	} 
    	System.out.println("The progress bar is going on now!!");
       } while(flag == false); */  
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000, 1));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class*='progress-bar bg-success']")));;
//   WebElement ResetBtn= driver.findElement(By.xpath("//button[@id='resetButton']"));
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5000, 1));
    wait1.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.xpath("//button[@id='resetButton']")), "id", "resetButton"));
    WebElement ResetBtn= driver.findElement(By.xpath("//button[@id='resetButton']"));
    System.out.println("The button value is:" + ResetBtn.getText());
}
}  
	

