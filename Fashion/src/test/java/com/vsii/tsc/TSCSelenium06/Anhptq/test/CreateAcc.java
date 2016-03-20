package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vsii.tsc.TSCSelenium06.Anhptq.pages.CreateAccPage;

public class CreateAcc extends TestBase {
	CreateAccPage acc = new CreateAccPage();
	
	//Case 3: Tao acc thanh cong
	@Test(priority=0,dataProvider = "CreateAccSuccess")
	public void CreateAccSuccess(String email, String customer_firstname, String customer_lastname,String passwd, String days, String months, String years,
			String firstname, String lastname, String company, String address1, String address2, String city,
			String id_state, String postcode, String id_country, String other, String phone, String phone_mobile,
			String alias) {
		driver.get(urlBase);
		acc.setDriver(driver);
		acc.preRegister(email);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		acc.Register(customer_firstname, customer_lastname, passwd, days, months, years, firstname, lastname,
				company, address1, address2, city, id_state, postcode, id_country, other, phone, phone_mobile, alias);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")),"MY ACCOUNT");
		acc.clickLogout();
	}
	
	//Case 4: Tao acc khong thanh cong
	@Test(priority=1,dataProvider = "CreateAccFail")
	public void CreateAccFail(String email, String customer_firstname, String customer_lastname,String passwd, String days, String months, String years,
			String firstname, String lastname, String company, String address1, String address2, String city,
			String id_state, String postcode, String id_country, String other, String phone, String phone_mobile,
			String alias) {
		driver.get(urlBase);
		acc.setDriver(driver);
		acc.preRegister(email);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		acc.Register(customer_firstname, customer_lastname, passwd, days, months, years, firstname, lastname,
				company, address1, address2, city, id_state, postcode, id_country, other, phone, phone_mobile, alias);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1")),"CREATE AN ACCOUNT");
		acc.clickLogout();
	}
}
