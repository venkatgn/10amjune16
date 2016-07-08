package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Re_Test 
{

	WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void reTest(String br) throws Exception
	{
		if(br.matches("ff"))
		{
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		Home h=new Home(driver);
		h.validate_links();
		//h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		//c.sendmail();
		c.logout();
	}
}
