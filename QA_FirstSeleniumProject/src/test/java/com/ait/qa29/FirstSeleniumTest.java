package com.ait.qa29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    //test
    @Test
    public void openGoogle() {
        System.out.println("Site opened!!!");
    }

    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
