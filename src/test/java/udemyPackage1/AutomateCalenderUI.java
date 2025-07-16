package udemyPackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateCalenderUI {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String date = "06";
		String month = "5";
		String year = "2027";
		String[] expecteddate = {month,date,year};
		
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElement(By.xpath("//abbr[text()='May']")).click();
		driver.findElement(By.xpath("//abbr[text()='21']")).click();
//		String actualdate = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@value='2027-05-21']")).getText();
//		System.out.println(actualdate);
//		String expecteddate = "05/21/2027";
//		//Assert.assertEquals(expecteddate, actualdate);
		List<WebElement> actualdate = driver.findElements(By.xpath("//div[@class='react-date-picker__inputGroup']"));
		for(int i=0;i<actualdate.size();i++)
		{
			System.out.println(actualdate.get(i).getAttribute("value"));
		}
		
		driver.close();
		

	}

}
