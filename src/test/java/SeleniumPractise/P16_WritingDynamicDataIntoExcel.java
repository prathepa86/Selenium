package SeleniumPractise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P16_WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		File file=new File(System.getProperty("user.dir")+"/testdata/dynamicdata.xlsx");
		FileOutputStream oFos=new FileOutputStream(file);
		XSSFWorkbook oWorkbook=new XSSFWorkbook();
		XSSFSheet oSheet=oWorkbook.createSheet("data");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int NoOfRows=scanner.nextInt();
		System.out.println("Enter the number of cells");
		int numberOfCells=scanner.nextInt();
		for(int i=0;i<=NoOfRows;i++) {
			XSSFRow oRow=oSheet.createRow(i);
			for(int j=0;j<numberOfCells;j++) {
				oRow.createCell(j).setCellValue(scanner.next());
			}
		}
		oWorkbook.write(oFos);
		oWorkbook.close();
		oFos.close();
		
		System.out.println("File is created");
		scanner.close();
		
		
	}

}
