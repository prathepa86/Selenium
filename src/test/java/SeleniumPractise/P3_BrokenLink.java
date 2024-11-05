package SeleniumPractise;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_BrokenLink {
	public static String sURL="http://www.deadlinkcity.com/";
	public static WebDriver driver;

	public static void main(String[] args) {
 
		//Identifying the number of broken links
		int broken=0;
		WebDriver driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//Retreiving the total number of links
		System.out.println("The total number of links is:"+links.size());
		
		
		for(WebElement link:links) {
			String attrVal = link.getAttribute("href");
			//If there is not value for href and then dont continue the current iteration
			if(attrVal==null||attrVal.isEmpty()) {
				System.out.println("They dont have attribute value.we cant find whether it is broken link or not");
				continue;
			}
			try {
				
				//Url is a class in java.net package
				URL url=new URL(attrVal);
				//Establishing the connection and typecasting it to HttpUrl connection
				HttpURLConnection Conn = (HttpURLConnection) url.openConnection();
				//Connect to the server
				Conn.connect();
				//If the response code is >=400.It is broken link
				if(Conn.getResponseCode()>=400) {
					System.out.println(attrVal+"==>Broken link");
					broken++;
				}else {
					System.out.println(attrVal+"==>Not broken link");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("The count of broken link is"+broken);

	}

}
