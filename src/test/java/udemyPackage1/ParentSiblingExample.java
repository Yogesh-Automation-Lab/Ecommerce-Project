package udemyPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ParentSiblingExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
					
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//div/button[2]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//div/button[3]/parent::div/button[1]")).getText());
		driver.close();
		

	}

}
