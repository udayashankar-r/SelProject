/*06/07/2020
===========
1) Go to https://www.zalando.com/
2) Get the Alert text and print it 
3) Close the Alert box and click on Zalando.uk
4) Click Women--> Clothing and click Coats 
5) Choose Material as cotton (100%) and Length as thigh-length
6) Click on JUNAROSE - by VERO MODA
7) Click Color as Black and Size as 'M' Under Manufacture Sizes
8) Add to bag only if Standard Delivery is free
9) Mouse over on Your Bag and Click on "Go to Bag"
10) Read the Estimated Deliver Date and print
11) Click on 'Go To Checkout'
12) Enter your email
13) Click on Login button
14) Print the error message*/

package seleniumworkout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day5_Zalando {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.zalando.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

		String alert = driver.switchTo().alert().getText();
		System.out.println("Alert Text: "+alert);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.findElementByXPath("//a[@class='nav_link nav_link-gb']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
		driver.findElementByXPath("//span[text()='Women']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Clothing']").click();
		driver.findElementByXPath("//a[@aria-label='Browse Coats by category']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@aria-label='filter by Material']").click();
		driver.findElementByXPath("//span[text()='cotton (100%)']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//button[@aria-label='filter by Length']").click();
		driver.findElementByXPath("//span[text()='thigh-length']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[text()='JUNAROSE - by VERO MODA']").click();
		driver.findElementByXPath("//span[text()='Choose your size']").click();
		driver.findElementByXPath("//span[text()='Manufacturer sizes']").click();
		driver.findElementByXPath("//span[text()='M']").click();
		String applyfree = driver.findElementByXPath("(//span[text()='Free'])[1]").getText();
		System.out.println("Delivery Cost: "+applyfree);
		
		if(applyfree.contains("Free"))
		{
			driver.findElementByXPath("//button[@aria-label='Add to bag']").click();
		}
		else {
			System.out.println("Free delivery is not applicable for selected product");
		}
		
		WebElement bag = driver.findElementByXPath("//span[text()='Your bag']"); 
		Actions builder = new Actions(driver);
		builder.moveToElement(bag).perform();
		driver.findElementByXPath("//div[text()='Go to bag']").click();

		String deliverydate = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText();
		System.out.println("Estimated Delivery Date: "+deliverydate);
		driver.findElementByXPath("(//div[text()='Go to checkout'])[1]").click();

		driver.findElementById("login.email").sendKeys("abcdef1234@gmail.com");
		driver.findElementByXPath("//span[text()='Login']").click();
		String errormsg = driver.findElementByXPath("//div[@data-validation='error']//span[2]").getText();
		System.out.println("Error Message: "+errormsg);
		
		driver.close();

	}

}
