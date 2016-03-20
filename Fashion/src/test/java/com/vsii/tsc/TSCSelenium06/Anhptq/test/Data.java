package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

public class Data {
	public static Object[][] getData(int sheetNumber) throws IOException {
		String[][] object = null;
		FileInputStream fileInputStream = new FileInputStream("./data/Data.xlsx");
		POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
		HSSFWorkbook workBook2 = new HSSFWorkbook(fsFileSystem);
		HSSFSheet sheet = workBook2.getSheetAt(sheetNumber);

		int totalNoOfCols = sheet.getRow(0).getLastCellNum();
		int totalNoOfRows = sheet.getPhysicalNumberOfRows();

		object = new String[totalNoOfRows - 1][totalNoOfCols];

		Iterator<Row> iterator = sheet.iterator();
//		Row row1 = iterator.next();
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
}
