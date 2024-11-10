package SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P21_Checkbox {
	public static String sURL="https://testautomationpractice.blogspot.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//1.To select specific checkbox
		driver.findElement(By.id("tuesday")).click();
		
		//2.To select all the checkboxes
		
		  List<WebElement> checkboxes=driver.findElements(By.
		  xpath("//input[@class='form-check-input' and @type='checkbox']"));
		  
		  for(int i=0;i<checkboxes.size();i++) 
		  { checkboxes.get(i).click();
		  }
		 
		
		//3.Select Checkboxes based on specific condition
		//Select only the last three checkboxes(3)
	 //Starting index=Total no of checkboxes(7)-(3)select no of checkboxes want to select
		
		  for(int i=4;i<checkboxes.size();i++)
		  { checkboxes.get(i).click();
		  }
		 
		  
		//4.To select only first 3 checkboxes
		
		  for(int i=0;i<3;i++) { checkboxes.get(i).click(); }
		 
		  
	//5. Uncheck only the selected checkboxes	  
		  
		  for(int i=0;i<3;i++) {
			  checkboxes.get(i).click();
		  }
		  for(int i=0;i<checkboxes.size();i++) {
			  if(checkboxes.get(i).isSelected()) {
				  checkboxes.get(i).click();
			  }
		  }
	}

}
