package pages;

import org.openqa.selenium.WebDriver;
import locators.LocatorsLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super (driver);
    }

    public AccountPage creatingAccount (String email){

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsLogin.emailCreateLoc));

        getDriver().findElement(LocatorsLogin.emailCreateLoc).clear();
        getDriver().findElement(LocatorsLogin.emailCreateLoc).sendKeys(email);

        getDriver().findElement(LocatorsLogin.createAccountBtn).click();
        Commons.sleep(1500);

        return new AccountPage(getDriver());

    }

    public MyAccountPage login(String email, String userPass) {

        String login = executeLogin(email, userPass);
        return new MyAccountPage(getDriver());

    }

    public String executeLogin (String email, String userPass) {

        getDriver().navigate();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsLogin.signInBtn));

        getDriver().findElement(LocatorsLogin.emailLoc).clear();
        getDriver().findElement(LocatorsLogin.emailLoc).sendKeys(email);

        getDriver().findElement(LocatorsLogin.passwordLoc).clear();
        getDriver().findElement(LocatorsLogin.passwordLoc).sendKeys(userPass);

        getDriver().findElement(LocatorsLogin.signInBtn).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsLogin.alertError));

        String alertError = getDriver().findElement(LocatorsLogin.alertError).getText();
        return alertError;

    }
}
