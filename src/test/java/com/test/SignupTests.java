package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SignupTests {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.get("https://www.ebay.com/");
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.partialLinkText("Create account")).click();
        driver.findElement(By.cssSelector("#personalaccount-radio")).click();
    }
    @Test
    public void signUpWithValidCreds() throws InterruptedException {
        driver.findElement(By.id("firstname")).sendKeys("Ahmed");
        driver.findElement(By.id("lastname")).sendKeys("Albab");
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys("ahmedalbab3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("jeeshu97ja");
        Thread.sleep(2000);
//        driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT")).click();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
