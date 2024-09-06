package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap=new DesiredCapabilities();
				if(os.equalsIgnoreCase("Windows"))
					cap.setPlatform(Platform.WIN10);
				if(br.equalsIgnoreCase("edge"))
					cap.setBrowserName("MicrosoftEdge");
				driver=new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"),cap);
			}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
			switch(br)
			{
			case "chrome":driver=new ChromeDriver(); break;
			case "edge":driver=new EdgeDriver(); break;
			default: System.out.println("invalid browser");return;
			}
			}
		
		logger=LogManager.getLogger(this.getClass());
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String s=RandomStringUtils.randomAlphabetic(5);
		return s;
	}
	
	public String randomNumber()
	{
		String s=RandomStringUtils.randomNumeric(5);
		return s;
	}
	
	public String randomAlphabetic()
	{
		String p=RandomStringUtils.randomAlphabetic(5);
		String s=RandomStringUtils.randomNumeric(5);
		return (p+"@"+s);
	}
	
	public String captureScreen(String tname)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String targetpath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp;
		File target=new File(targetpath);
		source.renameTo(target);
		return targetpath;
		
	}
	
	
}
