package StepDefinitions;

import Pages.AddMoneyPage;
import Pages.TransferMoneyPage;
import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TransferMoneyStepDef {

    String senderAccount, receiverAccount, expectedAmount,totalAmountText;
    double totalAmount, transferAmount, remainingTotalAmount;
    TransferMoneyPage transferMoneyPage = new TransferMoneyPage();
    SoftAssert softAssert = new SoftAssert();
    NumberFormat format = NumberFormat.getInstance(Locale.US);
    AddMoneyPage addMoneyPage = new AddMoneyPage();

    @When("User can click transfer money button")
    public void userCanClickTransferMoneyButton() throws ParseException {
        totalAmountText = addMoneyPage.amountText.getText();
        System.out.println("total amount text before transfer = " + totalAmountText);
        totalAmount= format.parse(totalAmountText).doubleValue();
        BrowserUtils.waitForClickability(transferMoneyPage.transferMoneyButton, 15);
        transferMoneyPage.transferMoneyButton.click();

    }

    @Then("Verify that the user should be see {string} header")
    public void verifyThatTheUserShouldBeSeeHeader(String expectedHeader) {
        transferMoneyPage.verifyTitle(transferMoneyPage.senderAccountHeader, expectedHeader);

    }

    @And("Verify that the user should be see sender account and receiver account")
    public void verifyThatTheUserShouldBeSeeSenderAccountAndReceiverAccount() {
        Select select = new Select(transferMoneyPage.senderAccountDropDown);
        senderAccount = select.getFirstSelectedOption().getText();
        System.out.println("Sender account= " + senderAccount);
        Select select1 = new Select(transferMoneyPage.receiverAccountDropDown);
        receiverAccount = select1.getFirstSelectedOption().getText();
        System.out.println("receiverAccount = " + receiverAccount);
    }

    @When("User can enter amount for transfer money")
    public void userCanEnterAmountForTransferMoney() throws ParseException {
        expectedAmount = "100.0";
        transferAmount = format.parse(expectedAmount).doubleValue();
        BrowserUtils.waitForVisibility(transferMoneyPage.amountInputBox, 15);
        transferMoneyPage.amountInputBox.sendKeys(expectedAmount);

    }

    @And("User can click send button")
    public void userCanClickSendButton() {
        BrowserUtils.waitForClickability(transferMoneyPage.sendButton, 15);
        transferMoneyPage.sendButton.click();

    }

    @Then("Verify that the user should be see sender on transactions place")
    public void verifyThatTheUserShouldBeSeeSenderOnTransactionsPlace() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(transferMoneyPage.allTransactionInfo.get(1), 15);
        String actualSender = transferMoneyPage.allTransactionInfo.get(1).getText();
        System.out.println("actualSender = " + actualSender);
        System.out.println("expectedSender = " + senderAccount);
        Assert.assertEquals(senderAccount, actualSender);

    }

    @And("Verify that the user should be see receiver on transactions place")
    public void verifyThatTheUserShouldBeSeeReceiverOnTransactionsPlace() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(transferMoneyPage.allTransactionInfo.get(3), 15);
        String actualReceiver = transferMoneyPage.allTransactionInfo.get(3).getText();
        System.out.println("actualReceiver = " + actualReceiver);
        System.out.println("expectedReceiver = " + receiverAccount);
        Assert.assertEquals(receiverAccount, actualReceiver);

    }

    @And("Verify that the user should be see amount on transactions place")
    public void verifyThatTheUserShouldBeSeeAmountOnTransactionsPlace() {
        BrowserUtils.waitForVisibility(transferMoneyPage.allTransactionInfo.get(8), 15);
        String actualAmount = transferMoneyPage.allTransactionInfo.get(8).getText();
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("actualAmount = " + actualAmount);
        softAssert.assertEquals(actualAmount,expectedAmount);

    }

    @When("User can change receiver account")
    public void userCanChangeReceiverAccount() {

        Select select = new Select(transferMoneyPage.receiverAccountDropDown);
        select.selectByVisibleText("Testinium-2");
        Alert alert = Driver.get().switchTo().alert();
        String alertMessage = Driver.get().switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        alert.accept();
        receiverAccount = select.getFirstSelectedOption().getText();
        System.out.println("receiverAccount = " + receiverAccount);
        Select select1 = new Select(transferMoneyPage.senderAccountDropDown);
        senderAccount = select1.getFirstSelectedOption().getText();
        System.out.println("senderAccount = " + senderAccount);



    }

    @And("Verify that the user should be see total amount on my account place")
    public void verifyThatTheUserShouldBeSeeTotalAmountOnMyAccountPlace() throws ParseException {
        remainingTotalAmount = totalAmount-transferAmount;
        BrowserUtils.waitForVisibility(addMoneyPage.amountText,15);
        totalAmountText = addMoneyPage.amountText.getText();
        totalAmount = format.parse(totalAmountText).doubleValue();
        System.out.println("Expected remaining total amount = " + remainingTotalAmount);
        System.out.println("Actual remaining total amount = " + totalAmount);
        softAssert.assertEquals(totalAmount,remainingTotalAmount);
        softAssert.assertAll();

    }
}
