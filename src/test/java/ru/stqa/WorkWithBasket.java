package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WorkWithBasket extends TestBase {

    @Test

    public void testAddToBasket() {

        for (int i = 1; i <= 3;i++) {

            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.cssSelector("#box-most-popular li.product:nth-child("+i+")")).click();

            if (driver.findElements(By.cssSelector("option")).size() > 0){
                Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
                size.selectByValue("Small");
            }

            driver.findElement(By.name("add_cart_product")).click();

            wait = new WebDriverWait(driver, 10);
            wait.until(textToBePresentInElement(driver.findElement(By.cssSelector(".quantity")), Integer.toString(i)));

            }

        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.id("cart")).click();
        wait.until(titleContains("Checkout"));

        for (int n = 1; n <= 3; n++) {
            WebElement prodTable = wait.until(presenceOfElementLocated(By.id("order_confirmation-wrapper")));

            List<WebElement> prodList = driver.findElements(By.cssSelector("li.shortcut"));
            if (prodList.size()>0) {
                prodList.get(0).click();
            }

            driver.findElement(By.name("remove_cart_item")).click();

            wait.until(stalenessOf(prodTable));
        }

        driver.get("http://localhost/litecart/en/");
        wait.until(titleContains("Online Store"));
    }

}
