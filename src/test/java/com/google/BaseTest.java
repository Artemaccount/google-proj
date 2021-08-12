package com.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
    }

    @AfterEach
    public void afterEach() {
        driver.close();
    }
}
