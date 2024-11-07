package SeleniumPractise;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class P11_NewWindow {
	public static String sURL="https://www.amazon.in/";
	public static WebDriver driver;
	

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//This will open in another tab and also switch the control to the new window
		driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
	
	
	
		
	}

}
