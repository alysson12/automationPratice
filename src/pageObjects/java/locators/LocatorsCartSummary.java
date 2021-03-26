package locators;

import org.openqa.selenium.By;

public class LocatorsCartSummary {

    public static By cartSummaryLoc = By.id("cart_summary");

    /* Buttons */
    public static By proceedCheckoutSummaryBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
    public static By proceedCheckoutAddressBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    public static By proceedCheckoutShippingBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button");

    /* Terms */
    public static By checkTermsLoc = By.id("uniform-cgv");
    public static By readTermsLoc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/a");
    public static By closeTerms = By.xpath("/html/body/div[2]/div/div/a");

    /* Price */
    public static By unitPriceProduct1Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/span/span");
    public static By qntProduct1Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[5]/input[2]");
    public static By priceProduct1Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[6]/span");

    public static By unitPriceProduct2Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/span/span");
    public static By qntProduct2Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[5]/input[2]");
    public static By priceProduct2Loc = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[6]/span");

    public static By totalProductsLoc = By.id("total_product");
    public static By totalShippingLoc = By.id("total_shipping");
    public static By totalPriceWithoutTaxLoc = By.id("total_price_without_tax");
    public static By taxLoc = By.id("total_tax");
    public static By totalPriceLoc = By.id("total_price");

    /* Pay */
    public static By payCheckBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a");
    public static By confirmPayBtn = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    public static By alertPayLoc = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[1]");
    public static By stepPayLoc = By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[5]");
}
