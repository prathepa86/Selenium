package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ShadowDom {
	
	public static String sURL="https://books-pwakit.appspot.com/";
	public static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"))
		.getShadowRoot().findElement(By.cssSelector("input#input"))
		.sendKeys("Hello");
		
			}

}
