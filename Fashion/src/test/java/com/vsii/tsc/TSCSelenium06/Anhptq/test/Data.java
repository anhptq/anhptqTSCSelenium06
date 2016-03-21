package com.vsii.tsc.TSCSelenium06.Anhptq.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data {
	public static Object[][] getData(int sheetNumber) throws IOException {
		String[][] object = null;
		FileInputStream fileInputStream = new FileInputStream("./data/Data.xls");
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
	
	public static String[][] getTable(String filePath, String sheetName, String tableName) {
		String testData[][] = null;
		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row;
		Cell cell;
		String tagName = null;
		List<Cell> tagList = new ArrayList<Cell>();

		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;

		// Open file
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Define workbook
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Define sheet
		sheet = workbook.getSheet(sheetName);

		// Iterate through each row
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				// Check the cell type and format
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					tagName = cell.getStringCellValue();
				}

				if (tagName.equalsIgnoreCase(tableName)) {
					tagList.add(cell);
				}
			}
		}
		// Identify table
		if (tagList.size() == 2) {
			startRow = tagList.get(0).getRowIndex() + 1;
			startCol = tagList.get(0).getColumnIndex() + 1;
			endRow = tagList.get(1).getRowIndex() - 1;
			endCol = tagList.get(1).getColumnIndex() - 1;
		} else
			System.out.println("Wrong table");

		testData = new String[endRow - startRow + 1][endCol - startCol + 1];

		int x = 0;
		for (int i = startRow; i <= endRow; i++, x++) {
			int y = 0;
			for (int j = startCol; j <= endCol; j++, y++) {
				row = sheet.getRow(i);
				testData[x][y] = row.getCell(j).toString();
			}
		}
		return testData;
	}
	
	@DataProvider
	public static Object[][] dataRegisterSuccess() throws IOException {
		Object[][] object = getData(2);
		return object;
	}

	@DataProvider
	public static Object[][] dataRegisterFail() throws IOException {
		Object[][] object = getData(3);
		return object;
	}

	@DataProvider(name="loginSuccess")
	public static Object[][] LoginSucc() throws IOException {
		Object[][] object = getTable("./data/Data.xlsx", "LoginSuccess", "LoginPass");
		return object;
	}

	@DataProvider(name="loginFail")
	public static Object[][] LoginFail() throws IOException {
		Object[][] object = getTable("./data/Data.xlsx", "LoginFail", "LoginFail");
		return object;
	}
}
