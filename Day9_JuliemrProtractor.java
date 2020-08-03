/*13/07/2020
============  
1. Go to https://juliemr.github.io/protractor-demo/
2. Input a number
3. Select Multiplication
4. Input second number
5. Click GO
6. Wait for the output to load and print the results

Condition: Should not use Thread.sleep
Hint: Refer https://blog.vsoftconsulting.com/blog/testing-angular-applications-using-selenium
*/ 

package seleniumworkout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day9_JuliemrProtractor {
	
	public static WebDriverWait wait;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://juliemr.github.io/protractor-demo/");
		String num1="20";
		String num2="5";
				
		driver.findElementByXPath("(//input[contains(@class,'input-small ng-pristine')])[1]").sendKeys(num1);		
		WebElement ele = driver.findElement(By.tagName("select")); 
		new Select(ele).selectByVisibleText("*");
		driver.findElementByXPath("//input[@ng-model='second']").sendKeys(num2);
		
		driver.findElementById("gobutton").click();
		WebElement result = driver.findElement(By.xpath("//h2[@class='ng-binding']"));
		
		int num=Integer.parseInt(num1)*Integer.parseInt(num2);
		String calculated_result=String.valueOf(num);
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(result,calculated_result));
		System.out.println("The multiplication of two numbers is: "+result.getText());

		driver.close();

	}

}
