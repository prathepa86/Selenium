package SeleniumPractise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P11_WindowHandling {
	public static String sURL="https://www.amazon.in/";
	public static WebDriver driver;
	
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Action class
	Actions action=new Actions(driver);
	WebElement BestSellers = driver.findElement(By.xpath("//a[text()='Best Sellers']"));
				//ctrl click(Register)
	action.keyDown(Keys.CONTROL).click(BestSellers).keyUp(Keys.CONTROL).perform();
	
	//driver.getwindowhandles return all the ids.Usin ArrayList we are
	//converting Set<String> to List<String> and to use get method
	List<String> ids = new ArrayList<String>(driver.getWindowHandles());
	
	//To switch the control to BestSellers page
	driver.switchTo().window(ids.get(1));
	
	List<WebElement> AllWatches = driver.findElements(By.xpath("//li[@class='a-carousel-card']"));
	AllWatches.get(0).click();
	//To switch to the home page
	driver.switchTo().window(ids.get(0));
	WebElement search=driver.findElement(By.xpath("//input[@name='field-keywords']"));
	search.sendKeys("new collections",Keys.ENTER);
				
	
	}

}
