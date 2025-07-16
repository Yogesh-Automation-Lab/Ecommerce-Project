package udemyPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://spicejet.com");
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-7o8qx1']")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-7o8qx1']")).isSelected());
		driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-7o8qx1']")).size();
		Assert.assertEquals(driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-7o8qx1']")).size(), 6);
		driver.findElement(By.cssSelector(".css-76zvg2.css-bfa6kz.r-homxoj.r-ubezar")).click();
		System.out.println(driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid']")).size());
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")), 26);
	//	driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa' and contains(text(),'round trip')]")).click();
		//driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(text(),10)]/parent::div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']")).click();
		driver.close();
	}

}
