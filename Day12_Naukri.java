/*16/07/2020
=============
1) Load https://www.naukri.com/
2) You will get three different popup windows
3) Capture the company name and print the company names in the popup window 
4) Close the window*/

package seleniumworkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day12_Naukri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);	
		
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		int size = list.size();
		
		for (int i = 0; i <size-1; i++)	{
			driver.switchTo().window(list.get(i+1));
			String cName = driver.findElementByXPath("//img[contains(@src,'gif')]").getAttribute("alt");
			System.out.println("Company Name: " + cName);
			System.out.println("Window Title is: "+driver.getTitle());
			driver.close();
		}
		
		driver.switchTo().window(list.get(0));
		driver.close();

	}

}
