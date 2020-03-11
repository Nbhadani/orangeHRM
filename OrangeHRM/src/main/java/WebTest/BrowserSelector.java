package WebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;


public class BrowserSelector extends Utils
{
    // browser setup method
    public void setUpBrowser()
    {
        // object created for LoadProp class
        LoadProp loadProp = new LoadProp();
        // get  browser from config.properties
        String browser = loadProp.getProperty( "browser" );

        // chrome browser properties
        if (browser.equalsIgnoreCase( "chrome" ))
        {
            // set properties and path for chrome driver
            System.setProperty( "webdriver.chrome.driver", "src/test/Resources/BrowserDriver/chromedriver.exe" );
            driver = new ChromeDriver(  );
            // driver.manage().window().fullscreen();
            // implicitly wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // get url from config.properties by using LoadProp
            driver.get( loadProp.getProperty( "url" ) );
        }
        // firefox browser properties and path
        else if (browser.equalsIgnoreCase( "firefox" ))
        {
            // set properties for firefox  browser and path
            System.setProperty( "webdriver.gecko.driver", "src/test/Resources/BrowserDriver/geckodriver.exe" );
            driver = new FirefoxDriver();
            // driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            // get url from testdata using LoadProp
            driver.get( loadProp.getProperty( "url" ) );
        }

        //  internet explorer path and properties
   //     else if (browser.equalsIgnoreCase( "ie" ))
//        {
//            System.setProperty("webdriver.ie.driver", "src/test/Resources/BrowserDriver/IEDriverServer.exe");
//            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//
//            ieCapabilities.setCapability("nativeEvents", false);
//            ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
//            ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
//            ieCapabilities.setCapability("disable-popup-blocking", true);
//            ieCapabilities.setCapability("enablePersistentHover", true);
//
//            driver = new InternetExplorerDriver(ieCapabilities);
//            //driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            // get url from Test data
//            driver.get( loadProp.getProperty( "url" ) );
//
//        }
        else
        {
            // error message for entering invalid or wrong browser
            System.out.println("Browser name is wrong or empty :"+browser);
        }
    }
}
