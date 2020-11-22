package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public WebDriver intializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		prop.load(fis);
		String Browser=prop.getProperty("browser");
		System.out.println(Browser);
		if(Browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsh\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else  {
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		//driver.get(prop.getProperty("screenshot"));
		return driver;
		
		

	}



	public String getscreenshot(String testCaseName, WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		//FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(scrFile,new File(destinationFile));
		return destinationFile;
	}
}
	