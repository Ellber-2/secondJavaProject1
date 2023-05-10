package org.testing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Main {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
            Configuration.browserSize = "1980x1080";
            open("https://www.ltu.se/");


            acceptCookiesLtu();
            System.out.println("Devoured cookies from ltu");

            studentButton();
            System.out.println("managed to press studentlink");

            loginButton();
            System.out.println("loginbuton ha been");

            loginCredentials();
            System.out.println("logincredentials putin or sum");

            certificateButton();
            System.out.println("cetificate button has been pressurized.");

            switchWindow();
            System.out.println("SWetched wenbdos");
/*
            acceptCookiesLadok();
            System.out.println("Acksepted cockies");

 */

            accessInstitution();
            System.out.println("SELECT Acess denied WHERE denied = - * (-1)");


        }
    public static ArrayList<String> listCredits() {
        File jsonFile = new File("C:\\temp\\ltu.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> credentials = new ArrayList<>();

        try {
            Map<String, Map<String, String>> data = objectMapper.readValue(jsonFile, Map.class);
            String email = data.get("ltu").get("email");
            String password = data.get("ltu").get("password");
            credentials.add(email);
            credentials.add(password);
        } catch (IOException e) {

        }

        return credentials;
    }

    public static void studentButton() {
        SelenideElement studentButton = $(By.xpath("//*[@id='main-nav']/div[3]/div/a[1]"));
        studentButton.click();
    }
    public static void acceptCookiesLtu() {
        $("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click();
    }
    public static void loginButton() {
        $(By.xpath("//a[normalize-space()='Logga in']")).click();
    }
    public static void certificateButton() {
        $(By.xpath("//a[normalize-space()='Intyg »']")).click();
    }
    public static void loginCredentials() {
        String email = listCredits().get(0);
        String password = listCredits().get(1);
        $(By.cssSelector("#username")).setValue(email);
        $(By.cssSelector("#password")).setValue(password);
        $(By.cssSelector("input[value='LOGGA IN']")).click();
    }
    public static void accessInstitution(){
        $(".d-flex.align-items-center").click();

}
public static void switchWindow(){
    String currentWindowHandle = WebDriverRunner.getWebDriver().getWindowHandle();
    Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
    windowHandles.remove(currentWindowHandle);
    String newLadokWindow = windowHandles.iterator().next();
    WebDriverRunner.getWebDriver().switchTo().window(newLadokWindow);
}
    public static void acceptCookiesLadok(){
        $(By.xpath("//button[normalize-space()='I understand']")).click();

}
}


