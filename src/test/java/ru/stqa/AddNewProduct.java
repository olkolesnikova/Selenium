package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

public class AddNewProduct extends TestBase {

            @Test

   public void testAddNewProduct() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[2]")).click();
        driver.findElement(By.linkText("Add New Product")).click();

        driver.findElement(By.name("status")).click();

        driver.findElement(By.name("name[en]")).clear();
        driver.findElement(By.name("name[en]")).sendKeys("Donald Duck");

        driver.findElement(By.name("code")).clear();
        driver.findElement(By.name("code")).sendKeys("123");

        driver.findElement(By.xpath("(//input[@name='categories[]'])[2]")).click();

        driver.findElement(By.xpath("(//input[@name='product_groups[]'])[3]")).click();

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("1");

        driver.findElement(By.cssSelector("[type=file]")).sendKeys((new File("1.jpg").getAbsolutePath()));

        driver.findElement(By.name("date_valid_from")).click();
        driver.findElement(By.name("date_valid_from")).clear();
        driver.findElement(By.name("date_valid_from")).sendKeys("2020-01-01");

        driver.findElement(By.name("date_valid_to")).click();
        driver.findElement(By.name("date_valid_to")).clear();
        driver.findElement(By.name("date_valid_to")).sendKeys("2020-12-31");




    }

}
