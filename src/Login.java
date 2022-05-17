import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");

		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		
		Thread.sleep(1000);
		WebElement hover=driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]"));
		Actions action=new Actions(driver);
		action.moveToElement(hover).build().perform();
		
		
		        Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		//driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]")).click();
		
		driver.findElement(By.xpath("//div[@id='password-credentials']//input[@id='spree_user_email']")).sendKeys("theherok091@gmail.com");
		driver.findElement(By.xpath("(//input[@id='spree_user_password'])[3]")).sendKeys("Hello@123");
		
		driver.findElement(By.xpath("//input[@id='ul_site_login']")).click();
		
		
	}

}
