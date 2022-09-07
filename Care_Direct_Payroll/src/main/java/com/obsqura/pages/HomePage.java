package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/payrollapp/site/index']")
	private WebElement dashBoard;
	
	@FindBy(xpath="//a[@href='/payrollapp/client/index']")
	private WebElement clientpage;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/index']")
	private WebElement workersPage;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDashboard()
	{
		dashBoard.click();
	}
	public void clickClient()
	{
		clientpage.click();
		driver.navigate().to("https://www.qabible.in/payrollapp/client/index");
	}
	public void clickWorkers()
	{
		workersPage.click();
		
	}
}
