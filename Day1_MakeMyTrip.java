/*29/06/2020
================
1) Go to https://www.makemytrip.com/
2) Click Hotels
3) Enter city as Goa, and choose Goa, India
4) Enter Check in date as Next month 15th (July 15) and Check out as start date+4
5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
6) Click Search button
7) Select locality as Baga
8) Select user rating as 3&above(good) under Select Filters
9) Select Sort By: Price-Low to High
10) Click on the first resulting hotel and go to the new window
11) Print the Hotel Name 
12) Click VIEW THIS COMBO button under Recommended Combo
13) Click on BOOK THIS COMBO button
14) Print the Total Payable amount
15) Close the browser*/ 

package seleniumworkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1_MakeMyTrip {
	
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();
				
		driver.findElementByXPath("//div[contains(@class,'loginModal')]").click();
		driver.findElementByXPath("(//div[@class='chHeaderContainer']//li[@class='menu_Hotels']/a)").click();
		driver.findElementByXPath("//span[@data-cy='hotelCityLabel']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text()='City / Hotel / Area / Building']/following::input)[2]").sendKeys("Goa");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
		Thread.sleep(1000);
		driver.findElementById("checkin").click();
		
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[text()='19'])[2]").click();
		driver.findElementById("guest").click();
		driver.findElementByXPath("//li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
		Thread.sleep(2000);
		driver.findElementById("hsw_search_button").click();
		Thread.sleep(2000);

		/* ChromeDriver driver1 = new ChromeDriver(); driver1.get(
		 * "https://www.makemytrip.com/hotels/hotel-listing/?checkin=07152020&city=CTGOI&checkout=07192020&roomStayQualifier=2e1e12e&locusId=CTGOI&country=IN&locusType=city&searchText=Goa,%20India&visitorId=c75c5263-ae56-446a-9d9e-9e484b2fe495"
		 * ); driver1.manage().window().maximize();
		 * driver1.findElementByXPath("//body[@class='bodyFixed overlayWholeBlack']").click();
		 */

		wait=new WebDriverWait(driver,10);
		driver.findElementByXPath("//body[@class='bodyFixed overlayWholeBlack']").click();
		driver.findElementByXPath("//label[text()='Baga']").click();
		driver.findElementByXPath("//label[text()='3 & above (Good)']").click();
		driver.findElementByXPath("//span[text()='Popularity']").click();
		driver.findElement(By.xpath("(//ul[@class='customSelectOptions latoBold']//li)[2]")).click();
		Thread.sleep(3000);
//		driver1.findElementByXPath("(//p[@id='hlistpg_hotel_name']//span)[1]").click();
		driver.findElementByXPath("(//p[@itemprop='name']//span)[1]").click();
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.manage().deleteAllCookies();
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		Thread.sleep(2000);

		String HotelName=driver.findElementById("detpg_hotel_name").getText();
		System.out.println("Hotel Name is : "+HotelName);
		
		try	{
			driver.findElementById("detpg_multi_view_combo").click();
			driver.findElementById("detpg_book_combo_btn").click();
		}
		catch (Exception e)	{
			driver.findElementById("detpg_headerright_book_now").click();
		}
		Thread.sleep(2000);
		
		String TotalAmount = driver.findElementById("revpg_total_payable_amt").getText();
		System.out.println("Total amount payable is : "	+TotalAmount);

		driver.quit();
		
	}

}
