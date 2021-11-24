package com.automationtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.basepackage.BaseTest;

public class DraggableTest extends BaseTest {
@Test
	public void testDraggableOptions() throws InterruptedException  {
		
		gotoURL();		    
		 driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();	
		 WebElement interactions = driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Interactions')]"));	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interactions);
		interactions.click();
		System.out.println("Clicked Interactions here!!");
		
		/* Click ToolTips Option*/

		WebElement DragabbleOptions = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Dragabble')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DragabbleOptions);
		DragabbleOptions.click();
		System.out.println("Clicked Dragabble options here!!");
		/* First Option*/
		WebElement SimpleTab1 = driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/a[@id='draggableExample-tab-simple']"));
		SimpleTab1.click();
		WebElement DragMeCntr = driver.findElement(By.xpath("//div[@class='drag-box ui-draggable ui-draggable-handle'][contains(text(),'Drag me')]"));
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(DragMeCntr, 208, 132)
	    .pause(Duration.ofSeconds(2))
		.build()
		.perform();
		System.out.println("Draggable completed!!");
		
		/* Second Option*/
		WebElement AxisRestrictedTab = driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/a[@id='draggableExample-tab-axisRestriction']"));
		AxisRestrictedTab.click();
		System.out.println("Clicked the second tab now");
     	 WebElement DragMeCntrX = driver.findElement(By.xpath("//div[@id='restrictedX']"));
		 ac.dragAndDropBy(DragMeCntrX, -172, 0)
	    .pause(Duration.ofSeconds(4))
		.build()
		.perform();
		System.out.println("Draggable in X-Axis is now completed!!");
		
		WebElement DragMeCntrY = driver.findElement(By.xpath("//div[@id='restrictedY']"));
		 ac.dragAndDropBy(DragMeCntrY, 0, 109)
	    .pause(Duration.ofSeconds(4))
		.build()
		.perform();
		System.out.println("Draggable in Y-Axis is now completed!!");
		
		/* Third Option*/
		WebElement CntnrRestrictedTab = driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/a[@id='draggableExample-tab-containerRestriction']"));
		CntnrRestrictedTab.click();
		System.out.println("Clicked the third tab now");
		WebElement DragWthnCntnr = driver.findElement(By.xpath("//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']"));
		Thread.sleep(4000);
		 ac.dragAndDropBy(DragWthnCntnr, 157, 48)
		    .pause(Duration.ofSeconds(4))
			.build()
			.perform();
			System.out.println("Dragged the object inside the container it is in");
			
			WebElement DragWthnParent = driver.findElement(By.xpath("//span[contains(text(),\"I'm contained within my parent\")]"));
			Thread.sleep(4000);
			 ac.dragAndDropBy(DragWthnParent, 11, 36)
			    .pause(Duration.ofSeconds(4))
				.build()
				.perform();
				System.out.println("Dragged the text object insie the parent only");
		
	   /* Fourth Option */
				WebElement CursorStyle = driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/a[@id='draggableExample-tab-cursorStyle']"));
				CursorStyle.click();
				System.out.println("Clicked the fourth tab now");	
				WebElement cntrCursor = driver.findElement(By.xpath("//div[@id='cursorCenter']"));
				Thread.sleep(4000);
				 ac.dragAndDropBy(cntrCursor, 263, 7)
				    .pause(Duration.ofSeconds(4))
					.build()
					.perform();
					System.out.println("Dragged the cursor which sticks to center");
}
}   
