package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vsii.tsc.TSCSelenium06.Anhptq.pages.LoginPage;

public class Login extends TestBase {

	LoginPage log = new LoginPage();

	// Case 1: Login thanh cong
	@Test(priority = 0, dataProvider = "loginSuccess", dataProviderClass = Data.class)
	public void LoginSuccess(String email, String password) {
		log.login(email, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.linkText("Sign out")), "Sign out");
	}

	// Case 2: Login khong thanh cong
	@Test(priority = 1, dataProvider = "loginFail", dataProviderClass = Data.class)
	public void LoginFail(String email, String password) {
		driver.get(urlBase);
		log.setDriver(driver);
		log.login(email, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.linkText("Sign out")), "Sign in");
	}
}
