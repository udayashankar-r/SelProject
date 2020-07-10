/*08/07/2020
===========
1) Go to https://www.bigbasket.com/
2) mouse over on  Shop by Category 
3) Go to Beverages and Fruit juices & Drinks
4) Click on JUICES
5) click Tropicana and Real under Brand
6) Check count of the products from each Brands and total count
6) Check whether the products is availabe with Add button.
7) Add the First listed available product 
8) click on Change Address 
9) Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue
10) Mouse over on My Basket print the product name. count and price.
11) Click View Basker and Checkout
12) Click the close button and close the browser*/

package seleniumworkout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day7_BigBasket {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement shopcategory = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
		Thread.sleep(3000);
		action.moveToElement(shopcategory).pause(2000).perform();

		WebElement beverages = driver.findElementByXPath("(//a[@href='/cl/beverages/?nc=nb'])[2]");
		action.moveToElement(beverages).pause(3000).perform();
		WebElement fruitjuices = driver.findElementByXPath("(//a[@href='/pc/beverages/fruit-juices-drinks/?nc=nb'])[2]");
		action.moveToElement(fruitjuices).click(fruitjuices).perform();
		Thread.sleep(3000);

		WebElement tropicana = driver.findElementByXPath("(//span[text()='Tropicana'])[1]");
		tropicana.click();
		String productnametrop = tropicana.getText();
		Thread.sleep(2000);

		String prodCount = driver.findElementByXPath("//h2[@qa='pageName']").getText();
		int len = prodCount.length();
		String firstCount = prodCount.substring(23, len-1);
		System.out.println("No of "+productnametrop+" products available is: "+firstCount);
		
		WebElement real = driver.findElementByXPath("(//span[text()='Real'])[1]");
		real.click();
		String productnamereal = real.getText();
		Thread.sleep(5000);
		
		String Count = driver.findElementByXPath("//h2[@qa='pageName']").getText();
		int lene = Count.length();
		String totalCount = Count.substring(23, lene-1);
		int secondCount = Integer.parseInt(totalCount) - Integer.parseInt(firstCount);
		System.out.println("No of "+productnamereal+" products available is: "+secondCount);
		
		System.out.println("Total Available products is "+totalCount);
		
		List<WebElement> availableProducts = driver.findElements(By.xpath("//div[@class='col-xs-12 bskt-opt ng-scope']"));		
		int size = availableProducts.size();
		List<WebElement> addbutton = driver.findElements(By.xpath("//button[@qa='add']"));
		int addbuttonenabled = addbutton.size();
		System.out.println(addbuttonenabled+" out of "+size+" products has add button");
		
		driver.findElementByXPath("(//button[@qa='add'])[1]").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//a[text()='Change Location']").click();
		driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys("Alandur");
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys(Keys.DOWN,Keys.TAB);
		Thread.sleep(1000);
		driver.findElementByXPath("//button[@name='continue']").click();
		Thread.sleep(1000);
		
		WebElement basket = driver.findElementByXPath("//span[@class='basket-content']");
		Actions builder=new Actions(driver);
		builder.moveToElement(basket).perform();

		String mybasket = driver.findElementByXPath("//a[@qa='prodNameMB']").getText();
//		String count = driver.findElementByXPath("(//input[@ng-model='cartItem.quantity'])").getText();
		String count = driver.findElementByXPath("(//div[@qa='pcsMB'])[1]").getText();
		char finalCount = count.charAt(0);
		String price = driver.findElement(By.xpath("//span[@qa='priceMB']")).getText();
		System.out.println("Item Name: "+mybasket);
		System.out.println("Item Count: "+finalCount);
		System.out.println("Item Price: "+price);

		driver.findElementByXPath("//button[@qa='viewBasketMB']").click();
		driver.findElementByXPath("(//button[@class='close'])[1]").click();
		driver.close();
		
	}

}

