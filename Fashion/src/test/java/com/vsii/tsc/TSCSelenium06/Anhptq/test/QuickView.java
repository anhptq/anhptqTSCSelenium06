package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vsii.tsc.TSCSelenium06.Anhptq.pages.QuickViewPage;

public class QuickView extends TestBase {
	QuickViewPage view = new QuickViewPage();
	
	@Test
	public void view()
	{
		driver.get(urlBase);
		view.setDriver(driver);
		view.viewQuick();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		// get all window handles
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		// switch to popup window
		driver.switchTo().window(subWindowHandler); 
		// perform operations on popup
		Assert.assertEquals(driver.findElement(By.id("wishlist_button")), "Add to wishlist ");                                            

	}
}
