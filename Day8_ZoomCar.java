/*09/07/2020
===========
1. Go to https://www.zoomcar.com/chennai
2. Click on Start your wonderful journey
3. Select  any location under POPULAR PICK-UP POINTS and click next
4. Select tomorrow's date and time as 9:00 AM as start date and time and Click Next
5. Click on Show More and Select tomorrow's date and Select time as 6:00 PM as end date and Click Done
6. Take the snapshot for PICKUP TIME and DROP OFF TIME
7. Validate the pickup time and Drop off time are correct (as you selected) -----> and click on Done
8. Click on Price: High to Low and validate the sort order of the car price programmatically
9. Print all the Car name and respective Price from High to Low ( car name -- price )
10. Take snapshot of the details for the Highest price car
11. Click on Know More for the Highest price car and print the rate after 45Kms
12. Close the Browser*/

package seleniumworkout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day8_ZoomCar {
	
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@title='Start your wonderful journey']").click();
		driver.findElementByXPath("(//div[@class='items'])[1]").click();
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//div[@class='days']//div)[3]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='09:00']").click();
		Thread.sleep(1000);
		driver.findElementByClassName("proceed").click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='18:00']")).click();
		Thread.sleep(1000);
		driver.findElementByClassName("proceed").click();
		Thread.sleep(2000);
		
		WebElement pickupdroptime=driver.findElementByXPath("//div[@class='duration-details']");
		//wait.until(ExpectedConditions.visibilityOf(pickupdroptime));
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(source);
		Point point = pickupdroptime.getLocation();
		int eleWidth = pickupdroptime.getSize().getWidth();
		int eleHeight = pickupdroptime.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", source);
		File target = new File("./Screenshots/Zoomcar_Pickupdropofftime.png");
		FileUtils.copyFile(source, target);
				
		String pickupTime = driver.findElementByXPath("(//div[@class='time']//div)[2]").getText();
		String dropoffTime = driver.findElementByXPath("(//div[@class='time']//div)[4]").getText();
		if((pickupTime.contains("09:00 AM"))&& (dropoffTime.contains("06:00 PM")))
		{
			System.out.println("Pickup time is "+pickupTime+" and Dropoff time is "+dropoffTime+"");
		}
		
		driver.findElementByXPath("//div[text()=' Price: High to Low ']").click();
		Thread.sleep(2000);
		
		List<WebElement> carDetials = driver.findElementsByXPath("//div[@class='details']//h3");
		List<WebElement> price = driver.findElementsByXPath("//div[@class='new-price']");
		
		Map<String, String> map = new LinkedHashMap<String, String>(); 
		for(int i=0;i<=carDetials.size()-1;i++)
		{
			WebElement carname = carDetials.get(i);
			WebElement carprice=price.get(i);
			map.put(carname.getText(), carprice.getText().replaceAll("[^0-9.]", ""));
		}
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) 
		{
			System.out.println(entry.getKey() +" --> "+ entry.getValue());
		}
		
		WebElement highprice=driver.findElementByXPath("//div[@class='component-car-item'][1]");
//		wait.until(ExpectedConditions.visibilityOf(highprice));
		File source1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg1 = ImageIO.read(source1);
		Point point1 = highprice.getLocation();
		int eleWidth1 = highprice.getSize().getWidth();
		int eleHeight1 = highprice.getSize().getHeight();
		BufferedImage eleScreenshot1 = fullImg1.getSubimage(point1.getX(), point1.getY(),eleWidth1, eleHeight1);
		ImageIO.write(eleScreenshot1, "png", source1);
		File target1 = new File("./Screenshots/Zoom_Highestpricecar.png");
		FileUtils.copyFile(source1, target1);
		
		driver.findElementByXPath("(//div[@class='know-more-details'])[1]").click();
		
		WebElement rate = driver.findElementByXPath("(//div[@class='price-info'])[1]");
		String rateafter45 = rate.getText().substring(2, 4);
		System.out.println("Rate after 45 kms: "+rateafter45+" perkm");
		
		driver.close();
	}

}
