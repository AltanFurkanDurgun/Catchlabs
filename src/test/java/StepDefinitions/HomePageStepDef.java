package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferMoneyPage;
import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageStepDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TransferMoneyPage transferMoneyPage = new TransferMoneyPage();

    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Verify that the user should be on login page")
    public void verifyThatTheUserShouldBeOnLoginPage() {
        homePage.verifyTabTitle("login", loginPage.usernameInputBox);
    }

    @When("User can login")
    public void userCanLogin() {
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @Then("Verify that the user should be on home page")
    public void verifyThatTheUserShouldBeOnHomePage() {
        homePage.verifyTabTitle("apps", homePage.openMoneyTransfer);
    }


    @When("User can click open money transfer button")
    public void userCanClickOpenMoneyTransferButton() {
        BrowserUtils.waitForClickability(homePage.openMoneyTransfer, 15);
        homePage.openMoneyTransfer.click();
    }

    @Then("Verify that the user should be on money transfer page")
    public void verifyThatTheUserShouldBeOnMoneyTransferPage() {

        homePage.verifyTabTitle("money-transfer", transferMoneyPage.transferMoneyButton);


    }


}
