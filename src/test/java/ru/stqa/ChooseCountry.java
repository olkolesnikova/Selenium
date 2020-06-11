package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

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
        List<WebElement> countries = driver.findElements(By.cssSelector("li.select2-results__option #select2-country_code-qi-result-47p6-US"));



                driver.findElement(By.name("email")).click();


        //Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        //country.selectByVisibleText("United States");






    }
}
