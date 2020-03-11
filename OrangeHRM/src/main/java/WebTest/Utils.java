package WebTest;

import org.openqa.selenium.By;

import org.junit.Assert;

public class Utils extends BasePage
{
    public void enterText(By by, String text)
    {
        driver.findElement( by ).sendKeys( text );
    }
    public void clickOnElement(By by)
    {
        driver.findElement( by ).click();
    }
    public void assertURL(String text)
    {
        Assert.assertTrue( driver.getCurrentUrl().contains( text ));
    }
    public static String getTextFromElement(By by)
    {
        String get_text = driver.findElement( by ).getText();
        return get_text;
    }
    public void assertTextMessage(String message, String expected, By by)
    {
        String actual = getTextFromElement( by );
        Assert.assertEquals( message, expected,actual );
    }


}
