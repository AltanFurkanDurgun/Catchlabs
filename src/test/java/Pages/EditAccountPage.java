package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends HomePage {

    @FindBy(xpath = "//div[contains(text(),'Edit account')]")
    public WebElement editAccountText;

    @FindBy(xpath = "//div[contains(text(),'Account name')]")
    public WebElement accountNameText;


    @FindBy(xpath = "//input[@autocapitalize='sentences']")
    public WebElement accountNameInputBox;


    @FindBy(xpath = "//div[contains(text(),'UPDATE')]/..")
    public WebElement updateButton;


    @FindBy(xpath = "((//div[@class='css-175oi2r'])[3]//div)[2]")
    public WebElement accountNamePlace;





}
