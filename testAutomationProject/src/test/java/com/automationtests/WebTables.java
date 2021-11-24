package com.automationtests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class WebTables extends BaseTest{
	
	@Test
	public void testToolTips() throws InterruptedException  {
		
		 gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement elements = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Elements')]"));	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
		elements.click();
		System.out.println("Clicked Elements here!!");
		
		/* Click WebTable Option*/
		WebElement WebTablesOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Web Tables')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WebTablesOption);
		WebTablesOption.click();
		
		System.out.println("Clicked WebTables option");
		WebElement table = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class=\"rt-tr -odd\" or @class = \"rt-tr -even\"]"));
		int rowCount = rows.size();
		System.out.println("The total rows in WebTable is " + rowCount);
		for(int i =0; i <rowCount ; i++)
		{
			 List <WebElement> cols = rows.get(i).findElements(By.className("rt-td"));		 
			 int colsCount = cols.size();
			 System.out.println("The total cols in the row is" + colsCount);
			 for(int j = 0; j <colsCount ; j++)
			 {
				 if (cols.get(j).getText().equals("cierra@example.com"))
					{
					 System.out.println("The WebElement columns values is now  " + cols.get(j).getText());
					 break; 
					} 
			 }
		 }		
			
		}
		
	
}
