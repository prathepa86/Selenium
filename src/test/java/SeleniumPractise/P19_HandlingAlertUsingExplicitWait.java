package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P19_HandlingAlertUsingExplicitWait {
	public static String sURL="https://the-internet.herokuapp.com/javascript_alerts";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get(sURL);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebDriverWait oWait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		 WebElement prompt_alert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));
		 prompt_alert.click();
		 
		 //It will wait until the alert is present and the return type is alert
		 Alert alert = oWait.until(ExpectedConditions.alertIsPresent());
		 System.out.println(alert.getText());
		 alert.sendKeys("Hello");
		 alert.accept();
		 driver.quit();
		
	     
		

	}

}
