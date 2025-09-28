package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.util.TimeUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.get("https://www.ebay.com/");
        driver.findElement(By.partialLinkText("Sign in")).click();
    }
    @Test
    public void loginValidCredentials() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals(title,"Sign in or Register | eBay");
        Thread.sleep(2000);
//        driver.findElement(By.id("switch-account-anchor")).click();
        driver.findElement(By.id("userid")).sendKeys("albabahmed21@yahoo.com");
//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        driver.findElement(By.id("pass")).sendKeys("*********");
//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#sgnBt")).click();
//        Thread.sleep(2000);
        String name = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button/span/span")).getText();
        Assert.assertEquals(name,"Albab!");
    }
    @Test
    public void loginWithWrongPassword() throws InterruptedException {
        driver.findElement(By.id("userid")).sendKeys("albabahmed21@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        driver.findElement(By.id("pass")).sendKeys("*********");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#sgnBt")).click();
        Thread.sleep(1000);
        String errorMsg = driver.findElement(By.id("signin-error-msg")).getText();
        Assert.assertEquals(errorMsg,"This password is incorrect. Try again or reset password.");
    }
    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        driver.findElement(By.id("userid")).sendKeys("aaaa@qw.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        String errorMsg = driver.findElement(By.id("signin-error-msg")).getText();
        Assert.assertEquals(errorMsg,"We couldn't find this eBay account. Try again or create an account.");
    }
    @Test
    public void loginWithEmptyEmailField(){
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        String errorMsg = driver.findElement(By.id("signin-error-msg")).getText();
        Assert.assertEquals(errorMsg,"Oops, that's not a match.");
    }
    @AfterClass
    public void afterTest(){
        driver.quit();
    }

}
