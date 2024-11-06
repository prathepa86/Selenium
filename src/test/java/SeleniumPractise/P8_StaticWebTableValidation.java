package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P8_StaticWebTableValidation {

	public static String sURL="https://testautomationpractice.blogspot.com/";
	public static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		
		//We are using header to find out the column size
		List<WebElement>allCol=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
		//Rows include header
		int RowSize=allRows.size();
		int ColSize=allCol.size();
		System.out.println("Row size is:"+RowSize);
		System.out.println("Col size is:"+ColSize);
		
		
		//1.To retreive specific data from 5throw and 1st col
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[5]/td[1]")).getText();
		System.out.println("bookName is:"+bookName);
		
		//2.To retrieve the Java script present in the lastrow
		String subject = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[7]/td[3]")).getText();
		System.out.println("subject name is:"+subject);
		
		//3.To print all the values
		//Starts the index from 2 to exclude header
		for(int i=2;i<=RowSize;i++) {
			for(int j=1;j<=ColSize;j++) {
				String val = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.print(val+"\t");
			}
			//New Line after each row
			System.out.println("");
			
		}
		
		System.out.println("****To print all values****");
		//3.Another way using for each 
		for(int i=2;i<=RowSize;i++) {
			List<WebElement> allCols = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td"));
		for(WebElement Col: allCols) {
			System.out.print(Col.getText()+"\t");
		}
		System.out.println("");
		}
		
		System.out.println("**To print only the bookes written by author Mukesh**");
		
		//4.To print the books written by Mukesh
		for(int i=2;i<=RowSize;i++) {
			List<WebElement> Rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]"));
		
			for(WebElement row:Rows) {
				List<WebElement> Cols = row.findElements(By.xpath("./td"));
				for(WebElement col:Cols) {
					
					if(col.getText().equals("Mukesh")) {
					String books_Written = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[1]")).getText();
					System.out.print(books_Written+"\t");
					}
				}
			}
		}
		
		//4.Retrieving only the author column,get the book written by Amit
		System.out.println("******To print the books written by Amit*******");
		for(int i=2;i<=RowSize;i++) {
			String author_name = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[2]")).getText();
		if(author_name.equals("Amit")) {
			String book_name=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[1]")).getText();
		System.out.print(book_name+"\t");
		}
		}
		
		
		//5.To capture prices for all the books
		System.out.println("**To calculate amount for all books**");
		int total=0;
		for(int i=2;i<=RowSize;i++) {
			
			String Price_of_EachBook = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[4]")).getText();
		  int amount=Integer.parseInt(Price_of_EachBook);
		  total=total+amount;
		
		
		}
		System.out.println("The total amount is:"+total);
		driver.quit();
		
		

	}

}
