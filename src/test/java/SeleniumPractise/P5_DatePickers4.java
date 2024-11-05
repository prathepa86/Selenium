package SeleniumPractise;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_DatePickers4 {
	public static String sURL="https://testautomationpractice.blogspot.com/";
	public static WebDriver driver;
	public static String ExpMon="April";
	
	public static Month convertMonth(String month) {
		
		Map<String,Month> map=new HashMap<String,Month>();
		map.put("January", Month.JANUARY);
		map.put("February", Month.FEBRUARY);
		map.put("March", Month.MARCH);
		map.put("April", Month.APRIL);
		map.put("May", Month.MAY);
		map.put("June", Month.JUNE);
		map.put("July", Month.JULY);
		map.put("August", Month.AUGUST);
		map.put("September", Month.SEPTEMBER);
		map.put("October", Month.OCTOBER);
		map.put("November", Month.NOVEMBER);
		map.put("December", Month.DECEMBER);
		
		Month value = map.get(month);
		
		return value;
		
	}

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("datepicker")).click();
		while(true) {
		String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		Month currentMonthObj = convertMonth(currentMonth);
		Month ExpMonthObj = convertMonth(ExpMon);
		
		//Click on previous arrowmark
		if(ExpMonthObj.compareTo(currentMonthObj)<0) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
		}else if(ExpMonthObj.compareTo(currentMonthObj)>0) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}else{
			break;
		}
		
		
	}
	}

}
