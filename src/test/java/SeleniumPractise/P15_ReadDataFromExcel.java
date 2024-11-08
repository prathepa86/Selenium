package SeleniumPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P15_ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		File file=new File(System.getProperty("user.dir")+"/testdata/data.xlsx");
		FileInputStream oFis=new FileInputStream(file);
		XSSFWorkbook oWorkbook=new XSSFWorkbook(oFis);
		XSSFSheet oSheet = oWorkbook.getSheet("values");
		int lastRowNum = oSheet.getLastRowNum();
		short lastCellNum = oSheet.getRow(0).getLastCellNum();
		System.out.println("Rows :"+lastRowNum);
		//Rows values are 5 excluding header
		System.out.println("Cells:"+lastCellNum);
		//Cell values are 4,starts from 1
		
		//Outer for loop for Rows
		for(int i=0;i<=lastRowNum;i++) {
			//Fetching one rows at a time
			XSSFRow oRow = oSheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				//Fetching cell values for every row
				XSSFCell cell = oRow.getCell(j);
				String Value = cell.toString();
				System.out.print(Value+"\t");				
			}
			System.out.println();			
		}
		oWorkbook.close();
		oFis.close();

	}

}
