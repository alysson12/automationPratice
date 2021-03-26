package locators;

import org.openqa.selenium.By;

public class LocatorsLogin {

    /* Elementos de execução de Login */
    public static By emailLoc = By.id("email");
    public static By passwordLoc = By.id("passwd");
    public static By signInBtn = By.id("SubmitLogin");

    /* Elementos de criação de Conta */
    public static By emailCreateLoc = By.id("email_create");
    public static By createAccountBtn = By.id("SubmitCreate");

    public static By alertError = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]");

}
