package com.inetBanking.Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SetDeta {

	public static void main(String[] args) {
		// Define the data
		String[][] data = { { "username", "password" }, { "user1", "pass1" }, { "user1", "pass2" },
				{ "surajrt123456@gmail.com", "Sooraj@321" } };

		// Create a new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a sheet in the workbook
		Sheet sheet = workbook.createSheet("data");

		// Loop through the data array and create rows and cells
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < data[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}

		// Write the workbook to a file
		try (FileOutputStream fileOut = new FileOutputStream("Data1.xlsx")) {
			workbook.write(fileOut);
			System.out.println("Excel file created successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
