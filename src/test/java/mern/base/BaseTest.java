package mern.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void browserSetup(@Optional("edge") String browser) throws IOException {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("InternetExplorer")) {
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println(browser + " is not a valid Browser please enter a valid Browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

	}

	// Getter method for driver
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	@AfterMethod
	public void closeWindow() {
		driver.close();
	}
	
	
	

}
