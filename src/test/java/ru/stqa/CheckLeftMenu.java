package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CheckLeftMenu extends TestBase {

    int menuQuantity, submenuQuantity, a, b;

    @Test

    public void testCheckLeftMenu() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        List<WebElement> menuLinks = driver.findElements(By.id("app-"));
        List<WebElement> submenuLinks;
        WebElement menuLink, submenuLink;

        menuQuantity = menuLinks.size();

        for (int a=0; a < menuQuantity; a++  ) {
            menuLinks = driver.findElements(By.id("app-"));
            menuLink = menuLinks.get(a);
            wait = new WebDriverWait(driver,10);
            menuLink.click();

            menuLinks = driver.findElements(By.id("app-"));
            menuLink = menuLinks.get(a);

            submenuLinks = menuLink.findElements(By.cssSelector("[id^=doc-]"));
            submenuQuantity=submenuLinks.size();

            if (submenuQuantity > 0) {
                for (int b = 0; b < submenuQuantity; b++) {
                    menuLinks = driver.findElements(By.id("app-"));
                    menuLink = menuLinks.get(a);

                    submenuLinks = menuLink.findElements(By.cssSelector("[id^=doc-]"));
                    submenuLink = submenuLinks.get(b);
                    submenuLink.click();
                    driver.findElement(By.cssSelector("h1"));
                }
            } else {
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }

}


