package com.obsqura.scripts;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.CreateClientPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.WorkersPage;
import com.obsqura.utility.ExcelUtility;
import com.obsqura.utility.PageUtility;

public class TestClass  extends TestBase {

	LoginPage login;
	HomePage home;
	ClientPage clientpg;
	CreateClientPage createClient;
	WorkersPage workerspg;
	
	@Test(priority=2)
 	public void verifyLogin() throws IOException{
    
	login=new LoginPage(driver);
    driver.navigate().refresh();
	String username = ExcelUtility.getCellData(0, 0);
	try {
		username = ExcelUtility.getCellData(0, 0);
	}catch(IOException e) {
		e.printStackTrace();
	}
    String password = ExcelUtility.getCellData(0, 1);
    login.setUserName(username);
	login.setPassword(password);
	login.clickLogin();
	}
	
	@Test(priority=1)
	public void InvalidLogin() throws IOException
	{
		login=new LoginPage(driver);
		driver.navigate().refresh();
		String username = ExcelUtility.getCellData(1, 0);
	    String password = ExcelUtility.getCellData(1, 1);
	    login.setUserName(username);
	    login.setPassword(password);
	    login.clickLogin();
		
		String expectedErrorMessage=Constants.INVALIDLOGINMESSAGE;
		String actualErrorMessage=login.getInvalidLogErrorMessage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	} 
	
	@Test(priority=3)
	public void verifyClientPage() throws IOException
	{
		 home=new HomePage(driver);
		  synchronized(home) {
				try {
					home.wait(1000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			   }
		  home.clickClient();
		  clientpg= new ClientPage(driver);
		  clientpg.clickCreateClient();
		 
		  String expectedClientHeading=Constants.CLIENTPAGEHEADING;
		  String actualClientHeading=clientpg.getHeading();
		  Assert.assertEquals(expectedClientHeading, actualClientHeading);
	}
	
	@Test(priority=4)
	public void verifyClientPageSearchBtn() throws IOException
	{
		 home=new HomePage(driver);
		// driver.navigate().refresh();
		  synchronized(home) {
				try {
					home.wait(1000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			   }
		  home.clickClient();
		  clientpg= new ClientPage(driver);
		    String ClientName = ExcelUtility.getCellData(3, 0);
		    String ClientId = ExcelUtility.getCellData(3, 1);
		    clientpg.ClientName(ClientName);
		    clientpg.setClientId(ClientId);
		    clientpg.clickClientPageSearch();
		  
		  String expectedClientHeading=Constants.CLIENTPAGEHEADING;
		  String actualClientHeading=clientpg.getHeading();
		  Assert.assertEquals(expectedClientHeading, actualClientHeading);
		  
	}
	
	@Test(priority=5)
	public void verifyClientPageResetBtn() throws IOException
	{
		clientpg= new ClientPage(driver);
		clientpg.clickClientPageReset();
	}
	@Test(priority=6)
	public void verifyCreateClientPage() throws IOException, InterruptedException
	{
		clientpg= new ClientPage(driver);
		clientpg.clickCreateClient();
		createClient=new CreateClientPage(driver);
		
		createClient.branchDropdown();
		createClient.divDropdown();
		String strClientName= ExcelUtility.getCellData(4, 1);
		createClient.setClientName(strClientName); 
		String strClientAddrs= ExcelUtility.getCellData(5,1);
	    createClient.setClientAddress(strClientAddrs);
	    String strPostCode= ExcelUtility.getCellData(6, 1);
		createClient.setPostCode(strPostCode);
		String strYouRef= ExcelUtility.getCellData(7, 1);
		createClient.setYourRef(strYouRef);
		String strInvContact= ExcelUtility.getCellData(8, 1);
		createClient.setInvContact(strInvContact);
		String strPhone= ExcelUtility.getCellData(9, 1);
		createClient.setPhone(strPhone);
		String strFax= ExcelUtility.getCellData(10, 1);
		createClient.setFax(strFax);
		String strEmail= ExcelUtility.getCellData(11, 1);
		createClient.setEmail(strEmail);
		String strCompanyReg= ExcelUtility.getCellData(12, 1);
		createClient.setCompanyReg(strCompanyReg);
		createClient.invOrderDropdown();
		createClient.invDeliveryMehod();
		createClient.invMasterDocDropdown();
		createClient.invVatRate();
		String strSettlmntday= ExcelUtility.getCellData(13, 1);
		createClient.setSettlementDays(strSettlmntday);
		createClient.clickSave();	
		
	}
	
	@Test(priority=7)
	  public void verifyWorkersPage() throws IOException
	  {
		  home=new HomePage(driver);
		  synchronized(home) {
				try {
					home.wait(1000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			   }
		  home.clickDashboard();
		  home.clickWorkers();
		  workerspg= new WorkersPage(driver);
		  String expectedWorkersHeading=Constants.WORKERSPAGEHEADING;
		  String actualWorkersHeading=workerspg.getHeading();
		  Assert.assertEquals(expectedWorkersHeading, actualWorkersHeading);
		  
		  
		  
	  }
	@Test(priority=8)
	public void verifyWorkersPageSearchBtn() throws IOException
	{
		workerspg =new WorkersPage(driver);
		
		 String wrkFirstNm = ExcelUtility.getCellData(16, 1);
		    String wrkLastNm = ExcelUtility.getCellData(16, 2);
		    String wrkPostcd = ExcelUtility.getCellData(16, 3);
		    String wrkNiNum = ExcelUtility.getCellData(16, 4);
		    workerspg.setWorkerFirstName(wrkFirstNm);
		    workerspg.setWorkerLastName(wrkLastNm);
		    workerspg.setWorkerPostcode(wrkPostcd);
		    workerspg.setWorkerNiNum(wrkNiNum);
		    workerspg.clickWorkersPageSearch();
		   // workerspg.clickWorkersPageEdit();
		    String expectedWorkersHeading=Constants.WORKERSPAGEHEADING;
			String actualWorkersHeading=workerspg.getHeading();
		    Assert.assertEquals(expectedWorkersHeading, actualWorkersHeading);
	}
	@Test(priority=9)
	public void verifyWorkersTableUpdateBtn() throws IOException
	{
		workerspg =new WorkersPage(driver);
		workerspg.clickWorkersPageEdit();
		//workerspg.clickUpdateWorkerPgNextbtn();
		
	}
	@Test(priority=10)
	public void verifyWorkersTableUpdateSaveBtn() throws IOException
	{
		workerspg =new WorkersPage(driver);
		//workerspg.clickWorkersPageEdit();
		workerspg.clickUpdateWorkerPgNextbtn();
		
	}
	
		
}
