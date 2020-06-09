package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ChooseCountry extends TestBase {

    @Test

    public void testCountry() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.xpath("//div[@id='create-account']/div/form/table/tbody/tr[5]/td/span[2]/span/span/span")).click();
        driver.findElement(By.xpath("//select[@name='zone_code']")).click();
        //new Select(driver.findElement(By.xpath("//select[@name='zone_code']"))). selectByVisibleText("Alaska");
        //driver.findElement(By.xpath("//select[@name='zone_code']")).click();

    }
}
