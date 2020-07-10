/*07/07/2019
============
1) Go to https://www.trivago.com/
2) Type Agra in Destination and select Agra, Uttar Pradesh.
3) Choose May 15 as check in and May 30 as check out
4) Select Room as Family Room
5) Choose Number of Adults 2, Childern 1 and set Child's Age as 4
6) Click Confirm button and click Search
7) Select Accommodation type as Hotels only and choose 4 stars
8) Select Guest rating as Very Good
9) Set Hotel Location as Agra Fort and click Done
10) In more Filters, select Air conditioning, Restaurant and WiFi and click Done
11) Sort the result as Rating & Recommended
12) Print the Hotel name, Rating, Number of Reviews and Click View Deal
13) Print the URL of the Page
14) Print the Price of the Room and click Choose Your Room
15) Click Reserve and I'll Reserve
16) Close the browser*/

package seleniumworkout;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Day6_Trivago {

	public static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.trivago.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);

		driver.findElementById("querytext").sendKeys("Agra");
		driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//time[@datetime='2020-07-21']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//time[@datetime='2020-07-30']").click();
		Thread.sleep(1000);

		/* driver.findElementByXPath("//button[@class='dealform-button dealform-button--guests js-dealform-button-guests']").click();
		 * //driver.findElementByXPath("(//span[@class='dealform-button__head'])[3]").click(); 
		 * Thread.sleep(1000);
		 * driver.findElementByXPath("(//button[@class='circle-btn circle-btn--plus'])[2]").click();
		 * Thread.sleep(1000);
		 * WebElement childage =driver.findElement(By.id("child-0")); 
		 * new Select(childage).selectByValue("4"); 
		 * Thread.sleep(1000);
		 */
		driver.findElementByXPath("(//button[text()='Apply'])[1]").click();
		Thread.sleep(1000);

		WebElement accom = driver.findElementByXPath("//strong[text()='Accommodation']");
		Actions builder = new Actions(driver);
		builder.moveToElement(accom).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("//label[@for='acc-type-filter-1']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@class='refinement-row__content']//button[@title='4-star hotels']").click();
		Thread.sleep(1000);
		driver.findElementById("filter-popover-done-button").click();

		WebElement guest = driver.findElementByXPath("//strong[text()='Guest rating']");
		Thread.sleep(1000);
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(guest).perform();
		driver.findElementByXPath("//span[text()='Very good']").click();
		Thread.sleep(1000);

		WebElement Location = driver.findElementByXPath("//strong[text()='Hotel location']");
		Actions builder3 = new Actions(driver);
		builder3.moveToElement(Location).perform();
		Thread.sleep(1000);
		WebElement location = driver.findElementByXPath("//select[@id='pois']");
		Select selectLocation = new Select(location);
		selectLocation.selectByVisibleText("Agra Fort");
		driver.findElementByXPath("//button[text()='Done']").click();

		WebElement Filters = driver.findElementByXPath("//span[text()='Select']");
		Actions builder4 = new Actions(driver);
		builder4.moveToElement(Filters).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("//label[text()='Air conditioning']").click();
		driver.findElementByXPath("//label[text()='WiFi']").click();
		driver.findElementByXPath("//label[text()='Restaurant']").click();
		driver.findElementByXPath("//button[text()='Done']").click();

		WebElement sortBy = driver.findElementByXPath("//select[@id='mf-select-sortby']");
		Select selectSortBy = new Select(sortBy);
		selectSortBy.selectByVisibleText("Rating & Recommended");
		Thread.sleep(3000);

		List<WebElement> hotelName = driver.findElementsByXPath("//span[@data-qa='item-name']");
		int hotelnos=hotelName.size();

		ArrayList<String> Hotelname = new ArrayList<String>(); 
		for(int i=0;i<=hotelnos-1;i++)
		{
			WebElement column = hotelName.get(i);
			String text=column.getText();
			Hotelname.add(text);
		}
			System.out.println(Hotelname);

			driver.close();
	}

}

