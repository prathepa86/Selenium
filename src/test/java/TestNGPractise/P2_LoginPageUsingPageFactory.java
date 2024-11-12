package TestNGPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class P2_LoginPageUsingPageFactory {
	private WebDriver driver;
	
	public P2_LoginPageUsingPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(name="username")WebElement userName_Loc;
	@FindBy(name="password")WebElement password_Loc;
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	WebElement login_Loc;
	
	//Actions
	public P2_LoginPageUsingPageFactory setUsername(String userName) {
		userName_Loc.sendKeys(userName);
		return this;
	}
	
	public P2_LoginPageUsingPageFactory setPassword(String Password) {
		password_Loc.sendKeys(Password);
		return this;
	}
	
	public void clickLogin() {
		login_Loc.click();
	}

}
