package roadshow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.Arguments;
import io.github.bonigarcia.DriverCapabilities;
import io.github.bonigarcia.DriverUrl;
import io.github.bonigarcia.SeleniumExtension;
import io.github.bonigarcia.wdm.WebDriverManager;

@ExtendWith(SeleniumExtension.class)
public class TestGoogleIT {
	
	@DriverUrl
    private static final String url = "http://localhost:4444/wd/hub";

	@BeforeAll
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
    @Test
    public void testHeadlessChrome(@Arguments("--headless") ChromeDriver driver) {
    	performTest(driver);
    }
    
    @Test
    public void testChrome(ChromeDriver driver) {
    	performTest(driver);
    }
    
    /**
     * TODO: Get Grid tests working with headless. Also need to set up and run a grid from the test for demo purposes if not doing that through IaC.
     */
    
    @Test
    public void testChromeGrid(@DriverCapabilities("browserName=chrome") RemoteWebDriver driver) {
    	performTest(driver);
    }
    
    @Test
    public void testFirefoxGrid(@DriverCapabilities("browserName=firefox") RemoteWebDriver driver) {
    	performTest(driver);
    }
    
    private void performTest(WebDriver wd) {
    	wd.get("https://www.google.com");
    }
}