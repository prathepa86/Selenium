package TestNGPractise;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class P2_LoginTest {
	 public WebDriver driver;
	 String sURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@org.testng.annotations.BeforeClass
	 public void setUp() {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	//Test method and Validation
	@Test
	public void testLogin() {
		new P2_LoginPage(driver)
		.setUsername("Admin")
		.setPassword("admin123")
		.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	
	}
	
	@AfterClass()
	public void tearUP() {
		driver.quit();
	}
	

}
