package com.automationtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;
@Test(enabled = true)
public class ToolTips extends BaseTest{
	
	public void testToolTips() throws InterruptedException  {
		
		gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement widgets = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Widgets')]"));	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgets);
			 widgets.click();
		System.out.println("Clicked Widgets here!!");
		
		/* Click ToolTips Option*/

		WebElement TooltipsOption = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Tool Tips')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TooltipsOption);
		TooltipsOption.click();
		
		/* Hover over Tool tip button*/
		WebElement TooltipBtn = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		Actions ac = new Actions(driver);
        ac.clickAndHold(TooltipBtn).build().perform();
        Thread.sleep(3000);
        WebElement tooltip1 = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        String tooltipvalue1 = tooltip1.getText();
        System.out.println("The button tool tip value is " + tooltipvalue1);
        
        WebElement  ToolTipTextBox = driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
        ac.moveToElement(ToolTipTextBox).build().perform();
        Thread.sleep(3000);
        WebElement tooltip2 = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        String tooltipvalue2 = tooltip2.getText();
        System.out.println("The textfield tool tip value is " + tooltipvalue2);
        
        List<WebElement>  ContainerToolTips = driver.findElements(By.xpath("//div[@id='texToolTopContainer']/a"));
        for(WebElement tips : ContainerToolTips)
        {
        	ac.moveToElement(tips).build().perform();
        	Thread.sleep(2000);       	
        	WebElement tooltip3 = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
            String tooltipvalue3 = tooltip3.getText();
            System.out.println("The paragraph link tool tip value is " + tooltipvalue3);
        }
      
}
}
