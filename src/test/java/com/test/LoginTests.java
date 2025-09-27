package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.ebay.com/");
    }
    @Test
    public void loginValidCredentials(){
        driver.findElement(By.partialLinkText("Sign in")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"Sign in or Register | eBay");
        driver.findElement(By.id("switch-account-link")).click();
        driver.findElement(By.id("userid")).sendKeys("albabahmed21@yahoo.com");
        driver.findElement(By.cssSelector("button[@id='signin-continue-btn']")).click();
        driver.findElement(By.id("pass")).sendKeys("Jeeshu007@");
        driver.findElement(By.cssSelector("button[@id='signin-continue-btn']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }
    @AfterClass
    public void afterTest(){
        driver.quit();
    }

}
