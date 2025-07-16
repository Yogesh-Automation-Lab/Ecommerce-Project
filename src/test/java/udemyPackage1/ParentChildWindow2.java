package udemyPackage1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentChildWindow2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        // Click 'Free Access' - opens a new window
        driver.findElement(By.xpath("//a[contains(text(),'Free Access')]")).click();

        // Switch to child window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        // Wait and click element in child window (to open subchild)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subChildLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='login-btn']/a[@class='theme-btn register-btn']")
        ));
        subChildLink.click(); // Opens subchild tab

//        // Now switch to subchild window
//        Set<String> allWindows = driver.getWindowHandles();
//        for (String win : allWindows) {
//            if (!win.equals(parentId) && !win.equals(childId)) {
//                driver.switchTo().window(win); // Subchild window
//                break;
//            }
//        }

        // Now you're on subchild window. Perform action here
        System.out.println("Subchild URL: " + driver.getCurrentUrl());

        // Add your next steps here...
        driver.switchTo().defaultContent();
        
        driver.quit();
	
	}

}
