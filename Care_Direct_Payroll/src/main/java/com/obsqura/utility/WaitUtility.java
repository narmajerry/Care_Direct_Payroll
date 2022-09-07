package com.obsqura.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, Duration Time) {
		
        WebDriverWait wait = new WebDriverWait(driver, Time);//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
	
	public WebElement waitForElementTobeClickable(WebDriver driver, WebElement elementToBeClickable, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        return element;
    }
	
	public WebElement presenceOfElement(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return element;
	}
}
