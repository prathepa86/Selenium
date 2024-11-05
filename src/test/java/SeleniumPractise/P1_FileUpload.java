package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_FileUpload {
	public static String sURL="https://davidwalsh.name/demo/multiple-file-upload.php";

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("filesToUpload")).sendKeys("D:\\API\\student\\new.json");
        WebElement FileName;
        FileName=driver.findElement(By.xpath("//ul[@id='fileList']/li"));
        if(FileName.getText().equals("new.json")) {
        	System.out.println("File is successfully uploaded ");
        }else {
        	System.out.println("Upload failure");
        }
	}

}
