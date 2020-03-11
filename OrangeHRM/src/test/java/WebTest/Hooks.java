package WebTest;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.deploy.cache.Cache.copyFile;

        import io.cucumber.java.After;
        import io.cucumber.java.Before;
        import io.cucumber.java.Scenario;


public class Hooks extends Utils {
    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
    BrowserSelector browserSelector = new BrowserSelector();

    @Before
    public void openBrowser()
    {browserSelector.setUpBrowser();}

    @After
    public void closeBrowser(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenShotName = scenario.getName().replaceAll("[.,:;?!]", "") + timeStamp + ".png";
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/Destination/screenshots/" + screenShotName);
                copyFile(sourcePath, destinationPath);
                scenario.write("!!!!!!!!!!......Scenario Failed.....!!!!!!!! Please see attached screenshot for the error/issue");
            } catch (IOException e) {
            }
        }
        driver.quit();
        // browserSelector.closeBrowser();
    }
}
