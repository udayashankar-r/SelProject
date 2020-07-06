/*30/06/2020
===========
1) Go to https://www.ajio.com/shop/sale
2) Enter Bags in the Search field and Select Bags in Women Handbags
3) Click on five grid and Select SORT BY as "What's New"
4) Enter Price Range Min as 2500 and Max as 5000
5) Click on the product "TOMMY HILFIGER Sling Bag with Chain Strap"
6) Verify the Coupon code for the price above 2890 is applicable for your product, if applicable then get the Coupon Code and the discount price for the coupon
7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
9) Click on ADD TO BAG and then GO TO BAG
10) Check the Order Total before apply coupon
11) Enter Coupon Code and Click Apply
12) Verify the discount price matches with the product price
13) Click on Delete and Delete the item from Bag
14) Close all the browsers*/

package seleniumworkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Day2_Ajio {

	public static ChromeDriver driver;
//	public static WebDriverWait wait;
	public static int discountamt=0;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
//		driver.manage().deleteAllCookies();
		
		driver.findElementByName("searchVal").sendKeys("bags");//Bags		
		driver.findElementByXPath("(//span[text()='Women Handbags'])[1]").click();
		driver.findElementByXPath("//div[@class='five-grid-container ']//div[1]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@class='filter-dropdown']//select[1]//option[4]").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//div[@class='facet-head ']//span[2])").click();
		driver.findElementById("minPrice").sendKeys("2500");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[text()='Sling Bag with Chain Strap']").click();
		Thread.sleep(2000);
		
		Set<String> WindowHandles = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(WindowHandles);
		driver.switchTo().window(allhandles.get(1));
		
		String actualamt = driver.findElementByClassName("prod-sp").getText().replaceAll("[^0-9]", "");
		System.out.println("Actual Amount: "+Integer.parseInt(actualamt));
		String couponcode = null;
		
		if(Integer.parseInt(actualamt) > 2890)
		{
			couponcode = driver.findElementByClassName("promo-title").getText().replaceAll("Use Code", "");
			System.out.println("Coupon Code: "+couponcode);			
			String discountamt1 = driver.findElementByXPath("//div[@class='promo-discounted-price']//span[1]").getText().replaceAll("[^0-9]", "");
			discountamt=Integer.parseInt(discountamt1);
		}
		System.out.println("Discount Amount: "+discountamt);
		
		try
		{
			driver.findElementByXPath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]").click();
		}
		catch (Exception e) 
		{
			driver.findElementByXPath("//span[text()='Change Pincode']").click();
		}

		driver.findElementByName("pincode").sendKeys("560043");
		driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		
		String deliverydate = driver.findElementByClassName("edd-message-success-details-highlighted").getText();
		System.out.println("Expected delivery Date: "+deliverydate);
		driver.findElementByClassName("other-info-toggle").click();
		String custcareaddress = driver.findElementByXPath("//div[@id='appContainer']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/h2[1]/ul[1]/li[11]/span[3]").getText();
		System.out.println("Customer Care address with phone & Email: "+custcareaddress);
		
		driver.findElementByXPath("//div[@class='btn-gold']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
		
		/*
		 * WebElement gotobag = driver.findElementByXPath("//span[text()='GO TO BAG']");
		 * wait=new WebDriverWait(driver,15);
		 * wait.until(ExpectedConditions.textToBePresentInElement(gotobag,"GO TO BAG"));
		 * gotobag.click();
		 * Thread.sleep(2000);
		 */

		String OrderTotal = driver.findElementByXPath("//span[@class='price-value bold-font']").getText().replaceAll("[^0-9]", "");
		System.out.println("Order Total before applying coupon: "+(Integer.parseInt(OrderTotal)/100));
		driver.findElementById("couponCodeInput").sendKeys(couponcode);
		driver.findElementByXPath("//button[text() = 'Apply']").click();
		Thread.sleep(2000);
		
		String couponapplied = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText().replaceAll("[^0-9]", "");
		System.out.println("Order Total after applying coupon: "+(Integer.parseInt(couponapplied)/100));
		
		if ((Integer.parseInt(couponapplied)/100) == discountamt) 
		{
			System.out.println("Coupon code applied and discount amount matched successfully");
		}
		
		driver.findElement(By.className("delete-btn")).click();
		driver.findElement(By.xpath("//div[text()='DELETE']")).click();		
		
		driver.quit();

	}

}

