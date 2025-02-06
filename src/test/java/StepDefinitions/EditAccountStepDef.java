package StepDefinitions;

import Pages.EditAccountPage;
import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.*;

public class EditAccountStepDef {

    String newAccountName;

    EditAccountPage editAccountPage = new EditAccountPage();


    @When("User can click edit account button")
    public void userCanClickEditAccountButton() {
        BrowserUtils.waitForClickability(editAccountPage.editAccountText, 15);
        editAccountPage.editAccountText.click();
    }

    @Then("Verify that the user should be see account name title")
    public void verifyThatTheUserShouldBeSeeAccountNameTitle() {
        editAccountPage.verifyTitle(editAccountPage.accountNameText,"Account name");


    }

    @And("User can clear account name input box")
    public void userCanClearAccountNameInputBox() {
        Actions action = new Actions(Driver.get());
        action.moveToElement(editAccountPage.accountNameInputBox).doubleClick().sendKeys(Keys.BACK_SPACE).perform();


    }

    @Then("Verify that the user should be see account name text box as empty")
    public void verifyThatTheUserShouldBeSeeAccountNameTextBoxAsEmpty() {
        String textBoxAttr = editAccountPage.accountNameInputBox.getAttribute("value");
        assertEquals("", textBoxAttr);
    }

    @Then("Verify that the user should be see update button as disable")
    public void verifyThatTheUserShouldBeSeeUpdateButtonAsDisable() {
        BrowserUtils.waitForVisibility(editAccountPage.updateButton, 15);
        String updateButtonAttr = editAccountPage.updateButton.getAttribute("tabindex");
        String expectedUpdateBtnAttr = "-1";
        System.out.println("updateButtonAttr = " + updateButtonAttr);
        System.out.println("expectedUpdateBtnAttr = " + expectedUpdateBtnAttr);
        if (updateButtonAttr.equals("-1")) {
            System.out.println("Update button disable");

        } else {
            System.out.println("Update button enable");
        }

        assertEquals(expectedUpdateBtnAttr, updateButtonAttr);


    }


    @When("User enter just numeric value on account name input box")
    public void userEnterJustNumericValueOnAccountNameInputBox() {
        BrowserUtils.waitForVisibility(editAccountPage.accountNameInputBox, 15);
        editAccountPage.accountNameInputBox.sendKeys("12321314");
    }

    @When("User update account name as text value")
    public void userUpdateAccountNameAsTextValue() {
        newAccountName = "Update";
        BrowserUtils.waitForVisibility(editAccountPage.accountNameInputBox, 15);
        editAccountPage.accountNameInputBox.sendKeys(newAccountName);

    }

    @And("User can click update button")
    public void userCanClickUpdateButton() {
        BrowserUtils.waitForClickability(editAccountPage.updateButton,15);
        editAccountPage.updateButton.click();
    }

    @Then("Verify that the user should be see updated account name on my account place")
    public void verifyThatTheUserShouldBeSeeUpdatedAccountNameOnMyAccountPlace() {
        BrowserUtils.waitFor(2);
        editAccountPage.verifyTitle(editAccountPage.accountNamePlace, newAccountName);
    }
}
