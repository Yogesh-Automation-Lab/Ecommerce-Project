package udemyPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FrameTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		//driver.switchTo().defaultContent();
		
		String expectedtext = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		String actualtext = "Dropped!";
		Assert.assertEquals(expectedtext, actualtext);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
