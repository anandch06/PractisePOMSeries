package uTills;


import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelIUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelIUtils(String excelPath, String sheetName){

		try {
			//projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumeric(1,0);
	}

	public static int getRowCount(){
		try{
//			projectPath = System.getProperty("user.dir");
//			workbook = new XSSFWorkbook(projectPath+"/excel/Anand2.xlsx");
//			sheet = workbook.getSheet("Emp Info");
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("Total no of rows : " + rowCount);
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return getRowCount();
	}
	public static int getColCount(){
		int colCount = 0;
		try{
//			projectPath = System.getProperty("user.dir");
//			workbook = new XSSFWorkbook(projectPath+"/excel/Anand2.xlsx");
//			sheet = workbook.getSheet("Emp Info");
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
					System.out.println("Total no of cells : " + colCount);
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}

	public static void getCellDataString(int rowNum, int colNum){
		try{
//			projectPath = System.getProperty("user.dir");
//			workbook = new XSSFWorkbook(projectPath+"/excel/Anand2.xlsx");
//			sheet = workbook.getSheet("Emp Info");
			String cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}


	public static void getCellDataNumeric(int rowNum, int colNum){		
		try{
//			projectPath = System.getProperty("user.dir");
//			workbook = new XSSFWorkbook(projectPath+"/excel/Anand2.xlsx");
//			sheet = workbook.getSheet("Emp Info");
			Double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);

		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}


	}


}
