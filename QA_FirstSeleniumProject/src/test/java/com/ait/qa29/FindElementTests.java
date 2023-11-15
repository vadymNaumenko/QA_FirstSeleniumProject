package com.ait.qa29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //  driver.get("https://telranedu.web.app");//without history
        driver.navigate().to("https://telranedu.web.app/login");//with history

        //maximize browser to window
        driver.manage().window().maximize();

        //wait for all elements on the page to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagNameTest() {

        //find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find list of element by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByTest() {
        //id
        WebElement element = driver.findElement(By.id("root"));
        System.out.println(element.getText());
        System.out.println("***********************************************");
        //className
        WebElement element1 = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(element1.getText());
        System.out.println("***********************************************");
        //name
        WebElement email = driver.findElement(By.name("email"));
        System.out.println(email.getAttribute("name"));
        //linkText
        driver.findElement(By.linkText("HOME"));
        //partialLinkText
        driver.findElement(By.partialLinkText("OUT"));
    }

    @Test
    public void findElementByCssSelectorTest() {

        //tagName --> tagName
        // driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id --> #id
        //driver.findElement(By.id("root"));
        driver.findElement(By.cssSelector("#root"));

        //className --> .className
        //driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.cssSelector(".login_login__3EHKB"));

        //[attribute='value']
        driver.findElement(By.cssSelector("[name='email']"));
        driver.findElement(By.cssSelector("[placeholder='Email']"));

        //contains --> *
        driver.findElement(By.cssSelector("[placeholder*='mai']"));
        //start --> ^
        driver.findElement(By.cssSelector("[placeholder^='Em']"));
        //end on --> $
        driver.findElement(By.cssSelector("[placeholder$='ail']"));
    }

    @Test
    public void findElementByXpathTest() {
        // xpath - //*[@attribute='value']

        //tagName --> //tagName
        // driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));

        //className --> //*[@class='value']
        //driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.xpath("//*[@class='login_login__3EHKB']"));

        //id --> //*[@id='value']
        //driver.findElement(By.id("root"));
        driver.findElement(By.xpath("//*[@id='root']"));

        //contains, end on, start --> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//button[contains(.,'Registration')]"));
    }

    @Test
    public void inputLoginTest() {
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("Test");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        //  driver.quit(); // all tabs & close browser
        driver.close();// only one tab(if only one tab -> close browser)
    }
}
