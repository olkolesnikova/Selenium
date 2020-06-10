package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChooseCountry extends TestBase {

    @Test

    public void testCountry() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("New customers click here")).click();

        //Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        //country.selectByVisibleText("United States");
        //wait = new WebDriverWait(driver, 10);

        //driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single"));
        //driver.findElements(By.cssSelector("span.select2-selection__rendered [title=United States]"));

        Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        country.selectByVisibleText("United States");






    }
}
