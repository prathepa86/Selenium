package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P9_Sliders {
	public static String sURL="https://www.tutorialspoint.com/selenium/practice/slider.php";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement min_slider = driver.findElement(By.id("ageInputId"));
		
		Actions actions=new Actions(driver);
		System.out.println("Before moving the minimum slider"+min_slider.getLocation());
		//(380, 193)
		
		actions.dragAndDropBy(min_slider, 100, 0).perform();
		System.out.println("After moving the minimum slider"+min_slider.getLocation());
		//(582, 204)
	}

}
