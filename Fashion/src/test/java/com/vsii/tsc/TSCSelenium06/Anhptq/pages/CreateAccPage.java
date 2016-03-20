package com.vsii.tsc.TSCSelenium06.Anhptq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(id = "email_create")
	WebElement email_create;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;

	@FindBy(id = "id_gender1")
	WebElement id_gender1;

	@FindBy(id = "id_gender2")
	WebElement id_gender2;

	@FindBy(id = "customer_firstname")
	WebElement customer_firstname;

	@FindBy(id = "customer_lastname")
	WebElement customer_lastname;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "newsletter")
	WebElement newsletter;

	@FindBy(id = "optin")
	WebElement optin;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement id_state;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "id_country")
	WebElement id_country;

	@FindBy(id = "other")
	WebElement other;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	@FindBy(id = "alias")
	WebElement alias;

	@FindBy(id = "submitAccount")
	WebElement submitAccount;
	
	@FindBy(xpath="/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmail_create(String email_create) {
		this.email_create.sendKeys(email_create);
	}

	public void clickSubmitCreate() {
		this.SubmitCreate.click();
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPasswd(String passwd) {
		this.passwd.sendKeys(passwd);
	}

	public void clickSubmitLogin() {
		this.SubmitLogin.click();
	}

	public void setId_gender1() {
		this.id_gender1.click();
	}

	public void setId_gender2() {
		this.id_gender2.click();
	}

	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname.sendKeys(customer_firstname);
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname.sendKeys(customer_lastname);
	}

	public void setDays(String days) {
		new Select(this.days).selectByValue(days);;
	}

	public void setMonths(String months) {
		new Select(this.months).selectByValue(months);
	}

	public void setYears(String years) {
		new Select(this.years).selectByValue(years);
	}

	public void setNewsletter() {
		this.newsletter.click();
	}

	public void setOptin() {
		this.optin.click();
	}

	public void setFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}

	public void setLastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}

	public void setCompany(String company) {
		this.company.sendKeys(company);
	}

	public void setAddress1(String address1) {
		this.address1.sendKeys(address1);
	}

	public void setAddress2(String address2) {
		this.address2.sendKeys(address2);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setId_state(String id_state) {
		new Select(this.id_state).selectByValue(id_state);
	}

	public void setPostcode(String postcode) {
		this.postcode.sendKeys(postcode);
	}

	public void setId_country(String id_country) {
		new Select(this.id_country).selectByValue(id_country);
	}

	public void setOther(String other) {
		this.other.sendKeys(other);
	}

	public void setPhone(String phone) {
		this.phone.sendKeys(phone);
	}

	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile.sendKeys(phone_mobile);
	}

	public void setAlias(String alias) {
		this.alias.clear();
		this.alias.sendKeys(alias);
	}

	public void clickSubmitAccount() {
		this.submitAccount.click();
	}

	public void preRegister(String email_create) {
		this.setEmail_create(email_create);
		this.clickSubmitCreate();
	}

	public void Register(String customer_firstname, String customer_lastname,String passwd, String days, String months, String years,
			String firstname, String lastname, String company, String address1, String address2, String city,
			String id_state, String postcode, String id_country, String other, String phone, String phone_mobile,
			String alias) {
		setId_gender1();
		setCustomer_firstname(customer_firstname);
		setCustomer_lastname(customer_lastname);
		setPasswd(passwd);
		setDays(days);
		setMonths(months);
		setYears(years);
		setNewsletter();
		setFirstname(firstname);
		setLastname(lastname);
		setCompany(company);
		setAddress1(address1);
		setAddress2(address2);
		setCity(city);
		setId_state(id_state);
		setPostcode(postcode);
		setId_country(id_country);
		setOther(other);
		setPhone(phone);
		setPhone_mobile(phone_mobile);
		setAlias(alias);
		clickSubmitAccount();
	}
	
	public void clickLogout() {
		this.logout.click();
		
	}
}
