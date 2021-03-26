package utils;

import objects.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Commons {

    public static void aguardarElemento(final WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 600);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String value = element.getText();

                if(!value.equals("")) {
                    return true;
                }
                return false;
            }
        });
    }

    public static void sleep(Integer milisseconds){
        try {
            Thread.sleep(milisseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Properties loadProperties(Properties properties){

        properties = new Properties();
        try {
            properties.load(Commons.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo de propriedades! " + e.getMessage(), e);
        }

        return properties;

    }

}
