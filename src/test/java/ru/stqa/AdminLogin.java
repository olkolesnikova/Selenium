package ru.stqa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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


}
