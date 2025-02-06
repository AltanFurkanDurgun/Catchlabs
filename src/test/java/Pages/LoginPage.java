package Pages;

import Utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends HomePage{

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    public WebElement loginButton;



    public void login(String username, String password){
        BrowserUtils.waitForVisibility(usernameInputBox,15);
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        BrowserUtils.waitForClickability(loginButton,15);
        loginButton.click();



    }
}
