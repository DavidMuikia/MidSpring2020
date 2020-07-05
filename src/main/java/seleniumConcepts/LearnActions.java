package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActions {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.techfios.com/ibilling/?ng=admin/ ");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		//Identifying the username field
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		//Identifying the password field password
		driver.findElement(By.id("password")).sendKeys("abc123");

		// Identifying the signin button and click
		// driver.findElement(By.name("login")).click();

		// Keyboard keys
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

		driver.close();
		driver.quit();

	}
}
