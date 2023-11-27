package com.app.JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SocialMedia {

    WebDriver driver;

    @BeforeAll
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @DisplayName("Lesson 4 Project")
    @ParameterizedTest
    @CsvSource({
            "admin, admin@123"
    })
    public void testMethod(String username, String pwd) {
        driver.findElement(By.cssSelector("input#email")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys(pwd);
    }

    @AfterAll
    public void closeBrowser() {
        driver.close();
    }

    
}
