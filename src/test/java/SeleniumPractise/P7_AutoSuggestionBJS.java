package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7_AutoSuggestionBJS {
	public static WebDriver driver;
	public static String sURL="https://www.bjs.com/";
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//Searchbox
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("samsung");
		
		
		//Identify the grouping locator
		List<WebElement> allValues = driver.findElements(By.xpath("//div[@class='list list-group']/div"));
        
		for(int i=0;i<allValues.size();i++) {
			System.out.println(allValues.get(i).getText());
			if(allValues.get(i).getText().equals("samsung tablet")) {
				allValues.get(i).click();
				break;
			}
			
		}
	
	}

}
