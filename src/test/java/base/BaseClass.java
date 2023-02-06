package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	private final String _driverUrl = "/Users/jovasguzman/Selenium/drivers/chromedriver_mac64/chromedriver";
	public final String pageUrl = "https://advantageonlineshopping.com";
	public WebDriver driver;
	
	@BeforeClass
	public void setUpClass() {
		System.setProperty("webdriver.chrome.driver", _driverUrl);
		driver = new ChromeDriver();
		driver.get(pageUrl);
		driver.manage().window().maximize();
	}
}
