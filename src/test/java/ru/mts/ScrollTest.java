package ru.mts;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollTest {
    public static WebDriver driver;
    public static MainWindow mainWindow;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        mainWindow = new MainWindow(driver);
        System.setProperty("webriver.chrome.driver", ConfProperties.getProperty("chromedriverPath"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get(ConfProperties.getProperty("url"));
    }

    @Test
    public void wheelScrollTest() {
        mainWindow.hoverOnToolbarItem();
        mainWindow.hoverOnMainBlock().scrollByAmount(0, 50).scrollByAmount(0, -50).perform();
        Assert.assertFalse(mainWindow.checkMainBlockVisible());
    }
}
