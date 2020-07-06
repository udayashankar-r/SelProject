/*01/07/2020
==========
1) Go to https://azure.microsoft.com/en-in/
2) Click on Pricing
3) Click on Pricing Calculator
4) Click on Containers
5) Select Container Instances
6) Click on Container Instance Added View
7) Select Region as "South India"
8) Set the Duration as 180000 seconds
9) Select the Memory as 4GB
10) Enable SHOW DEV/TEST PRICING
11) Select Indian Rupee  as currency
12) Print the Estimated monthly price
13) Click on Export to download the estimate as excel
14) Verify the downloded file in the local folder
15) Navigate to Example Scenarios and Select CI/CD for Containers
16) Click Add to Estimate
17) Change the Currency as Indian Rupee
18) Enable SHOW DEV/TEST PRICING
19) Export the Estimate
20) Verify the downloded file in the local folder*/

package seleniumworkout;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3_AzureMicrosoft {
		
	private static void isFileDownloaded(String filename)
	{
		File file = new File("C:\\Users\\user\\Downloads\\"+filename);

		if(file.exists()) {
		    System.out.println(filename+" successfully downloaded in local directory");
		}
		else {
		    System.out.println(filename+" not successfully downloaded in local directory");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("navigation-pricing").click();
		driver.findElementByLinkText("Pricing calculator").click();
		
		driver.findElementByXPath("//button[text()='Containers']").click();
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("new-module-loc"))).click();
		
		WebElement region = driver.findElementByName("region"); 
		new Select(region).selectByVisibleText("South India");
		
		WebElement duration = driver.findElementByXPath("//input[@name='seconds']");
		duration.clear();
		duration.sendKeys(Keys.BACK_SPACE);
		duration.sendKeys("180000");
		
		WebElement memory = driver.findElementByName("memory");
		new Select(memory).selectByValue("4");
		
		driver.findElementById("devtest-toggler").click();
		String devtestmsg = driver.findElementByXPath("//span[text()='Dev/Test pricing has been applied']").getText();
		System.out.println(devtestmsg);
		
		WebElement currency = driver.findElementByXPath("//select[@class='select currency-dropdown']"); 
		new Select(currency).selectByValue("INR");
		
		String Estimated_monthlycost = driver.findElementByXPath("(//div[@class = 'column large-3 text-right total']/div[2]//span)[2]").getText();
		System.out.println("Estimate monthly cost: "+Estimated_monthlycost);
		
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(2000);
//		String file_name = "ExportedEstimate.xlsx";
		isFileDownloaded("ExportedEstimate.xlsx");		
		Thread.sleep(2000);

		driver.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		driver.findElementByXPath("//a[text() = 'Example Scenarios']").click();
		driver.findElementByXPath("//button[@title = 'CI/CD for Containers']").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//button[text() = 'Add to estimate']").click();
		Thread.sleep(5000);
	
		String alert = driver.findElementByXPath("//span[text()='Estimate added!']").getText();
//		String alerttext = wait.until(ExpectedConditions.visibilityOf(alert)).getText();
		System.out.println(alert);
		
		WebElement currency1 = driver.findElementByXPath("//select[@class='select currency-dropdown']"); 
		new Select(currency1).selectByValue("INR");
		
		driver.findElementByName("devTestSelected").click();
		String devtestmsg1 = driver.findElementByXPath("//span[text()='Dev/Test pricing has been applied']").getText();
		System.out.println(devtestmsg1);
		
		driver.findElementByXPath("//button[contains(@class , 'export-button')]").click();
		Thread.sleep(2000);
		isFileDownloaded("ExportedEstimate (1).xlsx");
		
		driver.close();		
	}

}
