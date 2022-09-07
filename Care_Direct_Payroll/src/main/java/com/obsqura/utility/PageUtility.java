package com.obsqura.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	
	public void elementClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
    	actions.moveToElement(element).click().build().perform();
    	
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public void inputDataToTextField(WebElement element,String data) {
		 element.sendKeys(data);
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
	
	public void selectDropDownByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void selectDropDownByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectDropDownByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public String getDropDownSelectedText(WebElement element) {
		Select select=new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void contxClick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.contextClick(element);
    	actions.build().perform();
    	
    }
	public void clearTextField(WebElement element) {
		element.clear();
	}
	
	public void addScrolling(WebDriver driver,String parameter) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(parameter);
		
	}
	
	public void JSclick(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
