package uTills;

import java.io.File;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		
		 String projectPath = System.getProperty("user.dir");
		ExcelIUtils excel = new ExcelIUtils(projectPath+"/excel/Anand2.xlsx", "EmpInfo");
		excel.getRowCount();
		excel.getCellDataNumeric(1, 1);
		excel.getCellDataString(0, 2);
	}

}
