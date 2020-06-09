package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NewUserRegistration extends TestBase {

    public void makeElementVisibleByJavascript (WebElement element) {
        String script = "var element = arguments[0];"
                + "element.style.display='block';";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }

    @Test

    public void testNewUserRegistration() {

        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("New customers click here")).click();

        driver.findElement(By.name("firstname")).sendKeys("Oleg");
        driver.findElement(By.name("lastname")).sendKeys("Sokolov");
        driver.findElement(By.name("address1")).sendKeys("Ekb");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("Ekb");
        driver.findElement(By.xpath("//div[@id='create-account']/div/form/table/tbody/tr[5]/td/span[2]/span/span/span[2]")).click();

        WebElement element = driver.findElement(By.name("zone_code"));
        makeElementVisibleByJavascript(element);
        new Select(driver.findElement(By.xpath("//select[@name='zone_code']"))).selectByVisibleText("Alaska");





    }
}
