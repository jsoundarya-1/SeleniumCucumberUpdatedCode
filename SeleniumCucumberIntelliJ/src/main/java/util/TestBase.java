package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase()
    {
        try
        {
           prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/qa/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static WebDriver initialization()
    {

        System.out.println(prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        if(browserName.equals("chrome"))
        {
          System.setProperty("webdriver.chrome.driver","src/test/java/ChromeDriver/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
          driver.get(prop.getProperty("url"));

        }
        return driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }


}
