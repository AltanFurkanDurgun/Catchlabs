package Pages;

import Utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddMoneyPage extends HomePage {

    @FindBy(xpath = "//div[contains(text(),'Add money')]")
    public WebElement addMoneyText;

    @FindBy(xpath = "//div[contains(text(),'Card number')]")
    public WebElement cardNumberText;

    @FindBy(xpath = "(//div[@class='css-175oi2r r-13qz1uu']//input)[1]")
    public WebElement cardNumberInputBox;

    @FindBy(xpath = "(//div[@class='css-175oi2r r-13qz1uu']//input)[2]")
    public WebElement cardHolderInputBox;

    @FindBy(xpath = "(//div[@class='css-175oi2r r-13qz1uu']//input)[3]")
    public WebElement expiryDateInputBox;

    @FindBy(xpath = "(//div[@class='css-175oi2r r-13qz1uu']//input)[4]")
    public WebElement cvvInputBox;

    @FindBy(xpath = "(//div[@class='css-175oi2r r-13qz1uu']//input)[5]")
    public WebElement amountInputBox;

    @FindBy(xpath = "//div[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "(//div[@class='css-175oi2r'])[10]/div")
    public WebElement amountText;

    @FindBy(xpath = "(//div[@class='css-175oi2r'])[14]/div")
    public WebElement amountTextTransactions;

    @FindBy(xpath = "//div[text()='Required']")
    public List<WebElement> requiredWarningMessage;

    @FindBy(xpath = "//div[text()='Too Short!']")
    public List<WebElement> tooShortWarningMessage;

    @FindBy(xpath = "//div[contains(text(),'Wrong')]")
    public WebElement wrongDateWarningMessage;

    @FindBy(xpath = "//div[contains(text(),'short')]")
    public WebElement cvvWarningMessage;




  public void verifyWarningMessage(WebElement element,String expectedWarningMessage){
      BrowserUtils.waitForVisibility(element, 15);
      String actualWarningMessage = element.getText();
      Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
      System.out.println("expectedWarningMessage = " + expectedWarningMessage);
      System.out.println("actualWarningMessage = " + actualWarningMessage);
  }









}
