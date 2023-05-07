package org.testing;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebsiteTesting {
    private final WebDriver driver;
    private WebDriverWait wait;
    public WebsiteTesting(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void browserSettings() {
        driver.manage().window().maximize();
    }
}
