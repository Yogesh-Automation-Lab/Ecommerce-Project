package udemyPackage1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertCases1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span[@id='nav-link-accountList-nav-line-1']"))).click().build().perform();
		//a.moveToElement(move).build().perform();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.id("ap_email_login"))).keyDown(Keys.SHIFT)
		.sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(driver.findElement(By.id("ab-registration-ingress-link"))).contextClick().build().perform();	
		driver.manage().deleteAllCookies();
		//driver.close();
	}

}
