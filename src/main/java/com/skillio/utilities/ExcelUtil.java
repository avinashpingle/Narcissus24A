package com.skillio.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class contains methods to read data from Excel files using Apache POI
 * library.
 * 
 * @author Avinash Pingale
 * Can you reduce the code duplication in this class?
 */
public abstract class ExcelUtil {

	/**
	 * This method reads data from an Excel file and stores it into 2D object array.
	 * "D:/excel files/test.xls"
	 */
	public static Object[][] readExcel(String filePath, String sheetName) {
		Object[][] data = null;
		Workbook book = null;
		Sheet sheet = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			String extension = filePath.split(".")[1];
			if (extension.equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			data = new Object[rows][cols];
			for (int row = 0; row < rows; row++) {
				Row r = sheet.getRow(row);
				for (int col = 0; col < cols; col++) {
					Cell cell = r.getCell(col);
					switch (cell.getCellType()) {
					case STRING:
						data[row][col] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[row][col] = cell.getNumericCellValue();
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
					}
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * This method reads data from an Excel file and stores it into 2D object array.
	 * start row and start column are given.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param startRow
	 * @param startCol
	 */
	public static Object[][] readExcel(String filePath, String sheetName, int startRow, int startCol) {
		FileInputStream fis = null;
		Workbook book = null;
		Sheet sheet = null;
		Object[][] obj = null;
		try {
			fis = new FileInputStream(filePath);
			String extension = filePath.split(".")[1];
			if (extension.equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			obj = new Object[rows - startRow][cols - startCol];
			for (int row = startRow; row < rows; row++) {
				Row r = sheet.getRow(row);
				for (int col = startCol; col < cols; col++) {
					Cell cell = r.getCell(col);
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
					}
				}
				System.out.println();
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (book != null) {
					book.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	/**
	 * This method reads a specific column from an Excel file and returns its values
	 * in 2D object array.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param columnNumber
	 */
	public static Object[][] readExcelColumn(String filePath, String sheetName, int columnNumber) {
		FileInputStream fis = null;
		Workbook book = null;
		Sheet sheet = null;
		Object[][] obj = null;
		try {
			fis = new FileInputStream(filePath);
			String extension = filePath.split(".")[1];
			if (extension.equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			obj = new Object[rows][1];
			for (int row = 0; row < rows; row++) {
				Row r = sheet.getRow(row);
				Cell cell = r.getCell(columnNumber);
				switch (cell.getCellType()) {
				case STRING:
					obj[row][0] = cell.getStringCellValue();
					break;
				case NUMERIC:
					obj[row][0] = cell.getNumericCellValue();
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (book != null) {
					book.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	/**
	 * This method reads a specific row from an Excel file and returns its values in
	 * 2D object array.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rowNumber
	 */
	public static Object[] readExcelRow(String filePath, String sheetName, int rowNumber) {
		FileInputStream fis = null;
		Workbook book = null;
		Sheet sheet = null;
		Object[] obj = null;
		try {
			fis = new FileInputStream(filePath);
			String extension = filePath.split(".")[1];
			if (extension.equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
			Row r = sheet.getRow(rowNumber);
			int cols = r.getLastCellNum();
			obj = new Object[cols];
			for (int col = 0; col < cols; col++) {
				Cell cell = r.getCell(col);
				switch (cell.getCellType()) {
				case STRING:
					obj[col] = cell.getStringCellValue();
					break;
				case NUMERIC:
					obj[col] = cell.getNumericCellValue();
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (book != null) {
					book.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	/**
	 * This method reads a specific row from an Excel file starting from a specific column.
	 * @param filePath
	 * @param sheetName
	 * @param rowNumber
	 * @param startCol
	 */
	public static Object[] readExcelRow(String filePath, String sheetName, int rowNumber, int startCol) {
		FileInputStream fis = null;
		Workbook book = null;
		Sheet sheet = null;
		Object[] obj = null;
		try {
			fis = new FileInputStream(filePath);
			String extension = filePath.split("\\.")[1];
			if (extension.equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
			Row r = sheet.getRow(rowNumber);
			obj = new Object[r.getLastCellNum()-startCol];
			int cols = r.getLastCellNum();
			for (int col = startCol; col < cols; col++) {
				Cell cell = r.getCell(col);
				switch (cell.getCellType()) {
				case STRING:
					obj[col-startCol] = cell.getStringCellValue();
					break;
				case NUMERIC:
					obj[col-startCol] = (int)cell.getNumericCellValue();
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (book != null) {
					book.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
