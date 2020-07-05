package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class alertPopup {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().getText();
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		driver.switchTo().alert().accept();

		driver.close();
		driver.quit();
	}
}
