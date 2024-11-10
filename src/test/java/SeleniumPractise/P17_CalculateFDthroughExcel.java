package SeleniumPractise;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P17_CalculateFDthroughExcel {
	
	public static String sURL="https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true";
	public static String sheetName="data";
public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Providing FilePath
		String filePath=System.getProperty("user.dir")+"/testdata/calculator.xlsx";
		//Retrieving total number of rows from the excel
		int rowNumber = P17_UtilityFile.getRowNumber(filePath,sheetName);
		
		//Index should start from 1, as 0th index contains header
		for(int i=1;i<=rowNumber;i++) {
			//Retreving cellvalue of Principal
			//Row value is i and data should be retreive from the 0th column
			String Principal = P17_UtilityFile.getCellData(filePath, sheetName, i, 0);
			String RateOfInterest = P17_UtilityFile.getCellData(filePath, sheetName, i, 1);
			
			String Period_Val = P17_UtilityFile.getCellData(filePath, sheetName, i, 2);
			//Number of days/years/month
			String Period_In = P17_UtilityFile.getCellData(filePath, sheetName, i, 3);
			String Frequency = P17_UtilityFile.getCellData(filePath, sheetName, i, 4);
			String Exp_MaturityVal = P17_UtilityFile.getCellData(filePath, sheetName, i, 5);
			
			
			//Pass above data into the application
			//1.Principal
			driver.findElement(By.id("principal")).sendKeys(Principal);
			//2.RateOfInterest
			driver.findElement(By.id("interest")).sendKeys(RateOfInterest);
			//3.Period value
			driver.findElement(By.id("tenure")).sendKeys(Period_Val);
			//4.Years/Month/Days
			WebElement DD = driver.findElement(By.id("tenurePeriod"));
			Select Period=new Select(DD);
			Period.selectByVisibleText(Period_In);
			//5.Frequency(S.I)
			WebElement Frequency_Type = driver.findElement(By.id("frequency"));
			Select fre=new Select(Frequency_Type);
			fre.selectByVisibleText(Frequency);
			//6.click on calculate button
			Thread.sleep(3000);
			WebElement calculate=driver.findElement(By.xpath("//div[@class='CTR PT15']"));
			//WebDriverWait oWait=new WebDriverWait(driver,Duration.ofSeconds(20));
			//oWait.until(ExpectedConditions.elementToBeClickable(calculate));
			Thread.sleep(3000);
	
			//calculate.click();
			//Actions action=new Actions(driver);
			//action.moveToElement(calculate).click(calculate).perform();
			JavascriptExecutor js=(JavascriptExecutor)driver;
		
			js.executeScript("arguments[0].click()",calculate);
			
			//7.Capture Maturity value
			String actual_MaturityVal = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			
			//Maturity value display in double
			if(Double.parseDouble(Exp_MaturityVal)==Double.parseDouble(actual_MaturityVal)) {
				System.out.println("Test case passed");
				P17_UtilityFile.setCellData(filePath, sheetName, i,7 , "Passed");
				P17_UtilityFile.fillGreenColor(filePath, sheetName, i, 7);
				
			}
			else {
				System.out.println("TestCase is failed");
				P17_UtilityFile.setCellData(filePath, sheetName, i, 7, "Failed");
				P17_UtilityFile.fillRedColor(filePath, sheetName, i, 7);
			}
			Thread.sleep(2000);
			//To clear the values before moving on to the next iteration
			driver.findElement(By.xpath("(//div[@class='CTR PT15']/a)[2]")).clear();
		  		
			
		}//ForLoop end here
		driver.quit();
		
		
		

	}

}
