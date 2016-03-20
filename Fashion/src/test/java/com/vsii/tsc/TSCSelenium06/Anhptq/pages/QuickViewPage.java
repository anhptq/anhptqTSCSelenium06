package com.vsii.tsc.TSCSelenium06.Anhptq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickViewPage {
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div")
	WebElement product_container;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[2]")
	WebElement quick_view;
	
	@FindBy(id= "bigpic")
	WebElement bigpic;
	
	@FindBy(id= "wishlist_button")
	WebElement wishlist_button;	
	
	public void setDriver (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void  viewImg() {
		bigpic.click();
	}
	
	public void  viewQuick() {
		Actions actions = new Actions(driver);
		actions.moveToElement(product_container);

		actions.moveToElement(quick_view);
		actions.click().build().perform();
	}
	
}
