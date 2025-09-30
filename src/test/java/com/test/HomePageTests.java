package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.LoginTests;
import util.DriverUtil;

import java.time.Duration;

public class HomePageTests {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("userid")).sendKeys("albabahmed21@yahoo.com");
        driver.findElement(By.cssSelector("#signin-continue-btn")).click();
        driver.findElement(By.id("pass")).sendKeys("Jeeshu007@");
        driver.findElement(By.cssSelector("#sgnBt")).click();
        String name = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button/span/span")).getText();
        Assert.assertEquals(name,"Albab!");
    }
    @Test
    public void searchProduct() throws InterruptedException {
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
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div")))
                .moveToElement(driver.findElement(By.partialLinkText("Sign out")))
                .click()
                .build()
                .perform();
//        Thread.sleep(2000);
    }
    @Test
    public void searchDropDown() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("gh-cat")));
        select.selectByVisibleText("Books");
        driver.findElement(By.cssSelector("button[id='gh-search-btn']")).click();
//        Thread.sleep(2000);
        String heading = driver.findElement(By.cssSelector(".textual-display.page-title")).getText();
        Assert.assertEquals(heading, "Books & Magazines");
    }
    @Test
    public void searchRandomString(){
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        String randomString = "asamgkaj3ehkdas";
        searchBox.sendKeys(randomString);
        driver.findElement(By.cssSelector("button[id='gh-search-btn']")).click();
        String displayedString = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[1]/div[1]/h1/span[2]")).getText();
        Assert.assertEquals(randomString,displayedString);

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
