package SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class P4_Shadow {
	public static String sURL="https://dev.automationtesting.in/shadow-dom";
	public static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//1. Shadow element
		String ShadowElement = driver.findElement(By.cssSelector("div#shadow-root"))
		.getShadowRoot().findElement(By.cssSelector("span#shadow-element")).getText();
		
		System.out.println("1.Shadow Element text is:"+ShadowElement);
		
		//2.Nested Shadow Element
		
		String NestedShadow = driver.findElement(By.cssSelector("div#shadow-root"))
		.getShadowRoot().findElement(By.cssSelector("inner-shadow-dom#inner-shadow-dom"))
		.getShadowRoot().findElement(By.cssSelector("span#nested-shadow-element")).getText();
		
        System.out.println("2.Nested shadow element is:"+NestedShadow);
	}

}
