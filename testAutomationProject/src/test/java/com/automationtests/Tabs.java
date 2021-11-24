package com.automationtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class Tabs extends BaseTest{

	@Test
public void testTabs() throws InterruptedException  {
		
		 gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
		 widgets.click();
		 System.out.println("Clicked Widgets here!!");		 
			/* Click Tabs Option*/

			WebElement TabsOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Tabs')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TabsOption);
			TabsOption.click();
			
			/*Select a Tab*/
			List<WebElement> selTab = driver.findElements(By.xpath("//nav[@class='nav nav-tabs']/a"));
			for(WebElement tab: selTab)
			{
				System.out.println("The tab name is " + tab.getText());
				if(tab.getText().equalsIgnoreCase("Use"))
				{
					tab.click();
					break;
				}				
			}
			Thread.sleep(4000);
		  	WebElement TabContent = driver.findElement(By.xpath("//div[@id='demo-tabpane-use']/p"));
		  	if(TabContent.getText().contains("Content here, content here"))
		  	{
		  		System.out.println("The selected tab is correct now !!");
		  	}

}
}
