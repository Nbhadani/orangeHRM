package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    private By _userName = By.id("txtUsername");
    private By _password = By.id("txtPassword");
    private By _logInButton =By.id("btnLogin");
    private By _errorMessage =By.id("spanMessage");

    public void verifyUserIsOnHomePage()
    {
        assertURL( "https://opensource-demo.orangehrmlive.com/" );
    }
    public void userEntersLogInDetails(String Username,String Password)
    {
        enterText( _userName, Username );
        enterText( _password, Password );
    }
    public void userClicksOnLoginButton()
    {
        clickOnElement( _logInButton );
    }
    public void userSeeErrorMessage(String ErrorMessage)
    {
        String expected = ErrorMessage;
        assertTextMessage( "", expected, _errorMessage);
    }


}
