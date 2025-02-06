package Pages;

import Utilities.BrowserUtils;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class HomePage {

    @FindBy(xpath = "//div[contains(text(),'Open')]")
    public WebElement openMoneyTransfer;








    public void verifyTabTitle(String expectedTitle, WebElement element){
        BrowserUtils.waitForVisibility(element, 15);
        String actualTitle = Driver.get().getTitle();
        assertEquals(expectedTitle, actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);
    }

    public void verifyTitle(WebElement element,String expectedTitle){
        BrowserUtils.waitForVisibility(element, 15);
        String actualTitle = element.getText();
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }






    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
