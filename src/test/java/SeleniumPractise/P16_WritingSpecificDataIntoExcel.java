package SeleniumPractise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P16_WritingSpecificDataIntoExcel {

	public static void main(String[] args) throws IOException {
		File file=new File(System.getProperty("user.dir")+"/testdata/specificData.xlsx");
		FileOutputStream oFos=new FileOutputStream(file);
		XSSFWorkbook oWorkbook=new XSSFWorkbook();
		XSSFSheet oSheet=oWorkbook.createSheet("data");
		//Index starts from 0,So it will generate 4 rows
		XSSFRow oRow=oSheet.createRow(3);
		//index starts from 0,It will set the value 3rd column
		oRow.createCell(2).setCellValue("Completed");
		oWorkbook.write(oFos);
		oWorkbook.close();
		oFos.close();
		System.out.println("File is created");
		
		

	}

}
