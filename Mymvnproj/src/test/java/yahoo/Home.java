package yahoo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Home 
{
    WebDriver driver;
    
    {
    	System.setProperty("atu.reporter.config", "e:/10amjune16/myproj/atu.properties");
    }
	public Home(WebDriver driver)
	{
		this.driver=driver;
	}
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
		
	}
	public void validate_links()
	{
		open();
		String exp[]={"About Mail","Features","Get App","Help"};
		
		WebElement ul=driver.findElement(By.xpath("//ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=ul.findElements(By.xpath("li/a/b"));
		
		for(int i=0;i<exp.length;i++)
		{
			if(exp[i].matches(lst.get(i).getText()))
				ATUReports.add("Link is matching",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			else
				ATUReports.add("Link is NOT matching : "+exp[i],LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		
	}
	public void login() throws Exception
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);		
	}
	public void createacc() throws Exception
	{
		open();
		Thread.sleep(5000);
		driver.findElement(By.id("login-signup")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).sendKeys("abcde");
		//lstname
		//yahooid
		//pwd
		
		new Select(driver.findElement(By.name("shortCountryCode"))).selectByValue("IN");
		driver.findElement(By.name("phone")).sendKeys("9876789098");
		
		new Select(driver.findElement(By.name("mm"))).selectByVisibleText("April");
		new Select(driver.findElement(By.name("dd"))).selectByVisibleText("15");
		new Select(driver.findElement(By.name("yyyy"))).selectByVisibleText("1984");
	}
}
