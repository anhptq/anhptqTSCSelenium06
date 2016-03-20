package com.vsii.tsc.TSCSelenium06.Anhptq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement passwd;
	
	@FindBy(name="SubmitLogin")
	WebElement SubmitLogin;
	
	public void setDriver (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login (String e, String p) {
		signin.click();
		email.sendKeys(e);
	    passwd.sendKeys(p);
	    SubmitLogin.click();
	}
}
