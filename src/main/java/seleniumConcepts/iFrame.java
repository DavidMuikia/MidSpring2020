package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class iFrame {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://docs.oracle.com/javase/8/docs/api/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest1() {
				
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt"));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Adjustable")).click();
		
				
		driver.close();
		driver.quit();
	}
}
