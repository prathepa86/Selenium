package SeleniumPractise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_TakesScreenShot {
	public static String sURL="https://www.amazon.in/";
	public static WebDriver driver;
	
	public static void FullScreenShot() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("makeup",Keys.ENTER);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/screenshot/Full.png");
		source.renameTo(dest);
	
	}
	
	public static void CaptureSpecificSection() {
		WebElement SpecificSection = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']"));
		File source = SpecificSection.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screenshot/oneitem.png");
		source.renameTo(target);
	}
	
	public static void captureWebElement() {
		WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
		TakesScreenshot ts=(TakesScreenshot)logo;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/screenshot/AmazonLogo.png");
		source.renameTo(dest);
	}

	public static void main(String[] args) throws IOException {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		FullScreenShot();
		CaptureSpecificSection();
		captureWebElement();
		driver.quit();
		
		
		
		

	}

}
