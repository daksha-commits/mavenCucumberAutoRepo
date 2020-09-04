package mavencucumber.bddsample;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import com.cucumber.listener.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {
	static WebDriver driver = null;

	@Before(order = 1)
	public WebDriver setup() {
		if (driver != null)
			return driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Packages\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("excludeSwitches", new
		// String[]{"enable-automation"});
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public void loginSteps() 
	{
		driver.get("http://groupon.com.au");
		driver.findElement(By.id("nothx")).click();
		driver.findElement(By.id("signin-container")).click();
		// Thread.sleep(5000);
		driver.findElement(By.id("sf-email")).click();
		driver.findElement(By.id("sf-email")).sendKeys("daksha.sosa@gmail.com");
		driver.findElement(By.id("sf-pw")).click();
		driver.findElement(By.id("sf-pw")).sendKeys("DSosa@123");
		driver.findElement(By.className("btn-signin")).click();
		// Thread.sleep(5000); ;
	}

	@After
	public static void teardown() {

	 //  Reporter.loadXMLConfig(new File("src\\test\\resources\\extent-config.xml"));

		driver.quit();
	}

}
