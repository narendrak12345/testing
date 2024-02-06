package MainBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static FileInputStream filePath;
	public static Logger log = LogManager.getLogger(BaseTest.class);

	public BaseTest() throws IOException {

		prop = new Properties();
		String home = System.getProperty("user.dir");
		fis = new FileInputStream(home + "\\src\\main\\resources\\Properties\\Testdata.properties");
		prop.load(fis);
		fis1 = new FileInputStream(home + "\\src\\main\\resources\\logs\\log4j2.properties");
		prop.load(fis);
		//log.info("Loading files");
	}
	
	public String getFileLink(String fileName) {
		String home = System.getProperty("user.dir");
        String filePath =  home + "\\src\\test\\resources\\Documents\\"+fileName;
		return filePath;
    }

	public void init() {

		WebDriverManager.chromedriver().setup();
		String browser = prop.getProperty("browser");
		log.info("Launching browser as " + browser);

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			log.info("Launching chrome browser");
			
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			log.info("Launching Firefox browser");
			
		} else if (browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			log.info("Launching IE browser");
		}
			else if (browser.equals("edge")) {
				driver = new EdgeDriver();
				log.info("Launching EdgeDriver");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
		log.info("Opening URL");
		driver.get(prop.getProperty("URL"));
	}
}
