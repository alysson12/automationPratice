package pages;

import locators.LocatorsDresses;
import locators.LocatorsMyAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;

import java.util.function.Consumer;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super (driver);
    }

    public ProductPage goShopping(){

        Actions actions = new Actions(driver);

        Consumer< By > hover = (By by) -> {
            actions.moveToElement(driver.findElement(by))
                    .perform();
        };

        hover.accept(LocatorsMyAccount.dressesMenu);
        Commons.sleep(300);

        hover.accept(LocatorsMyAccount.eveningDressesMenu);
        driver.findElement(LocatorsMyAccount.eveningDressesMenu).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsDresses.sortByLoc));

        return new ProductPage(getDriver());

    }



}
