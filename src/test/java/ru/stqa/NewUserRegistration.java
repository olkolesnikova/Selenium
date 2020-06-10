package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class NewUserRegistration extends TestBase {

    Calendar calendar = Calendar.getInstance();
    int h = calendar.get(calendar.HOUR_OF_DAY);
    int m = calendar.get(calendar.MINUTE);
    int s = calendar.get(calendar.SECOND);

    String emailName = Integer.toString(h) + Integer.toString(m) + Integer.toString(s);

    @Test

    public void testNewUserRegistration() {

        driver.get("https://litecart.stqa.ru/ru/");
        driver.findElement(By.linkText("New customers click here")).click();

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Sokolov");

        driver.findElement(By.name("address1")).click();
        driver.findElement(By.name("address1")).clear();
        driver.findElement(By.name("address1")).sendKeys("Ekb");

        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("postcode")).clear();
        driver.findElement(By.name("postcode")).sendKeys("12345");

        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Ekb");

        Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        country.selectByVisibleText("United States");
        wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("select[name=zone_code]")).click();
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();


        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(emailName + "@mail.com");

        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("+21312345");


        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(emailName);

        driver.findElement(By.name("confirmed_password")).click();
        driver.findElement(By.name("confirmed_password")).clear();
        driver.findElement(By.name("confirmed_password")).sendKeys(emailName);

        driver.findElement(By.name("create_account")).click();

        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Oleg");

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Sokolov");

        driver.findElement(By.name("create_account")).click();
        wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("[href*=logout]")).click();

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(emailName + "@mail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(emailName);
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("[href*=logout]")).click();








        






    }
}
