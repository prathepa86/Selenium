package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P22_Frames {
	public static String sURL="https://ui.vision/demo/webtest/frames/";
	public static WebDriver driver;
	
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//1.Frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");	
		
		//To switch from frame1 to Main page
		driver.switchTo().defaultContent();
		//2.To switch from MainPage to frame2
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		//To interact with the text box
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Java");
		
		//To switch from frame2 to Main page
		driver.switchTo().defaultContent();
		//3.To switch from MainPage to Frame3
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		//To interact with the text box
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
		
		//To move to nested frame from frame3
		//Using index here beacuse there is only one frame inside frame3
		driver.switchTo().frame(0);
		//click on the radio button
		WebElement radioBtn = driver.findElement(By.xpath("//div[@id='i6']"));
		radioBtn.click();
		
		//To switch from nested iframe in frame3 to Main page
		driver.switchTo().defaultContent();
		
		//To switch from mainpage to frame5
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("TestNG");
		driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();
		
		WebElement logo=driver.findElement(By.xpath("//a[@id='logo']"));
		if(logo.isDisplayed()) {
			System.out.println("Logo is successfully displayed");
		}
			

	}

}
