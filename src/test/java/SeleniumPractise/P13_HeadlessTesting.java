package SeleniumPractise;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P13_HeadlessTesting {
	public static String sURL="https://www.google.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		driver=new ChromeDriver(options);
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
		
		
	}

}
