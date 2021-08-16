package uTills;

public class ExceldataProvider {
	
	public void testData(String excelPath, String sheetName){
		
		ExcelIUtils excel = new ExcelIUtils(excelPath, sheetName);
		int colCount=excel.getColCount();
		int rowCount=excel.getRowCount();
	}

}
