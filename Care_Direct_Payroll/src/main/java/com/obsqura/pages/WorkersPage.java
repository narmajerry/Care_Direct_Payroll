package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utility.PageUtility;

public class WorkersPage {

	WebDriver driver;
	PageUtility pageUtil=new PageUtility();
	
	@FindBy(xpath="//*[text()='Clients']")
	private WebElement workersHeading;
	
	@FindBy(id="workersearch-first_name")
	WebElement workerSearchFirstName;
	
	@FindBy(id="workersearch-last_name")
	WebElement workerSearchLastName;
	
	@FindBy(id="workersearch-postcode")
	WebElement workerSearchPostcode;
	
	@FindBy(id="workersearch-ni_number")
	WebElement workerSearchNiNum;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement workersPageSearch;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/update?id=812']")
	private WebElement workersPageEdit;
	
	@FindBy(xpath="//table/tbody/tr[1]/td")
	private WebElement workersPageTable;
	
	@FindBy(xpath="//button[@type='submit' and text()='Next']")
	WebElement updateWorkerpageNextBtn;
	
	
	public WorkersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHeading()
	{
		return workersHeading.getText();
	}
	 public void setWorkerFirstName(String strWorkerFirstName){
	    	
		 workerSearchFirstName.sendKeys(strWorkerFirstName);     
	    }
	 public void setWorkerLastName(String strWorkerLastName){
	    	
		 workerSearchLastName.sendKeys(strWorkerLastName);     
	    }
	 public void setWorkerPostcode(String strWorkerPostcode){
	    	
		 workerSearchPostcode.sendKeys(strWorkerPostcode);     
	    }
	 public void setWorkerNiNum(String strWorkerNiNum){
	    	
		 workerSearchNiNum.sendKeys(strWorkerNiNum);     
	    }
	 

	 public void clickWorkersPageSearch()
		{
		// workersPageSearch.click();
		 pageUtil.elementClick(driver, workersPageSearch);
		}
	 public void clickWorkersPageEdit()
	 {
		 workersPageEdit.click();
		// workersPageTable.getText();
		 
	 }

	 public void clickUpdateWorkerPgNextbtn()
	 {
		 updateWorkerpageNextBtn.click();
		 
	 }

}
