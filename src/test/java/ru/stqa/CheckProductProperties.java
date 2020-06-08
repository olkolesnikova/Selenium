package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProductProperties extends TestBase {

    WebElement productFirst, productSecond;
    String productNameFirst;
    String productNameSecond;
    boolean regularPrice1Color, regularPrice2Color, regularPrice1TypeText, regularPrice2TypeText, campaignPrice1Color, campaignPrice2Color;
    String[] regularPrice1, campaignPrice1, regularPrice2, campaignPrice2;
    float size1, size2, size3, size4;
    int i;

    @Test

    public void testCheckProduct() {

        driver.get("http://localhost/litecart/en/");
        productFirst = driver.findElement(By.cssSelector("div#box-campaigns div.name"));
        productNameFirst = productFirst.getText();

        System.out.println(productNameFirst);

        regularPrice1 = new String[3];
        campaignPrice1 = new String[3];

        regularPrice1[0] = driver.findElement(By.cssSelector("s.regular-price")).getText();
        regularPrice1[1] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-weight");
        regularPrice1[2] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");

        size1 = Float.parseFloat(regularPrice1[2].replaceAll("px",""));

        regularPrice1Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color")
                .contains("119, 119, 119");

        campaignPrice1Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color")
                .contains("204, 0, 0");

        regularPrice1TypeText = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration")
        .contains("line-throught");

        campaignPrice1[0]= driver.findElement(By.cssSelector("strong.campaign-price")).getText();
        campaignPrice1[1] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        campaignPrice1[2] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        size2 = Float.parseFloat(campaignPrice1[2].replaceAll("px",""));

        Assert.assertTrue(size1<size2);

        productFirst.click();
        wait = new WebDriverWait(driver, 10);

        productSecond = driver.findElement(By.cssSelector("h1.title"));
        productNameSecond = productSecond.getText();
        System.out.println(productNameSecond);

        Assert.assertEquals(productNameFirst, productNameSecond);

        regularPrice2 = new String[3];
        campaignPrice2 = new String[3];

        regularPrice2[0] = driver.findElement(By.cssSelector("s.regular-price")).getText();
        regularPrice2[1] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-weight");
        regularPrice2[2] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");

        size3 = Float.parseFloat(regularPrice2[2].replaceAll("px",""));

        regularPrice2Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color")
                .contains("102, 102, 102");

        campaignPrice2Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color")
                .contains("204, 0, 0");

        regularPrice2TypeText = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration")
        .contains("line-throught");

        campaignPrice2[0] = driver.findElement(By.cssSelector("strong.campaign-price")).getText();
        campaignPrice2[1] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        campaignPrice2[2] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        size4 = Float.parseFloat(campaignPrice2[2].replaceAll("px",""));

        Assert.assertTrue(size3<size4);

        for (i = 0; i < 2; i++) {
            Assert.assertEquals(regularPrice1[i], regularPrice2[i]);
            Assert.assertEquals(campaignPrice1[i], campaignPrice2[i]); //жирность разная на двух страницах в Firefox, в Chrome совпадает
        }
    }
}
