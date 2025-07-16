package udemyPackage1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabClick {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//identify footer section
		/*
		
		 
		 */
		System.out.println(driver.findElements(By.tagName("a")).size()); 
		WebElement footersection = driver.findElement(By.id("gf-BIG"));
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement columnsection = footersection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(driver.findElements(By.tagName("a")).size()); //27
		
		for(int i=1;i<columnsection.findElements(By.tagName("a")).size();i++)
		{
			String clicktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnsection.findElements(By.tagName("a")).get(i).sendKeys(clicktab);
			Thread.sleep(2000L);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
						
		}
	
	}
		

}
