package pages;

import locators.LocatorsProduct;
import objects.Dress;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;

import java.util.function.Consumer;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super (driver);
    }

    public CartSummaryPage selectDresses(Dress dress1, Dress dress2){

        Actions actions = new Actions(driver);

        Consumer<By> hover = (By by) -> {
            actions.moveToElement(driver.findElement(by))
                    .perform();
        };

        hover.accept(LocatorsProduct.dressLoc);
        driver.findElement(LocatorsProduct.dressLoc).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsProduct.addCartBtn));

        addToCar(dress1);
        Commons.sleep(1000);
        driver.findElement(LocatorsProduct.spanContinueShopping).click();

        addToCar(dress2);
        Commons.sleep(1500);
        driver.findElement(LocatorsProduct.checkoutBtn).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsProduct.spanContinueShopping));

        return new CartSummaryPage(getDriver());

    }

    public void addToCar(Dress dress){

        Select stateSelect = new Select(getDriver().findElement(LocatorsProduct.dressSizeLoc));
        stateSelect.selectByVisibleText(dress.size);

        if (dress.color.equals("beige")){
            driver.findElement(LocatorsProduct.dressColorBeigeLoc).click();
        } else if (dress.color.equals("pink")){
            driver.findElement(LocatorsProduct.dressColorPinkLoc).click();
        }

        driver.findElement(LocatorsProduct.addCartBtn).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsProduct.spanContinueShopping));

        Commons.sleep(200);

    }
}
