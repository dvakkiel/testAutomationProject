package com.automationtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class PracticeFormFill extends BaseTest {
	
	@Test
	public void testDraggableOptions() throws InterruptedException  {
		
		gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement forms = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Forms')]"));	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forms);
		forms.click();
		System.out.println("Clicked Forms here!!");
		
		/* Click Form Option*/

		WebElement PracticeForm = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Practice Form')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PracticeForm);
		PracticeForm.click();
		System.out.println("Clicked Practice Forms here!!");
		
		/* Submission Form */
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		FirstName.sendKeys("Adam");
		WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		LastName.sendKeys("Levine");
		WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		Email.sendKeys("alevine@galamail.com");
        WebElement genderSel = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        genderSel.click();
        WebElement Mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
        Mobile.sendKeys("2222222222");
        WebElement DobBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        DobBox.click();
        WebElement MonthSelect = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select mSel= new Select(MonthSelect);
        mSel.selectByVisibleText("April");
        WebElement YearSelect = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select mSel1= new Select(YearSelect);
        mSel1.selectByValue("1990");
        WebElement DaySelect = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016']"));
        DaySelect.click();
        WebElement SubField = driver.findElement(By.xpath("//div[@id='subjectsContainer']"));
//        SubField.click();
//        WebElement SubFieldEntry = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(SubFieldEntry));
        SubField.click();
        SubField.sendKeys("Maths");
		Thread.sleep(2000);
		SubField.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		SubField.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		SubField.sendKeys("Computer Science");
		Thread.sleep(2000);
		SubField.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		SubField.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		Thread.sleep(4000);
       
       
       
	}
}