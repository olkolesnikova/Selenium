package ru.stqa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenSite extends TestBase {

    @Test
    public void testOpenSite() throws Exception {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("selenium webdriver");
        driver.findElement(By.id("tsf")).submit();

    }

}
