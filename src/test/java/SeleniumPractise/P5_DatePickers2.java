package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P5_DatePickers2 {
	public static String sURL="https://testautomationpractice.blogspot.com/";
	public static WebDriver driver;
	public static String date="20";

	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("txtDate")).click();
		
	    //Select class for Month 
		WebElement Month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth=new Select(Month);
		selectMonth.selectByVisibleText("Jul");
	    //Select class for  Year
		WebElement Year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear=new Select(Year);
		selectYear.selectByVisibleText("2014");
		//Select date using webtable concept
		
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		for(WebElement val:Dates) {
			if(val.getText().equals(date)) {
				val.click();
				break;
			}
		}
	
	}

}
