package com.qa.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;

public class TestCase1 {

    private static final String APPLICATION_URL_SYSTEM_PROPERTY = "applicationUrl";
    private final WebDriver driver;

    public TestCase1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    }
    @BeforeClass
    public void setupMethod() {
        driver.get(System.getProperty(APPLICATION_URL_SYSTEM_PROPERTY));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void shouldBeAbleToNavigateToAboutPage() throws InterruptedException {
        driver.findElement(linkText("About Us")).isDisplayed();
        driver.findElement(linkText("About Us")).click();
        driver.findElement(id("PID-ab2-pg")).getText().contains("This is about page");
    }
}
