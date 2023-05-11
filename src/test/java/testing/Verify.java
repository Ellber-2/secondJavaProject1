package testing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testing.WebsiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Verify automated Facebook testing tasks.
 */
class Verify {
    /**
     * Verify login using expected URL.
     */
    @Test
    public void assertLogin() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        Configuration.browserSize = "1980x1080";
        open("https://www.ltu.se/");

        WebsiteTesting tasks = new WebsiteTesting();

        tasks.acceptCookiesLtu();

        tasks.studentButton();


        tasks.loginButton();


        tasks.loginCredentials();


        assertEquals("https://portal.ltu.se/group/student/start", WebDriverRunner.getWebDriver().getCurrentUrl());

    }
    /**
     * Verify download by finding the file in the directory.
     */
    /*@Test
    public void assertDownload() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        Configuration.browserSize = "1980x1080";
        open("https://www.ltu.se/");

        WebsiteTesting tasks = new WebsiteTesting();

        tasks.acceptCookiesLtu();

        tasks.studentButton();

        tasks.loginButton();

        tasks.loginCredentials();



    }
    *//**
     * Verify search using expected URL.
     *//*
    @Test
    public void assertSearch() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--lang=eng");
        WebDriver driver = new ChromeDriver(options);
        FacebookTest task = new FacebookTest(driver);

        task.browserSettings();
        task.goToFacebook();
        task.bypassCookies();
        task.login();
        task.search();

        try {
            WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/search/top/?q=Bean"));
        }catch(TimeoutException e) {
            throw new RuntimeException(e);
        }
        assertEquals ("https://www.facebook.com/search/top/?q=Bean", driver.getCurrentUrl());
        driver.quit();

    }
    *//**
     * Verify posting by finding the text in the element after posting.
     *//*
    @Test
    public void assertPosting() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--lang=eng");
        WebDriver driver = new ChromeDriver(options);
        FacebookTest task = new FacebookTest(driver);

        task.browserSettings();
        task.goToFacebook();
        task.bypassCookies();
        task.login();
        task.createPost();
        boolean posted;
        try {
            WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'ZZZ')]")));
            posted = true;
        }catch(TimeoutException e) {
            throw new RuntimeException(e);
        }
        assertTrue(posted);
        driver.quit();

    }*/

}