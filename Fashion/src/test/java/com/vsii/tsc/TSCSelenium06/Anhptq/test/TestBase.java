package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
	
	public static Properties p;
	public static WebDriver driver;
	public static String urlBase;
	public static String runLocal;
	
	public Properties readConfig() throws IOException {
	// Create new properties variable
//	Properties p = new Properties();
	// Read object properties file
	InputStream stream = new FileInputStream("./properties/config.properties");
	// Load input stream file
	p.load(stream);
	return p;
	}
	
	
	@BeforeSuite
	public void beforeClass() throws IOException {
		String browser = p.getProperty("browserName");
		urlBase=p.getProperty("base_url");
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("chrome")) {
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
	}
	

	@AfterSuite
	public void tearDown() throws Exception {
		// driver.quit();
	}
}
