package com.automationtests;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class DatePicker extends BaseTest{
	
	@Test( priority=1, enabled=true) 
	public void selectDate() throws InterruptedException {
		 gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
			 widgets.click();
		System.out.println("Clicked Widgets here!!");
		
		/* Date Picker code*/

			WebElement datePickerOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Date Picker')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePickerOption);
			datePickerOption.click();	
			WebElement inputBox= driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
			inputBox.click();
			
			Select MonthSelect = new Select(driver.findElement(By.xpath("//div[@class=\"react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select\"]/select[1]")));
			MonthSelect.selectByValue("8");
			Select YearSelect = new Select(driver.findElement(By.xpath("//div[@class=\"react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select\"]/select[1]")));
			YearSelect.selectByValue("1979");
			
			WebElement Day = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--021']"));
			Day.click();
			String dateSelected = inputBox.getAttribute("value");
			System.out.println("The date selected from date Picker is " + dateSelected);
			
			/* Date and Time picker code*/
			
			WebElement inputBox1= driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
			inputBox1.click(); 
			WebElement monthArrow = driver.findElement(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']"));
			monthArrow.click();
			List<WebElement> Months = driver.findElements(By.xpath("//div[@class='react-datepicker__month-option']"));
			Actions ac = new Actions(driver);
			for (WebElement m : Months)
				
			{
				 System.out.println(m.getText());
			     if(m.getText().equalsIgnoreCase("May"))
			     {  
			    	 ac.doubleClick(m).perform();
			    	 break;
			     }
			}
			WebElement YearArrow = driver.findElement(By.xpath("//div/span[@class ='react-datepicker__year-read-view--down-arrow']"));
			YearArrow.click();
			boolean flag = false;
//			List<WebElement> Years = driver.findElements(By.xpath("//div[@class='react-datepicker__year-dropdown']/div"));
//			
//			
//		    for(WebElement y :Years)
//			  {	
//				 System.out.println("List : " + y.getText());	  
//				 if(y.getText().equalsIgnoreCase("2030"))
//			    {  
//			    	 ac.doubleClick(y).perform();
//			    	 flag = true;
//		    	    break;
//			     }
//			  }
//		    
			 if(flag == false)
				 do
			    {
					 WebElement z = driver.findElement(By.xpath("//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming']"));
					 z.click();					 
					 Thread.sleep(1000);
					 List<WebElement> Years1 = driver.findElements(By.xpath("//div[@class='react-datepicker__year-option']"));					
					    for(WebElement y :Years1)
						  {
							 System.out.println("Second List : " + y.getText());
							 if(y.getText().equalsIgnoreCase("2031"))
						    {  
						    	 ac.doubleClick(y).perform();
						    	 flag = true;
					    	    break;
						     }
						  }
					 
				 }while(flag == false);
			
			 List<WebElement> Timepicker = driver.findElements(By.xpath("//div[@class='react-datepicker__time']/div/ul/li"));
			 for (WebElement t : Timepicker) {
				 
				 System.out.println("The time is " + t.getText());
				 if(t.getText().equalsIgnoreCase("01:45"))
				 {
					 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", t);
					 t.click(); 
					 Thread.sleep(4000);
					 break;
					 
				 }
			 }
			 
			}

		
			
}


