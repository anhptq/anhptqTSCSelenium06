package com.vsii.tsc.TSCSelenium06.Anhptq.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;



public class TestBase {
	
	public static Properties p;
	public static WebDriver driver;
	public static String urlBase;
	public static String runLocal;
	
	public static Properties readConfig() throws IOException {
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
	
	public static Object[][] getData(int sheetNumber) throws IOException {
		String[][] object = null;
		FileInputStream fileInputStream = new FileInputStream("./Data/data.xls");
		POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
		HSSFWorkbook workBook2 = new HSSFWorkbook(fsFileSystem);
		HSSFSheet sheet = workBook2.getSheetAt(sheetNumber);

		int totalNoOfCols = sheet.getRow(0).getLastCellNum();
		int totalNoOfRows = sheet.getPhysicalNumberOfRows();

		object = new String[totalNoOfRows - 1][totalNoOfCols];

		Iterator<Row> iterator = sheet.iterator();
		Row row1 = iterator.next();
		for (int i = 0; i < totalNoOfRows - 1; i++) {
			Row row2 = iterator.next();
			for (int j = 0; j < totalNoOfCols; j++) {
				if (row2.getCell(j) != null)
					object[i][j] = row2.getCell(j).toString();
				else
					object[i][j] = "";
			}
		}
		workBook2.close();
		return object;
	}
	
	@DataProvider
	public static Object[][] dataRegisterSuccess() throws IOException {
		Object[][] object = getData(0);
		return object;
	}

	@DataProvider
	public static Object[][] dataRegisterFail() throws IOException {
		Object[][] object = getData(1);
		return object;
	}

	@DataProvider
	public static Object[][] LoginSucc() throws IOException {
		Object[][] object = getData(2);
		return object;
	}

	@DataProvider
	public static Object[][] LoginFail() throws IOException {
		Object[][] object = getData(3);
		return object;
	}

	@AfterSuite
	public void tearDown() throws Exception {
		// driver.quit();
	}
}
