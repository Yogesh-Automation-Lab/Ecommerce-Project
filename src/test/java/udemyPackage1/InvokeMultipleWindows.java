package udemyPackage1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindows {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
		
		System.out.println(driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).getText());
		WebElement link = driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']"));
		File src = 	link.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("error.png"));
		driver.switchTo().window(parentwindow);
		driver.switchTo().defaultContent();
		driver.quit();
		
		
		
	}

}
