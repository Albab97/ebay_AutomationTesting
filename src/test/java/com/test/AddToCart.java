package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class AddToCart {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.ebay.com/");
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("userid")).sendKeys("albabahmed21@yahoo.com");
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        driver.findElement(By.id("pass")).sendKeys("*****");
        driver.findElement(By.cssSelector("#sgnBt")).click();
        String name = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button/span/span")).getText();
        Assert.assertEquals(name,"Albab!");
    }

    @Test
    public void addToCartItem() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        String product = "lego";
        for (char c : product.toCharArray() ){
            searchBox.sendKeys(Character.toString(c));
            Thread.sleep(1000);
        }
        Actions actions = new Actions(driver);
        WebElement legoOption = driver.findElement(By.xpath("//*[@id=\"ebay-ac-suggestion-1\"]/span/span/span[2]/span"));
        actions.moveToElement(legoOption)
                .click()
                .build()
                .perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"item22314f408d\"]/div/div[2]/div[1]/a/div/span[1]")).click();
        Set<String> allWindows = driver.getWindowHandles();
//        System.out.println(Arrays.toString(allWindows.toArray())); // to print window handles
        driver.switchTo().window(allWindows.toArray()[1].toString());
        driver.findElement(By.partialLinkText("Add to cart")).click();
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[5]/ul/li[2]/div[1]/div/div[2]/div[2]/button")).click();
        WebElement addToCartIcon = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[2]/div[4]/div/a/span/span"));
        Assert.assertEquals(addToCartIcon.getText(),"1");
    }

    @Test
    public void removeFromCartItem() throws InterruptedException {
//        addToCartItem();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[2]/div[4]/div/a")))
                .pause(Duration.ofSeconds(5))
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"gh-minicart-hover-body\"]/div[2]/div/div[2]/div/button")))
                .click()
                .build().perform();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
