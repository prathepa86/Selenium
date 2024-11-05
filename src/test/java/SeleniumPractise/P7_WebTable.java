package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7_WebTable {
	public static WebDriver driver;
	public static String sURL="https://www.google.com/";

	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//username
		WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.sendKeys("Selenium");
        Thread.sleep(2000);
        List<WebElement> allValues = driver.findElements(By.xpath("//ul/li[@data-attrid='AutocompletePrediction']/div/div[2]/div[@role='option']"));
		
        for(int i=0;i<allValues.size();i++) {
        	System.out.println(allValues.get(i).getText());
        	if(allValues.get(i).getText().equals("selenium")){
        		allValues.get(i).click();
        		break;
        	}
        	
        }
        
	}

}
