package TestNGPractise;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P1_OrangeHRMLoginPage {
	public static String sURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(priority=1)
	public void testLogo() {
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logo,false);
	}
	
	@Test(priority=2)
	public void getCurrentURL() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/web/index.php/login");
	}
	
	@Test(priority=3,dependsOnMethods ="getCurrentURL" )
	public void getTitle() {
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
