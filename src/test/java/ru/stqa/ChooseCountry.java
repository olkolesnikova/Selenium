package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

import static jdk.nashorn.internal.runtime.Debug.id;

public class ChooseCountry extends TestBase {

    @Test

    public void testCountry() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("New customers click here")).click();

        //Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        //country.selectByVisibleText("United States");
        //wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).click();
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("[id*=US]")).click();

        driver.findElement(By.cssSelector("select[name=zone_code]")).click();
        WebElement a = driver.findElement(By.cssSelector("option:nth-child(5)"));
        System.out.println(a);


        //Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        //country.selectByVisibleText("United States");






    }
}
