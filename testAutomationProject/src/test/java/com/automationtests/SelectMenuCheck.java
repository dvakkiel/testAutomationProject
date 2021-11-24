package com.automationtests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class SelectMenuCheck extends BaseTest{
	@Test
	public void selectMenuTest() throws InterruptedException  {
			
			 gotoURL();		    
			 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
			 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
			 widgets.click();
			 System.out.println("Clicked Widgets here!!");
			 
				/* Click Select Menu Options*/
				WebElement SelectMenuOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Select Menu')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectMenuOption);
				SelectMenuOption.click();
				
				/*Check Select Menu Options */
				WebElement Select1=driver.findElement(By.xpath("//div[@class='mt-2 row']//div[@class=' css-1wa3eu0-placeholder'][contains(text(),'Select Option')]"));
				Select1.click();
				WebElement option = driver.findElement(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(text(),'Group 2, option 2')]"));
				Actions ac = new Actions(driver);
				ac.moveToElement(option).click(option).build().perform();
				Thread.sleep(2000);
				
				WebElement Select2=driver.findElement(By.xpath("//div[@class='mt-2 row']//div[@class=' css-1wa3eu0-placeholder'][contains(text(),'Select Title')]"));
				Select2.click();
				WebElement option1=driver.findElement(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(text(),'Ms.')]"));
				ac.moveToElement(option1).click(option1).build().perform();
				Thread.sleep(2000);
				
				/* Old Select Box*/
				WebElement Sel = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
				Select select = new Select(Sel);
				select.selectByVisibleText("Black");
				Thread.sleep(2000);
				
				/* MultiSelect Text Box*/
				WebElement Select3=driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[@class=' css-1wa3eu0-placeholder'][contains(text(),'Select...')]"));
				Select3.click();
				WebElement option2=driver.findElement(By.xpath("//div[@class=' css-11unzgr']/div[contains(text(),'Red')]"));
				ac.moveToElement(option2).click(option2).build().perform();				
				WebElement option3=driver.findElement(By.xpath("//div[@class=' css-11unzgr']/div[contains(text(),'Green')]"));
				ac.moveToElement(option3).click(option3).build().perform();
				Thread.sleep(2000);
//				WebElement inpt =driver.findElement(By.xpath("div[@class='css-1g6gooi']/div/input"));
//				inpt.click();
//				Thread.sleep(1000);
				
				/* MultiSelect Text Box*/
				WebElement Sel1 = driver.findElement(By.xpath("//select[@id='cars']"));
				Select select1 = new Select(Sel1);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", select1);
				select1.selectByVisibleText("Volvo");
				select1.selectByVisibleText("Saab");
				select1.selectByVisibleText("Audi");
				Thread.sleep(3000);
}
}
