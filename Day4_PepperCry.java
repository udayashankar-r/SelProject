/*02/07/2020
============
1) Go to https://www.pepperfry.com/
2) Mouseover on Furniture and click Office Chairs under Chairs
3) click Executive Chairs
4) Change the minimum Height as 50 in under Dimensions
5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
6) Mouseover on Furniture and Click Office tables
7) Select Executive Desks
8) Select Price between 20000 to 40000 rs
9) Add "Executive Office Table in Brown Color" to Wishlist
10) Verify the number of items in Wishlist
11) Navigate to Wishlist
12) Get the offer Price and Coupon Code for Executive Office Table in Brown Color
13) Move Executive Office Table in Brown Color only to Cart from Wishlist
14) Check for the availability for Pincode 600128
15) Click on PROCEED TO PAY SECURELY from My Cart
16) Enter the Coupon code and click Apply
17) Click Proceed to Pay
18) Capture the screenshot of the item under ORDER SUMMARY
19) Close the browser*/

package seleniumworkout;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day4_PepperCry {
	
	public static WebDriverWait wait;
	public static Actions action;

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.pepperfry.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

//		driver.findElementByXPath("(//a[@class='popup-close'])[6]").click();
		WebElement cpop = driver.findElementByXPath("//div[@id='regPopUp']/a");
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(cpop));
		action=new Actions(driver);
		action.click(cpop);

		WebElement offerframe = driver.findElementByXPath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']");
		driver.switchTo().frame(offerframe);
		WebElement offerpopup = driver.findElementByXPath("//span[contains(@class,'wewidgeticon we_close')]");
		wait.until(ExpectedConditions.visibilityOf(offerpopup)).click();
		driver.switchTo().defaultContent();

		//Office chair
		WebElement furniturechair = driver.findElementByXPath("(//div[@id='menu_wrapper']//a)[1]");
		action.moveToElement(furniturechair).perform();

		driver.findElementByXPath("//div[@id='meta-furniture']/div[1]/div[3]/div[2]/div[12]/a[1]").click();
		Thread.sleep(1000);

		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		WebElement Height =driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]");
		Height.clear();
		Height.sendKeys("50",Keys.TAB);
		Thread.sleep(1000);

		driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']").click();
		Thread.sleep(1000);

		//Office table
		WebElement furnituretable = driver.findElementByXPath("(//div[@id='menu_wrapper']//a)[1]");
		action.moveToElement(furnituretable).perform();

		driver.findElementByLinkText("Office Tables").click();
		Thread.sleep(2000);

		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		driver.findElementByXPath("//label[@for='price20000-40000']").click();
		Thread.sleep(1000);

		driver.findElementById("clip_wishlist_").click();
		Thread.sleep(1000);

		//Wishlist
		String Noofitems = driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
		System.out.println("Number of items in wishlist: "+Noofitems);

		driver.findElementByXPath("//a[contains(@class,'pf-icon pf-icon-heart')]").click();
		Thread.sleep(1000);

		String Offer_price = driver.findElementByXPath("(//span[@class='txt-green'])[1]").getText().replaceAll("[^0-9]", "");
		System.out.println("Offer price of Brown table:"+Offer_price);
		String Couponcode = driver.findElementByXPath("(//strong[text()='FREEDOM'])[1]").getText();
		System.out.println("Coupon code of Brown table:"+Couponcode);

		WebElement offerframe2 = driver.findElementByXPath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']");
		driver.switchTo().frame(offerframe2);
		WebElement offerpopup2 = driver.findElementByXPath("//span[contains(@class,'wewidgeticon we_close')]");
		wait.until(ExpectedConditions.visibilityOf(offerpopup2)).click();
		driver.switchTo().defaultContent();
		
		//Cart
		driver.findElementByXPath("(//a[@data-tooltip='Add to Cart'])[1]").click();
		driver.findElementByClassName("srvc_pin_text").sendKeys("600128");
		driver.findElement(By.className("check_available")).click();
		driver.findElementByClassName("proceed_cta").click();
		
		driver.findElementById("coupon_code").sendKeys(Couponcode);
		driver.findElementById("cpn_check_btn").click();
		Thread.sleep(2000);		
		driver.findElementByClassName("btn_green_big").click();
		
		//Screenshot
		driver.findElementByXPath("//span[text() = 'ORDER SUMMARY']").click();
		Thread.sleep(2000);
		driver.executeScript("window.scrollBy(0,300)");
		WebElement capture = driver.findElementByXPath("//li[contains(@class , 'onepge_ordersummary ')]");
		File src = ((TakesScreenshot)capture).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/pepperfry.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot taken successfully");
	
		driver.close();

	}

}

