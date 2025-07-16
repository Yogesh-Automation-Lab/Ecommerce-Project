package udemyPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='DEL']")).getText());
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='IXL'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[@value='IXL'])[2]")).getText());
		driver.close();

	}

}
