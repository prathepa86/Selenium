package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P19_Alert {
	public static String sURL="https://the-internet.herokuapp.com/javascript_alerts";
	public static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//1.Simple alert
		WebElement simple = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']"));
	    simple.click();
	    driver.switchTo().alert().accept();
	    
	    //2.Confirmation alert
	    WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']"));
       confirm.click();
       driver.switchTo().alert().dismiss();
       
       //3.Prompt alert
       WebElement prompt_alert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));
       prompt_alert.click();
       Alert alert = driver.switchTo().alert();
       System.out.println(alert.getText());
       alert.sendKeys("Welcome");
       alert.accept();
       
       driver.quit();
       
	}

}
