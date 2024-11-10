package SeleniumPractise;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P17_CalculateDepositThroughExcel {
	public static String sURL="https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator";
	public static WebDriver driver;
	public static String sheetName="data";

	public static void main(String[] args) throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		String filePath=System.getProperty("user.dir")+"/testdata/citibankcalculator.xlsx";
	   int rowNumber = P17_UtilityFile.getRowNumber(filePath, sheetName);
	   for(int i=1;i<=rowNumber;i++) {
		   //To get the data from the Excel
		   String amount = P17_UtilityFile.getCellData(filePath, sheetName, i, 0);
		   String length = P17_UtilityFile.getCellData(filePath, sheetName, i, 1);
		   String rate = P17_UtilityFile.getCellData(filePath, sheetName, i, 2);
		   String compounding = P17_UtilityFile.getCellData(filePath, sheetName, i, 3);
		   String exp_Value = P17_UtilityFile.getCellData(filePath, sheetName, i, 4);
		   //To pass the data into the application
		   //Principal amount
		   WebElement PrincipalAmount=driver.findElement(By.id("mat-input-0"));
		   PrincipalAmount.clear();
		   PrincipalAmount.sendKeys(amount);
		   
		   //Total Months
		   WebElement totalMonths=driver.findElement(By.id("mat-input-1"));
		   totalMonths.clear();
		   totalMonths.sendKeys(length);
		   
		   //Rate of interest
		   WebElement rateOfInterest=driver.findElement(By.id("mat-input-2"));
		   rateOfInterest.clear();
		   rateOfInterest.sendKeys(rate);
		   
		   //Dropdown
		   //Click on the arrow mark
		   driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c109-4']")).click();
		   //Select the compund quaterly or annually
		   Thread.sleep(3000);
		   
		   JavascriptExecutor js=(JavascriptExecutor)driver;		   
		   WebElement compound=driver.findElement(By.xpath("//span[@class='mat-select-value-text ng-tns-c109-4 ng-star-inserted']/span[text()='"+compounding+"']"));
		   js.executeScript("arguments[0].scrollIntoView(true);",compound);
		   Thread.sleep(3000);
		   //Actions action=new Actions(driver);
		   //action.moveToElement(compound).click().perform();
		   js.executeScript("arguments[0].click()",compound);
		   
		   //Lets run the numbers button
		   driver.findElement(By.xpath("//button[@id='CIT-chart-submit']/div")).click();
		   
		   //To capture the actual value
		   String actualValue = driver.findElement(By.id("displayTotalValue")).getText();
		   
		   //to compare the actual value with the expected value
		   //PASS
		   if(actualValue.equals(exp_Value)) {
			   System.out.println("TestCase is passed");
			   P17_UtilityFile.setCellData(filePath, sheetName, i, 6, "PASS");
			   P17_UtilityFile.fillGreenColor(filePath, sheetName, i, 6);
		   }
		   else {//FAIL
			   System.out.println("TestCase is Failed");
			   P17_UtilityFile.setCellData(filePath, sheetName, i, 6, "FAIL");
			   P17_UtilityFile.fillRedColor(filePath, sheetName, i, 6);
		   }		   
	   }
		}
}
