package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_DatePickers3 {
	public static String sURL="https://testautomationpractice.blogspot.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("start-date")).sendKeys("23-05-1986");
		driver.findElement(By.id("end-date")).sendKeys("04-11-2024");
		driver.findElement(By.xpath("//button[@class='submit-btn']")).click();
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
	}

}
