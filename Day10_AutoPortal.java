/*14/07/2020
=============
Goto https://autoportal.com/
Select Location as Chennai
Select Car Brand as Renault
Select Model as Arkana
Search for the car
Print the expected price*/

package seleniumworkout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Day10_AutoPortal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://autoportal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath("//div[@class='maincity-in field']")).click();
		WebElement city = driver.findElement(By.id("ac_user_city"));
		city.sendKeys("Chennai");
		Thread.sleep(2000);
		city.sendKeys(Keys.DOWN,Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='red_but'])[1]")).click();
//		driver.findElement(By.xpath("//span[text()='Confirm City']")).click();
		Thread.sleep(1000);

		WebElement brand = driver.findElement(By.name("brand")); 
		new Select(brand).selectByVisibleText("Renault"); 
		
		WebElement model = driver.findElement(By.name("model")); 
		new Select(model).selectByVisibleText("Arkana");
		
		driver.findElement(By.xpath("//input[@value='Find new cars']")).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElementByXPath("//div[@class='nm_price m_b-10']");
		System.out.println(expected.getText());
		
		driver.close();

	}

}
