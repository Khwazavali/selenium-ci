package com.practice.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GooglTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void searchInWikipedia() {
        // Step 1: Go to Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Step 2: Enter "Test automation" in the search box
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Test automation");
        searchBox.submit();

        // Step 3: Verify title contains "Test automation"
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
