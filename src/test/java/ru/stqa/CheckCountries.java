package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckCountries extends TestBase {

    int a, aZone;
    int countryQuantity, zoneQuantity, geoZoneQuantity;
    int[] zones;
    List<WebElement> countryRows, zoneRows, geoZoneRows;
    WebElement countryRow, zoneRow, geoZoneRow;
    String[] countryName, zoneName;


    public static int isSortAlphabet(String[] testArr, int arrSize) {

        int isAlphabet = 1;
        for(int i = 1; i < arrSize; i++){
            int k;
            k = testArr[i-1].compareToIgnoreCase(testArr[i]);
            if (k >= 0) isAlphabet = -1;
        }
        return isAlphabet;
    }

    @Test

    public void testCheckCountries() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        countryRows = driver.findElements(By.cssSelector("[name=countries_form] .row"));
        countryQuantity = countryRows.size();
        countryName = new String[countryQuantity];
        zones = new int[countryQuantity];

        for (int i = 0; i < countryQuantity; i++) {
            countryRow = countryRows.get(i);
            countryName[i] = countryRow.findElement(By.cssSelector("a")).getText();
            zones[i] = Integer.parseInt(countryRow.findElement(By.cssSelector("td:nth-child(6)")).getText());
        }

        a = isSortAlphabet(countryName, countryQuantity);

        Assert.assertTrue(a==1);

        for (int i = 0; i < countryQuantity; i++){
            if (zones[i] > 0) {
                countryRows = driver.findElements(By.cssSelector("[name=countries_form] .row"));
                countryRow = countryRows.get(i);
                countryRow.findElement(By.cssSelector("a")).click();
                wait = new WebDriverWait(driver, 10);

                zoneRows = driver.findElements(By.cssSelector("#table-zones tr"));
                zoneQuantity = zoneRows.size() - 2;
                zoneName = new String[zoneQuantity];

                for (int j = 1; j <= zoneQuantity; j++){
                    zoneRow = zoneRows.get(j);
                    zoneName[j-1]=zoneRow.findElement(By.cssSelector("td:nth-child(3)")).getText();
                }

                aZone = isSortAlphabet(zoneName, zoneQuantity);
                Assert.assertTrue(aZone==1);
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        geoZoneRows = driver.findElements(By.cssSelector("[name=geo_zones_form] .row"));
        geoZoneQuantity = geoZoneRows.size();

        for (int i = 0; i < geoZoneQuantity; i++) {
            geoZoneRows = driver.findElements(By.cssSelector("[name=geo_zones_form] .row"));
            geoZoneRow = geoZoneRows.get(i);
            geoZoneRow.findElement(By.cssSelector("a")).click();

            zoneRows = driver.findElements(By.cssSelector("[id=table-zones] tr"));
            zoneQuantity = zoneRows.size() - 2;
            zoneName = new String[zoneQuantity];

            for (int j = 1; j <= zoneQuantity; j++) {
                zoneRow = zoneRows.get(j);
                zoneName[j-1] = zoneRow.findElement(By.cssSelector("#table-zones tr td:nth-child(3) [selected=selected]"))
                        .getAttribute("textContent");
            }

            aZone = isSortAlphabet(zoneName, zoneQuantity);
            Assert.assertTrue(aZone==1);

            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }

    }
}
