package udemyPackage1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//a[contains(text(),'Free Access')]")).click();
		driver.findElement(By.xpath("//div[@style='margin-block:12px']//a[contains(text(),'Career Focussed')]")).click();
		Set<String> getwindow = driver.getWindowHandles();
		Iterator<String> it = getwindow.iterator();
		String parentid = it.next();
		String childid = it.next();
		String subchildid = it.next();
		driver.switchTo().window(subchildid);
		
		
		//System.out.println(driver.findElement(By.xpath("//a[@class='theme-btn']/parent::div[@class='form-group text-center']")).getText());
		/*
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailid = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailid); */ 
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
