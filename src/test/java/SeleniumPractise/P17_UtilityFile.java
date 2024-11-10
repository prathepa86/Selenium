package SeleniumPractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P17_UtilityFile {
	
	public static FileInputStream oFis;
	public static FileOutputStream oFos;
	public static XSSFWorkbook oWorkbook;
	public static XSSFSheet oSheet;
	public static XSSFRow oRow;
	public static XSSFCell oCell;
	public static CellStyle style;
	
	
	public static int getRowNumber(String fileName,String sheetName) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(sheetName);
		int rowNumber=oSheet.getLastRowNum();		
		oWorkbook.close();
		oFis.close();
		return rowNumber;		
	}
	
	public static int getColNumber(String fileName,String sheetName,int rowNum) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(sheetName);
		oRow=oSheet.getRow(rowNum);
		int lastCellNum=oRow.getLastCellNum();
		oWorkbook.close();
		oFis.close();
		return lastCellNum;
			}
	public static String getCellData(String fileName,String sheetName,int rowNum,int cellNum) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(sheetName);
		oRow=oSheet.getRow(rowNum);
		oCell=oRow.getCell(cellNum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			//returns formatted value of a cell as a string irrespective of the cell type
			data=formatter.formatCellValue(oCell);
		}
		catch(Exception e) {
			data="";
		}
		return data;
	}
	
	public static void setCellData(String fileName,String sheetName,int rowNum,int cellNum,String data) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(sheetName);
		oRow=oSheet.getRow(rowNum);
		//We are writing the values in the existing row
		oCell=oRow.createCell(cellNum);
		oCell.setCellValue(data);
		oFos=new FileOutputStream(fileName);
		oWorkbook.write(oFos);
		oWorkbook.close();
		oFis.close();
		oFos.close(); 		
	}
	
	public static void fillGreenColor(String fileName,String SheetName,int rowNum,int cellNum) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(SheetName);
		oRow=oSheet.getRow(rowNum);
		oCell=oRow.getCell(cellNum);
		
		style=oWorkbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		oCell.setCellStyle(style);
		oFos=new FileOutputStream(fileName);
		oWorkbook.write(oFos);
		oWorkbook.close();
		oFis.close();
		oFos.close(); 
	}
	
	public static void fillRedColor(String fileName,String SheetName,int rowNum,int cellNum) throws IOException {
		oFis=new FileInputStream(fileName);
		oWorkbook=new XSSFWorkbook(oFis);
		oSheet=oWorkbook.getSheet(SheetName);
		oRow=oSheet.getRow(rowNum);
		oCell=oRow.getCell(cellNum);
		
		style=oWorkbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		oCell.setCellStyle(style);
		oFos=new FileOutputStream(fileName);
		oWorkbook.write(oFos);
		oWorkbook.close();
		oFis.close();
		oFos.close(); 
	}

}
