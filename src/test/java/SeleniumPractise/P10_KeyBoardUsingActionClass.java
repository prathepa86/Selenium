package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P10_KeyBoardUsingActionClass {
	public static String sURL="https://text-compare.com/";
	public static WebDriver driver;
	
	//To copy the text from one text area to another text area
	//Command user->ctrl+A,ctrl+C,TAB->To move to another text area
	//ctrl+V->To paste the content
	
	
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Inspect first text area and pass the values using send keys
		driver.findElement(By.id("inputText1")).sendKeys("Hello All");
		
		//To select the text from the text area(ctrl+A)
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//To copy the content into the clipboard(ctrl+C)
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//To move to the another text area(TAB)
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//To paste the content ctrl+V
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		
		
	}

}
