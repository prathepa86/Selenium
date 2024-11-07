package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P10_keyboard {
	//To open the link in another tab using keyboard methods in action class
	//Use ctrl+giftIdeas link->It open the page in new tab(not in same page)
	//same as (Right click-open in new tab option)
	
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
		WebElement giftIdeas = driver.findElement(By.xpath("//a[contains(text(),'Gift Ideas')]"));
		//ctrl click(Register)
		action.keyDown(Keys.CONTROL).click(giftIdeas).keyUp(Keys.CONTROL).perform();
		
			
	}

}
