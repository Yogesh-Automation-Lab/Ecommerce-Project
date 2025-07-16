package udemyPackage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InvokeBrowsers {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "D:/ChromeDriver/edgedriver_win64/msedgedriver.exe");
		WebDriver driver1 = new EdgeDriver();	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		driver1.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		//driver.close();

	}

}
