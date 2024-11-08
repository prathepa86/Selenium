package SeleniumPractise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P16_WriteDataIntoExcel {

	public static void main(String[] args) throws IOException {
		//This will create file 
		File file=new File(System.getProperty("user.dir")+"/testdata/writedata.xlsx");
FileOutputStream oFos=new FileOutputStream(file);
XSSFWorkbook oWorkbook=new XSSFWorkbook();
XSSFSheet oSheet = oWorkbook.createSheet("data");
XSSFRow row1 = oSheet.createRow(0);
row1.createCell(0).setCellValue("Selenium");
row1.createCell(1).setCellValue(15000);
row1.createCell(2).setCellValue("Automation");

XSSFRow row2 = oSheet.createRow(1);
row2.createCell(0).setCellValue("Postman");
row2.createCell(1).setCellValue("16000");
row2.createCell(2).setCellValue("Manual");

XSSFRow row3=oSheet.createRow(2);
row3.createCell(0).setCellValue("RestAssured");
row3.createCell(1).setCellValue("16000");
row3.createCell(2).setCellValue("Automation");


//To attach workbook to FileOutputStream
oWorkbook.write(oFos);
oWorkbook.close();
oFos.close();
System.out.println("File is created");

	}

}
