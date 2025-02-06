package StepDefinitions;

import Pages.AddMoneyPage;
import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AddMoneyStepDef {

    String amountText, userAmountInput;
    double amount, addedAmount, expectedTotalAmount;
    NumberFormat format = NumberFormat.getInstance(Locale.US);
    SoftAssert softAssert = new SoftAssert();
    AddMoneyPage addMoneyPage = new AddMoneyPage();

    @When("User can click add money button")
    public void userCanClickAddMoneyButton() throws ParseException {
        BrowserUtils.waitForVisibility(addMoneyPage.addMoneyText, 15);
        amountText = addMoneyPage.amountText.getText();
        amount = format.parse(amountText).doubleValue();
        addMoneyPage.addMoneyText.click();
    }

    @Then("Verify that the user should be on add money page")
    public void verifyThatTheUserShouldBeOnAddMoneyPage() {
        addMoneyPage.verifyTitle(addMoneyPage.cardNumberText, "Card number");

    }

    @When("User can enter card number")
    public void userCanEnterCardNumber() {
        BrowserUtils.waitForVisibility(addMoneyPage.cardNumberInputBox, 15);
        addMoneyPage.cardNumberInputBox.sendKeys(ConfigurationReader.get("cardNumber"));

    }

    @And("User can enter card holder")
    public void userCanEnterCardHolder() {
        BrowserUtils.waitForVisibility(addMoneyPage.cardHolderInputBox, 15);
        addMoneyPage.cardHolderInputBox.sendKeys("Test test");
    }

    @And("User can enter expiry date")
    public void userCanEnterExpiryDate() {
        BrowserUtils.waitForVisibility(addMoneyPage.expiryDateInputBox, 15);
        addMoneyPage.expiryDateInputBox.sendKeys(ConfigurationReader.get("expiryDate"));

    }

    @And("User can enter cvv code")
    public void userCanEnterCvvCode() {
        BrowserUtils.waitForVisibility(addMoneyPage.cvvInputBox, 15);
        addMoneyPage.cvvInputBox.sendKeys(ConfigurationReader.get("cvv"));
    }

    @And("User can enter amount")
    public void userCanEnterAmount() {
        System.out.println("amount = " + amount);
        userAmountInput = "1000.0";
        BrowserUtils.waitForVisibility(addMoneyPage.amountInputBox, 15);
        addMoneyPage.amountInputBox.sendKeys(userAmountInput);
        addedAmount = Double.parseDouble(userAmountInput);
        expectedTotalAmount = amount + addedAmount;
        System.out.println("amount = " + amount + " " + addedAmount);
        System.out.println("expectedTotalAmount = " + expectedTotalAmount);
    }

    @And("User can click add button")
    public void userCanClickAddButton() {
        BrowserUtils.waitForClickability(addMoneyPage.addButton, 15);
        addMoneyPage.addButton.click();
    }

    @Then("Verify that the user should be see total amount is correct")
    public void verifyThatTheUserShouldBeSeeTotalAmountIsCorrect() throws ParseException {
        BrowserUtils.waitForVisibility(addMoneyPage.amountText, 15);
        String actualTotalAmount = addMoneyPage.amountText.getText();
        System.out.println("actualTotalAmount = " + actualTotalAmount);
        double totalAmountMyAccount = format.parse(actualTotalAmount).doubleValue();
        System.out.println("Total amount my account place= " + totalAmountMyAccount);
        softAssert.assertEquals(expectedTotalAmount, totalAmountMyAccount);


    }

    @And("Verify that the user should be see amount is correct in transactions place")
    public void verifyThatTheUserShouldBeSeeAmountIsCorrectInTransactionsPlace() throws ParseException {
        BrowserUtils.waitForVisibility(addMoneyPage.amountTextTransactions, 15);
        String actualAmountTransaction = addMoneyPage.amountTextTransactions.getText();
        double amountTransaction = format.parse(actualAmountTransaction).doubleValue();
        Assert.assertEquals(addedAmount, amountTransaction, 0);
        System.out.println("actual amount transaction = " + amountTransaction);
        System.out.println("User added amount = " + addedAmount);
        BrowserUtils.waitFor(2);
        softAssert.assertAll();

    }

    @Then("Verify that the user should be see all {string} warning message")
    public void verifyThatTheUserShouldBeSeeAllWarningMessage(String expectedWarningMessage) {
        String actualWarningMessage;
        for (int i = 0; i < addMoneyPage.requiredWarningMessage.size(); i++) {

            actualWarningMessage = addMoneyPage.requiredWarningMessage.get(i).getText();
            Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
            System.out.println("actualWarningMessage = " + actualWarningMessage);

        }

    }

    @When("User can enter {string} on card number input box")
    public void userCanEnterOnCardNumberInputBox(String cardNumberValue) {
        addMoneyPage.cardNumberInputBox.sendKeys(cardNumberValue);
    }

    @And("User can enter {string} on card holder input box")
    public void userCanEnterOnCardHolderInputBox(String cardHolderValue) {
        addMoneyPage.cardHolderInputBox.sendKeys(cardHolderValue);
    }

    @And("User can enter {string} on expiry date input box")
    public void userCanEnterOnExpiryDateInputBox(String expiryDateValue) {
        addMoneyPage.expiryDateInputBox.sendKeys(expiryDateValue);
    }

    @And("User can enter {string} on cvv input box")
    public void userCanEnterOnCvvInputBox(String cvvValue) {
        addMoneyPage.cvvInputBox.sendKeys(cvvValue);
    }

    @Then("Verify that the user should be see {string} warning message on card number input box")
    public void verifyThatTheUserShouldBeSeeWarningMessageOnCardNumberInputBox(String expectedWarningMessage) {
        addMoneyPage.verifyWarningMessage(addMoneyPage.tooShortWarningMessage.get(0), expectedWarningMessage);


    }

    @Then("Verify that the user should be see {string} warning message on card holder input box")
    public void verifyThatTheUserShouldBeSeeWarningMessageOnCardHolderInputBox(String expectedWarningMessage) {

        addMoneyPage.verifyWarningMessage(addMoneyPage.tooShortWarningMessage.get(1), expectedWarningMessage);

    }

    @Then("Verify that the user should be see {string} warning message on expiry date input box")
    public void verifyThatTheUserShouldBeSeeWarningMessageOnExpiryDateInputBox(String expectedWarningMessage) {

        addMoneyPage.verifyWarningMessage(addMoneyPage.wrongDateWarningMessage, expectedWarningMessage);

    }

    @Then("Verify that the user should be see {string} warning message on cvv input box")
    public void verifyThatTheUserShouldBeSeeWarningMessageOnCvvInputBox(String expectedWarningMessage) {

        addMoneyPage.verifyWarningMessage(addMoneyPage.cvvWarningMessage, expectedWarningMessage);


    }
}
