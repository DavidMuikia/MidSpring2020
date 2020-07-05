package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		// Identifying the username field pass username
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		// Identifying the password field pass password
		driver.findElement(By.id("password")).sendKeys("abc123");

		// Identifying the signin button and click
		driver.findElement(By.name("login")).click();

		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
		
		WebElement COUNTRY_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel = new Select(COUNTRY_DROPDOWN_LOCATOR);
		sel.selectByVisibleText("Armenia");
		
		

		driver.close();
		driver.quit();

	}
}
