package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.vsii.tsc.TSCSelenium06.Anhptq.methods.ReadProperties;

public class TestBase {

	public static Properties p;
	public static WebDriver driver;
	public String browser;
	public String urlBase;
	public static String runLocal;

	@BeforeSuite
	public void beforeClass() throws IOException {
		p = ReadProperties.readConfig();
		browser = p.getProperty("browserName");		
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		urlBase = p.getProperty("base_url");
		driver.get(urlBase);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		 driver.quit();
	}
}
