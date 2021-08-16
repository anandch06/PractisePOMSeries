package com.qa.hupspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static Workbook book;
	private static Sheet sheet;

	public static String Test_Data_Sheet_Path = "./src/main/java/com/qa/hubspot/testdata/TutorialsNinjaTestData.xlsx";

	public static Object[][] getTestData(String sheetName){
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(Test_Data_Sheet_Path);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++){
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
					data[i][j] = sheet.getRow(i+1).getCell(0).toString();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}



}
