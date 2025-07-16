package ecommerceproject.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		String productname = "IPHONE 13 PRO";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		//yogesh@testing.com and Yogesh@1234
		//yogesh@org.com and Yogeshyogesh@1234
		//-------------Login Details---------
		driver.findElement(By.id("userEmail")).sendKeys("yogesh@org.com");
		driver.findElement(By.id("userPassword")).sendKeys("Yogeshyogesh@1234");
		driver.findElement(By.id("login")).click();
		//------------Dashboard-------------
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']/div[@class='card']"));

		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//button[@routerlink='/dashboard/cart']")));
		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		
		//---------------------------Cart product verification--------------------------
		
		List<WebElement> cartProduct = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		boolean match = cartProduct.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		//-------------Product checkout----------------------------------------------
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")), "123").build().perform();
		//driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")).sendKeys("123");
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		//------------final confirmation text--------------------------------------
		String expectedmesage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", expectedmesage);
		//-----closing driver----
		driver.close();
	
	}
}
