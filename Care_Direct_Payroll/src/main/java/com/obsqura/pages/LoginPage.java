package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utility.PageUtility;

public class LoginPage {

	WebDriver driver;
	PageUtility pageUtil=new PageUtility();
	
	
	@FindBy(id="loginform-username")
    private WebElement payRollUsername;
	
	@FindBy(id="loginform-password")
    private WebElement payRollPassword;
	
	@FindBy(name="login-button")
    private WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Incorrect username or password.']")
	private WebElement loginErrorMessage;
	
	public LoginPage(WebDriver driver){
	    this.driver = driver;
	    //This initElements method will create all WebElements
	    PageFactory.initElements(driver, this);
	}
	
	//Set user name in textbox
    public void setUserName(String strUserName){
    	payRollUsername.clear();
    	payRollUsername.sendKeys(strUserName);     
    }
    //Set password in password textbox
    public void setPassword(String strPassword){
    	payRollPassword.clear();
    	payRollPassword.sendKeys(strPassword);
    }
    //Click on login button
    public void clickLogin(){
    	loginButton.click();
    	//pageUtil.elementClick(driver, loginButton);
    }
    public String getInvalidLogErrorMessage()
    {
    	
    	return loginErrorMessage.getText();
    }
}
