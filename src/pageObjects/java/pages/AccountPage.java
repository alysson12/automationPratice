package pages;

import locators.LocatorsAccount;
import objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver){
        super (driver);
    }

    public String createDetailedAccount(User user){

        getDriver().navigate();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsAccount.accountForm));

        getDriver().findElement(LocatorsAccount.genderRadio).click();

        /* PERSONAL */
        getDriver().findElement(LocatorsAccount.customerFirstNameLoc).clear();
        getDriver().findElement(LocatorsAccount.customerFirstNameLoc).sendKeys(user.getFirstName());
        getDriver().findElement(LocatorsAccount.customerLastNameLoc).clear();
        getDriver().findElement(LocatorsAccount.customerLastNameLoc).sendKeys(user.getLastName());
        getDriver().findElement(LocatorsAccount.firstNameLoc).clear();
        getDriver().findElement(LocatorsAccount.firstNameLoc).sendKeys(user.getFirstName());
        getDriver().findElement(LocatorsAccount.lastNameLoc).clear();
        getDriver().findElement(LocatorsAccount.lastNameLoc).sendKeys(user.getLastName());
        getDriver().findElement(LocatorsAccount.passwordLoc).clear();
        getDriver().findElement(LocatorsAccount.passwordLoc).sendKeys(user.getPassword());

        Select dayBirthSelect = new Select(getDriver().findElement(LocatorsAccount.dateDaysDrp));
        dayBirthSelect.selectByValue(Integer.toString(user.getDayBirth()));
        Select monthBirthSelect = new Select(getDriver().findElement(LocatorsAccount.dateMonthsDrp));
        monthBirthSelect.selectByValue(Integer.toString(user.getMonthBirth()));
        Select yearBirthSelect = new Select(getDriver().findElement(LocatorsAccount.dateYearsDrp));
        yearBirthSelect.selectByValue(Integer.toString(user.getYearBirth()));

        /* ADDRESS */
        getDriver().findElement(LocatorsAccount.companyLoc).clear();
        getDriver().findElement(LocatorsAccount.companyLoc).sendKeys(user.getCompany());
        getDriver().findElement(LocatorsAccount.address1Loc).clear();
        getDriver().findElement(LocatorsAccount.address1Loc).sendKeys(user.getAddress1());
        getDriver().findElement(LocatorsAccount.address2Loc).clear();
        getDriver().findElement(LocatorsAccount.address2Loc).sendKeys(user.getAddress2());
        getDriver().findElement(LocatorsAccount.cityLoc).clear();
        getDriver().findElement(LocatorsAccount.cityLoc).sendKeys(user.getCity());

        Select stateSelect = new Select(getDriver().findElement(LocatorsAccount.stateDrp));
        stateSelect.selectByVisibleText(user.getState());

        getDriver().findElement(LocatorsAccount.zipCodeLoc).clear();
        getDriver().findElement(LocatorsAccount.zipCodeLoc).sendKeys(user.getZipCode());

        Select countrySelect = new Select(getDriver().findElement(LocatorsAccount.countryDrp));
        countrySelect.selectByVisibleText(user.getCountry());

        getDriver().findElement(LocatorsAccount.phoneLoc).clear();
        getDriver().findElement(LocatorsAccount.phoneLoc).sendKeys(user.getHomePhone());
        getDriver().findElement(LocatorsAccount.mobilePhoneLoc).clear();
        getDriver().findElement(LocatorsAccount.mobilePhoneLoc).sendKeys(user.getMobilePhone());
        getDriver().findElement(LocatorsAccount.addressAliasLoc).clear();
        getDriver().findElement(LocatorsAccount.addressAliasLoc).sendKeys(user.getAddressAlias());

        getDriver().findElement(LocatorsAccount.submitBtn).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsAccount.alertError));

        String alertError = getDriver().findElement(LocatorsAccount.alertError).getText();
        return alertError;

    }

}
