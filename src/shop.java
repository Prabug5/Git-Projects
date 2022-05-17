import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.WebElement;

public class shop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//setting Driver
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");

		WebDriver driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//website
		driver.get("https://www.urbanladder.com");
		//finding products
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Table");
		driver.findElement(By.xpath("//span[@class='search-icon icofont-search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Close']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[contains(@class,'container')]/div[@id='wrapper']/div[@id='content']/div[@id='search-results']/div[contains(@class,'row')]/ul[contains(@class,'productlist small-block-grid-3')]/li[3]/div[1]")).click();
		
		
		String ParentWindowHandler=driver.getWindowHandle();
		System.out.println("ParenWindowhandler"+ParentWindowHandler);
		
		Thread.sleep(3000);
		for(String childTab:driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		Thread.sleep(2000);
		 String Product="/html/body/div[1]/div[2]/div[3]/div[3]/div[1]/h1";
			String	productname=driver.findElement(By.xpath(Product)).getText();
		System.out.println("Title:"+productname);
		
		//WebElement price=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[3]/div[3]/div[1]/div[2]/div[1]/div[4]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));
		String Price="//div[@class='price discounted-price']";
		String Rupees=driver.findElement(By.xpath(Price)).getText();
		System.out.println("Cost:"+Rupees);
		
		
	}

}
