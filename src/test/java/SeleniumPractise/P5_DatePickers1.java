package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_DatePickers1
{
	public static String sURL="https://jqueryui.com/datepicker/";
    public static WebDriver driver;
    public static String ExpDate,ExpYear,ExpMon;
    
    public static void PastDate(String Date,String Mon,String Year ) {
    	
    	
    	//To select Date and Month
   while(true) {
	
	//To get Dynamic Current month and year
	String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
    String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
    if(currentMonth.equalsIgnoreCase(Mon) && currentYear.equalsIgnoreCase(Year)) {
    	break;
    }
    //To click on previous arrowmark
    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

              }
   //*******while loop end here**********
   
    //To get the date->Use Webtable concept
    List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
    //Iterating using ForEach and comparing the date with Expected date
    for(WebElement eachDate:AllDates) {
    	if(eachDate.getText().equals(Date)) {
    		eachDate.click();
    		break;
    	}
    }
   	
    }
    
  public static void FutureDate(String Date,String Mon,String Year ) {
    	
    	
    	//To select Date and Month
   while(true) {
	
	//To get Dynamic Current month and year
	String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
    String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
    if(currentMonth.equalsIgnoreCase(Mon) && currentYear.equalsIgnoreCase(Year)) {
    	break;
    }
    //To click on next arrowmark
    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

              }
   //*******while loop end here**********
   
    //To get the date->Use Webtable concept
    List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
    //Iterating using ForEach and comparing the date with Expected date
    for(WebElement eachDate:AllDates) {
    	if(eachDate.getText().equals(Date)) {
    		eachDate.click();
    		break;
    	}
    }
   	
    }
    
    
    
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ExpDate="30";
		ExpYear="2010";
		ExpMon="August";
		//To switch to the frame
		driver.switchTo().frame(0);
		//To click on the input box
	 driver.findElement(By.id("datepicker")).click();
		//PastDate(ExpDate,ExpMon,ExpYear);
		FutureDate("23","May","2025");
		

}
}
