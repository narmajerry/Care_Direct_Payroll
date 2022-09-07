package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.utility.PageUtility;

public class ClientPage {

	WebDriver driver;
	 PageUtility pageUtil=new PageUtility();
	
	@FindBy(xpath="//*[text()='Clients']")
	private WebElement clientHeading;
	
	@FindBy(xpath="//*[text()='Create Client']")
	private WebElement createClient;
	
	@FindBy(id="clientsearch-client_name")
	WebElement clientSearchClientName;
	
	@FindBy(id="clientsearch-id")
	WebElement clientSearchId;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clientPageSearch;
	
	@FindBy(xpath="//button[@type='reset']")
	private WebElement clientPageReset;
	
	public ClientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 public String getHeading()
		{
			return clientHeading.getText();
		}
	    
	 public void clickCreateClient()
		{
		 //createClient.click();
		 pageUtil.elementClick(driver, createClient);
		// driver.navigate().to("https://www.qabible.in/payrollapp/client/create");
		}
	 public void ClientName(String strClientName){
	    	
		 clientSearchClientName.sendKeys(strClientName);     
	    }
	 public void setClientId(String strClientId){
	    	
	    	clientSearchId.sendKeys(strClientId);     
	    }
	 
	 public void clickClientPageSearch()
		{
		// clientPageSearch.click();
		 pageUtil.elementClick(driver, clientPageSearch);
		
		}
	 public void clickClientPageReset()
		{
		 clientPageReset.click();
		 clientSearchClientName.clear();
		 clientSearchId.clear();
		 
		
		}
}
