package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P14_SSLHandling {
	public static String sURL="https://expired.badssl.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//By default it is False
		
		driver=new ChromeDriver(options);
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
		
		
	}

}
