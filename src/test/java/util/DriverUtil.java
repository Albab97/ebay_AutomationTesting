package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
    public static WebDriver getBrowserInstance(String browserName){
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            return new ChromeDriver();
        }else{  // we can add other browsers here
            return null;
        }
    }
}
