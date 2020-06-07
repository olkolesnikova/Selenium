package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class AdminLogin extends TestBase {



    @Test
    public void testAdminLogin() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test

    public void testColor() {

        driver.get("http://localhost/litecart/");
        WebElement productFirst = driver.findElement(By.cssSelector("div#box-campaigns div.name"));
        String productNameFirst = productFirst.getText();
        String campaignPrice = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration");
        System.out.println(campaignPrice);

    }


}
