package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.testBase.TestBaseClass;

public class LoginPage extends TestBaseClass{
	
	@FindBy(xpath="//input[@type = \"text\" and @name=\"username\"]")
	WebElement userName;
	
	@FindBy(xpath="//input[@type = \"password\" and @name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\" and @value =\"Login\"]")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	@FindBy(xpath="//h1[contains(text(),'Power up your sales, customer service, and marketing')]")
	WebElement motto;
	
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public String validateMotto()
	{
		return motto.getText();
	}
	
	public HomePage Login(String uName, String pwd)
	{
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}

}
