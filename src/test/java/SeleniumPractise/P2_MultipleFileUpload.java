package SeleniumPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_MultipleFileUpload {
	public static String sURL="https://davidwalsh.name/demo/multiple-file-upload.php";


	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get(sURL);
	driver.manage().window().maximize();
	
	String file1="D:\\API\\student\\new.json";
	String file2="D:\\API\\student\\student.json";
	driver.findElement(By.id("filesToUpload")).sendKeys(file1+"\n"+file2);
	List<WebElement> Files=driver.findElements(By.xpath("//ul[@id='fileList']/li"));
	int TotalFile=Files.size();
	
	//Validation1
	if(TotalFile==2) {
		System.out.println("Both the files added successfully");
	}else {
		System.out.println("File is not added successfully");
	}
	
	//Validation 2
	if(driver.findElement(By.xpath("(//ul[@id='fileList']/li)[1]")).getText().equals("new.json")
			&& driver.findElement(By.xpath("(//ul[@id='fileList']/li)[2]")).getText().equals("student.json")) {
		System.out.println("File name matched");
	}else {
		System.out.println("File name not matched");
	}
	
	

	}

}
