/**
 * @author Mawaddah Hanbali
 */
package ass2W10D4;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromWebDriverAss2W10D4 {
	public WebDriver driver;

	@BeforeSuite
	public void chromepage() throws MalformedURLException {
		// set configuration
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Windows");
		cap.setCapability("se:name", "My simple test");
		cap.setCapability("se:sampleMetadata", "Sample metadata value");
		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		// RemoteWebDriver
		driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), cap);

		// open codingdojo website
		driver.get("https://www.codingdojo.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	@Test
	public void verifyYahooPageTitle() {
		// open yahoo page
		System.out.println(" Browse yahoo home page ");
		driver.navigate().to("https://login.yahoo.com");
		String strPageTitle = driver.getTitle();
		System.out.println(" Verifying yahoo homepage title ");
		Assert.assertTrue(true, "Yahoo");
		System.out.println(" Yahoo homepage title match. **");
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}

}
