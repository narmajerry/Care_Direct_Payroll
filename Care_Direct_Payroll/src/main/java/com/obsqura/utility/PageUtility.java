package com.obsqura.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtility {

	
	public void elementClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
    	actions.moveToElement(element).click().build().perform();
    	
	}
	public void dropdown(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.scrollToElement(element);
    	actions.build().perform();
    }
	
	public void doubleClick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.doubleClick(element);
    	actions.build().perform();
    }
	
	public void contxClick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.contextClick(element);
    	actions.build().perform();
    	
    }
}
