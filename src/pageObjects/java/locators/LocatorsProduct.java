package locators;

import org.openqa.selenium.By;

public class LocatorsProduct {

    /* Elementos de Produto */
    public static By dressLoc = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li");
    public static By dressMoreLoc = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[2]");

    public static By dressSizeLoc = By.id("group_1");
    public static By dressColorBeigeLoc = By.id("color_7");
    public static By dressColorPinkLoc = By.id("color_24");

    public static By addCartBtn = By.id("add_to_cart");
    public static By spanContinueShopping = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span");

    public static By checkoutBtn = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");


}
