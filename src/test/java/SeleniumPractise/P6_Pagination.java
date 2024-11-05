package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_Pagination {
	public static WebDriver driver;
	public static String sURL="https://testautomationpractice.blogspot.com/";

	public static void main(String[] args) {

		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//To get all the pages
		List<WebElement> Pages = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
	    int size = Pages.size();
	    System.out.println("Total sizes are:"+size);
	    for(int i=1;i<=size;i++) {
	    	if(i>1) {
	    		//Click from page2 onwards
	    		driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
	    	}
	    	//Get all the rows
	    	int rowSize = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
	    	for(int j=1;j<=rowSize;j++) {
	    		String ID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[1]")).getText();
	    		String Name=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[2]")).getText();
	    		String Price=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[3]")).getText();
	    		driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td/input[@type='checkbox']")).click();
	    	System.out.println(ID+"\t"+Name+"\t"+Price);
	    	}
	    	}
    }
	}


