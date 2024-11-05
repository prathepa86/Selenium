package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_DynamicPagination {
	public static WebDriver driver;
	public static String sURL="https://www.ecomdeveloper.com/demo/admin/index.php";


	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//To login into the application
		WebElement userName = driver.findElement(By.name("username"));
		userName.clear();
		userName.sendKeys("demoadmin");
		
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demopass");
		
		 
		WebElement Login=driver.findElement(By.xpath("//button[normalize-space(text()='Login')]"));
		Login.click();
		
		//Click on the Customer MainMenu
		WebElement customer_Main=driver.findElement(By.xpath("//a[@class='parent collapsed' and @href='#collapse9']"));
		customer_Main.click();
		
		//Click on the customer submenu
		WebElement customer_Sub=driver.findElement(By.xpath("(//ul[@id='collapse9']/li)[1]"));
		customer_Sub.click();
		
		//Retreiving text present in the bottom page to identify the no.of pages
		WebElement Pages=driver.findElement(By.xpath("//div[contains(text(),'Showing')]"));
		String text=Pages.getText();
		
		
		//Retrieving only the pages alone using substring method
		String substring = text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1);
		System.out.println("Total pages are :"+substring);
		
		//Converting String into number
		int total_pages=Integer.parseInt(substring);
		
		//Pages starts from 1
		for(int i=1;i<=total_pages;i++) {
			
			//By default FirstPage will be displayed.Making condition to click 
			//only if the page is greater than 1 to move to that respective page
		if(i>1) {
			driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+i+"']")).click();
				  }
		
		//retrieving all rows expect header
		List<WebElement> AllRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
		int size=AllRows.size();
		System.out.println("Row sizes are :"+size);
		
		//Row-0 is for header value starts from row1
	
		for(int row=1;row<=size;row++) {
			
			//Retreiving Email and status column value only
		String Email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+row+"]"+"/td[3]")).getText();
		String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+row+"]/td[5]")).getText();
		
		System.out.println(status+"\t"+Email);
		}
		
		
			
		}
		
	}

}
