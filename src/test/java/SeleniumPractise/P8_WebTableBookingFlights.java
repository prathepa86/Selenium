package SeleniumPractise;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P8_WebTableBookingFlights {
	//Enter the departure and destination details,In the find flights page,
	//click on the flight which has a minimum amount 
	//Enter all the details,book the ticket and validate the message
	
	public static String sURL="https://www.blazedemo.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		WebElement departure,destination,find_Flights;
		departure=driver.findElement(By.xpath("//select[@name='fromPort']"));
		//To choose Departure City
		Select select_dep=new Select(departure);
		select_dep.selectByVisibleText("Mexico City");
		
		//To choose destination
		destination=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select select_dest=new Select(destination);
		select_dest.selectByVisibleText("New York");
		
		//Click on Find flights button
		find_Flights=driver.findElement(By.xpath("//input[@type='submit']"));
		find_Flights.click();
		
		//in Flights from Mexico to NewYork page
		//Retreiving only price column alone
		
	
		//Create an array to compare the values.For that convert the price string into double	
		
		List<WebElement> Rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		
		int RowSize=Rows.size();
		double[] newarr=new double[RowSize];
		for(int i=1;i<=RowSize;i++) 
			{			
				String price = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[6]")).getText();
				price=price.replace("$", "");
				double amount= Double.parseDouble(price);		
				newarr[i-1]=amount;
		}
		Arrays.sort(newarr);
		 String minVal=String.valueOf(newarr[0]);
		System.out.println(minVal);
		
		//Click on the flight which has a minimum value
		//Find the details contains minimum price
  for(int i=1;i<=RowSize;i++) {
	String price = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[6]")).getText();
	if(price.contains(minVal)){
		driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[1]")).click();
		break;
	}
}

//Booking the ticket
driver.findElement(By.id("inputName")).sendKeys("Prathepa Pasupathi");
driver.findElement(By.id("address")).sendKeys("Nanganallur");
driver.findElement(By.id("city")).sendKeys("Chennai");
driver.findElement(By.id("state")).sendKeys("TamilNadu");
WebElement cardtype=driver.findElement(By.id("cardType"));
Select select=new Select(cardtype);
select.selectByVisibleText("Visa");
driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");
driver.findElement(By.id("creditCardMonth")).sendKeys("12");
driver.findElement(By.id("creditCardYear")).sendKeys("2024");
driver.findElement(By.id("nameOnCard")).sendKeys("Preethi");
driver.findElement(By.id("rememberMe")).click();
driver.findElement(By.xpath("//input[@type='submit']")).click();

//Validate the message
String text=driver.findElement(By.xpath("//h1")).getText();
if(text.contains("Thank you for your purchase today!")) {
	System.out.println("Ticket is successfully booked");
}




		
		
				
				
				
		
		
		


	}

}
