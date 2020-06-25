package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindLogs extends TestBase {

    @Test

    public void checkBrowserLogs() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        List<WebElement> productList = driver.findElements(By.cssSelector(".dataTable tr.row"));
        int productListSize = productList.size();
        
        ArrayList<LogEntry> logs = new ArrayList<>();

        for (int i = 4; i < productListSize; i++) {

            WebElement product = driver.findElement(By.cssSelector(".dataTable .row:nth-child("+i+")"));
            product.findElement(By.cssSelector("a")).click();
            logs.addAll(driver.manage().logs().get("browser").getAll());
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }


       Assert.assertTrue(areBrowserLogsPresent(logs.size()));

    }

    private boolean areBrowserLogsPresent(int logSize) {
        if (logSize > 0) {
            System.out.println("Логи есть");
        }
        else {
            System.out.println("Логов нет");
        }

        return logSize > 0;

    }


}
