package com.inetBanking.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtils {

	@DataProvider(name = "Exceldata")
	public Object[][] excelDataprovider() {
		Object[][] arrObj = getExcelDtaStream("C:\\Users\\Admin\\eclipse-workspace\\inetBankingV2\\Data1.xlsx", "data");
		return arrObj;
	}

	public String[][] getExcelDtaStream(String filename, String sheetname) {
		String[][] data = null;
		try (FileInputStream fs = new FileInputStream(filename); XSSFWorkbook wb = new XSSFWorkbook(fs)) {

			// Print available sheet names
			int numberOfSheets = wb.getNumberOfSheets();
			System.out.println("Number of sheets: " + numberOfSheets);
			for (int i = 0; i < numberOfSheets; i++) {
				System.out.println("Sheet " + (i + 1) + ": " + wb.getSheetName(i));
			}

			Sheet sheet = wb.getSheet(sheetname);
			if (sheet == null) {
				System.out.println("Sheet " + sheetname + " not found in " + filename);
				return new String[0][0];
			}

			Row row = sheet.getRow(0);
			if (row == null) {
				System.out.println("First row is null in sheet " + sheetname);
				return new String[0][0];
			}

			int numRows = sheet.getPhysicalNumberOfRows();
			int numCols = row.getLastCellNum();

			data = new String[numRows - 1][numCols];
			for (int i = 1; i < numRows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					for (int j = 0; j < numCols; j++) {
						Cell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellType()) {
							case STRING:
								data[i - 1][j] = cell.getStringCellValue();
								break;
							case NUMERIC:
								data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
								break;
							case BOOLEAN:
								data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
								break;
							default:
								data[i - 1][j] = "";
							}
						} else {
							data[i - 1][j] = "";
						}
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
}