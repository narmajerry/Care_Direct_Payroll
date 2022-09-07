package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;

public class CreateClientPage {

WebDriver driver;
	
	@FindBy(id="client-branch_id")
	WebElement branch;
	@FindBy(id="client-division_id")
	WebElement divId;
	@FindBy(id="client-client_name")
	WebElement clientName;
	@FindBy(id="client-client_address")
	WebElement clientAddress;
	@FindBy(id="client-postcode")
	WebElement clientPostcode;
	@FindBy(id="client-country")
	WebElement clientCountry;
	
	@FindBy(id="client-your_ref")
	WebElement youRef;
	@FindBy(id="client-invoice_contact")
	WebElement invoiceContact;
	@FindBy(id="client-phone")
	WebElement phone;
	@FindBy(id="client-fax")
	WebElement clientFax;
	@FindBy(id="client-email")
	WebElement clientEmail;
	@FindBy(id="client-company_reg")
	WebElement companyReg;
	
	@FindBy(id="client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(id="client-invoice_delivery_method")
	WebElement invDelivryMethod;
	@FindBy(id="client-master_document")
	WebElement masterDocument;
	@FindBy(id="client-settilement_days")
	WebElement settilementDays;
	@FindBy(id="client-vat_rate")
	WebElement vatRate;
	@FindBy(id="client-direct_client")
	WebElement checkBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	public CreateClientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void branchDropdown()
	{
		Select dropdown=new Select(branch);
		dropdown.selectByVisibleText(Constants.CLIENTBRANCH);
	}
	public void divDropdown()
	{
		Select dropdown=new Select(divId);
		dropdown.selectByVisibleText(Constants.CLIENTDIV);
	}
	
	  public void setClientName(String strClientName){
		  clientName.clear();
		  clientName.sendKeys(strClientName);
	    }
	  public void setClientAddress(String strClientAddrs){
		  clientAddress.clear();
		  clientAddress.sendKeys(strClientAddrs);
	    }
	  public void setPostCode(String strPostCode){
		  clientPostcode.clear();
		  clientPostcode.sendKeys(strPostCode);
	    }
	  public void setYourRef(String strRef){
		  youRef.clear();
		  youRef.sendKeys(strRef);
	    }
	  public void setInvContact(String strInvContact){
		  invoiceContact.clear();
		  invoiceContact.sendKeys(strInvContact);
	    }
	  public void setPhone(String strPhone){
		  phone.clear();
		  phone.sendKeys(strPhone);
	    }
	  public void setFax(String strFax){
		  clientFax.clear();
		  clientFax.sendKeys(strFax);
	    }
	  public void setEmail(String strEmail){
		  clientEmail.clear();
		  clientEmail.sendKeys(strEmail);
	    }
	  public void setCompanyReg(String strCompanyReg){
		  companyReg.clear();
		  companyReg.sendKeys(strCompanyReg);
	    }
	  public void setSettlementDays(String strSettlementDays){
		  settilementDays.clear();
		  settilementDays.sendKeys(strSettlementDays);
	    }
	public void invOrderDropdown()
	{
		Select dropdown=new Select(invoiceOrder);
		dropdown.selectByVisibleText(Constants.CLIENTINVOICEORDER);
	}
	public void invMasterDocDropdown()
	{
		Select dropdown=new Select(masterDocument);
		dropdown.selectByVisibleText(Constants.MASTERDOCUMENT);
	}
	public void invDeliveryMehod()
	{
		Select dropdown=new Select(invDelivryMethod);
		dropdown.selectByVisibleText(Constants.CLIENTINVOICEDELIVERYMETHD);
	}
	public void invVatRate()
	{
		Select dropdown=new Select(vatRate);
		dropdown.selectByVisibleText(Constants.VATRATE);
	}
	public void clickSave() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", saveButton);
		//saveButton.click();
	}

}
