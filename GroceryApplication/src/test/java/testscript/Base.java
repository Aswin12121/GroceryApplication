
package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenShotUtilities;
import utilities.WaitUtilities;

public class Base {
	public WebDriver driver;
	public FileInputStream fileinputstream;
	public Properties properties;
	@BeforeMethod
	@Parameters("browser")
	
	public void browserInitialization(String browser) throws Exception
	{
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
			//driver.get("https://groceryapp.uniqassosiates.com/admin");
			//driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
			//driver.get("https://groceryapp.uniqassosiates.com/admin");
			//driver.manage().window().maximize();
		}
		else
		{
			throw new Exception("invalid");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICITWAIT));
		driver.manage().window().maximize();

	}
	@AfterMethod
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus() == ITestResult.FAILURE)
		{
			ScreenShotUtilities screenshotutilities = new ScreenShotUtilities();
			screenshotutilities.getScreenShot(driver, iTestResult.getName());
		}
		//driver.quit();
		//driver.close();
	}

}
