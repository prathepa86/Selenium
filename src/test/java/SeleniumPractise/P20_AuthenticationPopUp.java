package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P20_AuthenticationPopUp {
	//Providing the username and password along with the url
	//Username and password:admin,should folllowed by@
	public static String sURL="https://admin:admin@the-internet.herokuapp.com/basic_auth";
	public static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		
	}

}
