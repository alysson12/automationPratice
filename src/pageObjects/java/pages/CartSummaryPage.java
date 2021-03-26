package pages;

import locators.LocatorsCartSummary;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;

public class CartSummaryPage extends BasePage{

    public CartSummaryPage(WebDriver driver){
        super (driver);
    }

    public boolean verifyPrice(){

        boolean verify = false;

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.unitPriceProduct1Loc));

        float unitPrice1 = Float.parseFloat(driver.findElement(LocatorsCartSummary.unitPriceProduct1Loc).getText().trim().replace("$", ""));
        float unitPrice2 = Float.parseFloat(driver.findElement(LocatorsCartSummary.unitPriceProduct2Loc).getText().trim().replace("$", ""));

        Integer qntProduct1 = Integer.parseInt(driver.findElement(LocatorsCartSummary.qntProduct1Loc).getAttribute("value"));
        Integer qntProduct2 = Integer.parseInt(driver.findElement(LocatorsCartSummary.qntProduct2Loc).getAttribute("value"));

        float priceProduct1 = Float.parseFloat(driver.findElement(LocatorsCartSummary.priceProduct1Loc).getText().trim().replace("$", ""));
        float priceProduct2 = Float.parseFloat(driver.findElement(LocatorsCartSummary.priceProduct2Loc).getText().trim().replace("$", ""));

        float totalProducts = Float.parseFloat(driver.findElement(LocatorsCartSummary.totalProductsLoc).getText().trim().replace("$", ""));
        float totalShipping = Float.parseFloat(driver.findElement(LocatorsCartSummary.totalShippingLoc).getText().trim().replace("$", ""));
        float totalPriceWithoutTax = Float.parseFloat(driver.findElement(LocatorsCartSummary.totalPriceWithoutTaxLoc).getText().trim().replace("$", ""));
        float taxLoc = Float.parseFloat(driver.findElement(LocatorsCartSummary.taxLoc).getText().trim().replace("$", ""));
        float totalPrice = Float.parseFloat(driver.findElement(LocatorsCartSummary.totalPriceLoc).getText().trim().replace("$", ""));

        float calcPriceProduct1 = unitPrice1 * qntProduct1;
        float calcPriceProduct2 = unitPrice2 * qntProduct2;
        float calcTotalProducts = calcPriceProduct1 + calcPriceProduct2;

        float calcTotalWithoutTax = calcTotalProducts + totalShipping;
        float calcTotal = calcTotalWithoutTax + taxLoc;

        if (priceProduct1 == calcPriceProduct1 && priceProduct2 == calcPriceProduct2 &&
            totalProducts == calcTotalProducts && totalPriceWithoutTax == calcTotalWithoutTax &&
            totalPrice == calcTotal){
            verify = true;
        }

        return verify;
    }

    public void calculatePrice(){

        boolean validator = verifyPrice();

    }

    public void purchase(){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.proceedCheckoutSummaryBtn));
        driver.findElement(LocatorsCartSummary.proceedCheckoutSummaryBtn).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.proceedCheckoutAddressBtn));
        driver.findElement(LocatorsCartSummary.proceedCheckoutAddressBtn).click();

        driver.findElement(LocatorsCartSummary.checkTermsLoc).click();
        driver.findElement(LocatorsCartSummary.readTermsLoc).click();
        executor.executeScript("arguments[0].click();", driver.findElement(LocatorsCartSummary.closeTerms));

        Commons.sleep(500);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.proceedCheckoutShippingBtn));
        driver.findElement(LocatorsCartSummary.proceedCheckoutShippingBtn).click();

    }

    public String payment(){

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.payCheckBtn));
        driver.findElement(LocatorsCartSummary.payCheckBtn).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.confirmPayBtn));
        driver.findElement(LocatorsCartSummary.confirmPayBtn).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LocatorsCartSummary.alertPayLoc));

        String alertPay = driver.findElement(LocatorsCartSummary.alertPayLoc).getText();
        return alertPay;

    }
}
