package com.automationtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class MenuItemsCheck extends BaseTest{
@Test
public void testMenu() throws InterruptedException  {
		
		 gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
		 widgets.click();
		 System.out.println("Clicked Widgets here!!");		 
			/* Click Menu Option*/
			WebElement MenuOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Menu')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MenuOption);
			MenuOption.click();
			Actions ac = new Actions(driver);			
			/*Select a Menu*/
			List<WebElement> MenuItems = driver.findElements(By.xpath("//div/ul[@id='nav']/li"));
			for(WebElement item : MenuItems)
			{				
			 if(item.getText().equalsIgnoreCase("Main Item 2"))
				{	
				    
					ac.moveToElement(item);
	     			ac.click(item);
					ac.build().perform();
					System.out.println("The Main Menu clicked is " + item.getText());
					WebElement subMenu1= item.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));
					ac.moveToElement(subMenu1);
		            ac.click(subMenu1);
		            ac.build().perform();
		            System.out.println("The Sub Menu clicked is " + subMenu1.getText());
		            WebElement subMenu2 = subMenu1.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 2')]"));
		            ac.click(subMenu2);
		            ac.build().perform();
		            System.out.println("The last Sub Menu clicked is " + subMenu2.getText());
		            Thread.sleep(6000);
					break;
					
				}
			}
			
            
}

}
