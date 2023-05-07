package org.testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = chromeSettings();
        WebDriver driver = new ChromeDriver(options);
        WebsiteTesting testingTask = new WebsiteTesting(driver);

    }

    public static ChromeOptions chromeSettings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--lang=eng");
        return options;
    }
}