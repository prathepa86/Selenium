package TestNGPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_LoginPage {
	private WebDriver driver;
	
	//Constructor to initiate the driver
	public P2_LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//WebElements
	By userName_Loc=By.name("username");
	By password_Loc=By.name("password");
	By Login_Loc=By.xpath("//button[@type='submit']");
	
	//Actions
	public P2_LoginPage setUsername(String UserName) {
		driver.findElement(userName_Loc).sendKeys(UserName);
		return this;
	}
	public P2_LoginPage setPassword(String password) {
		driver.findElement(password_Loc).sendKeys(password);
		return this;
	}
	public void clickLogin() {
		driver.findElement(Login_Loc).click();
	}

}
