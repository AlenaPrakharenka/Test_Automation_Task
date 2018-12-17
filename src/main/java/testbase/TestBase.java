package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public static WebDriver driver = null;

    public static WebDriver openBrowser(){
    	
        getDriver("browser");
        driver.manage().window().maximize();
        driver.navigate().to(findProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
        
    }

    private static String findProperty(String propertyName){
        try {
            InputStream in = new FileInputStream("src\\main\\resources\\browser.properties");
            Properties properties=new Properties();
            properties.load(in);
            return properties.getProperty(propertyName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static void getDriver(String browserName){
        switch (findProperty(browserName)){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","src\\main\\resources\\browser\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver","src\\main\\resources\\browser\\MicrosoftWebDriver.exe");
                driver= new InternetExplorerDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
                driver= new ChromeDriver();
                break;
        }
    }
}
