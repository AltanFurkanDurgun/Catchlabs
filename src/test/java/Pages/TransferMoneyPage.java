package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransferMoneyPage extends HomePage{

    @FindBy(xpath = "//div[contains(text(),'Transfer money')]")
    public WebElement transferMoneyButton;

    @FindBy(xpath = "//div[text()='Sender account']")
    public WebElement senderAccountHeader;

    @FindBy(xpath = "(//div//select)[1]")
    public WebElement senderAccountDropDown;

    @FindBy(xpath = "(//div//select)[2]")
    public WebElement receiverAccountDropDown;

    @FindBy(xpath = "//div//input")
    public WebElement amountInputBox;

    @FindBy(xpath = "//div[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@class='css-175oi2r r-18u37iz r-13qz1uu']//div")
    public List<WebElement> allTransactionInfo;











}
