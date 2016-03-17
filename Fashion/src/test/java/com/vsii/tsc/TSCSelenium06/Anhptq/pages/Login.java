package com.vsii.tsc.TSCSelenium06.Anhptq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement login;
	
	public Login (WebDriver driver) {
		this.driver = driver;
	}
	
	public void login (String u, String p) {
	    userName.sendKeys(u);
	    password.sendKeys(p);
	    login.click();
	}
}
