package locators;

import org.openqa.selenium.By;

public class LocatorsAccount {

    /* Account Form */
    public static By accountForm = By.id("account-creation_form");

    /* Personal Information */
    public static By genderRadio = By.id("id_gender1");
    public static By customerFirstNameLoc = By.id("customer_firstname");
    public static By customerLastNameLoc = By.id("customer_lastname");

    public static By emailLoc = By.id("email");
    public static By passwordLoc = By.id("passwd");

    public static By dateDaysDrp = By.id("days");
    public static By dateMonthsDrp = By.id("months");
    public static By dateYearsDrp = By.id("years");

    /* Adress Information */
    public static By firstNameLoc = By.id("firstname");
    public static By lastNameLoc = By.id("lastname");
    public static By companyLoc = By.id("company");

    public static By address1Loc = By.id("address1");
    public static By address2Loc = By.id("address2");
    public static By cityLoc = By.id("city");
    public static By stateDrp = By.id("id_state");
    public static By zipCodeLoc = By.id("postcode");
    public static By countryDrp = By.id("id_country");

    public static By otherLoc = By.id("other");
    public static By phoneLoc = By.id("phone");
    public static By mobilePhoneLoc = By.id("phone_mobile");
    public static By addressAliasLoc = By.id("alias");

    /* Register - Button */
    public static By submitBtn = By.id("submitAccount");

    /* Alert Error*/
    public static By alertError = By.xpath("/html/body/div/div[2]/div/div[3]/div/div");

}
