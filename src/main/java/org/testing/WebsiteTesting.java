package org.testing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
public class WebsiteTesting{

public ArrayList<String> listCredits() {
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

public  ChromeOptions chromeSettings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--lang=eng");
        return options;
        }
public void studentButton() {
        SelenideElement studentButton = $(By.xpath("//*[@id='main-nav']/div[3]/div/a[1]"));
        studentButton.click();
        }
public void acceptCookies() {
        $("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click();
        }
public void loginButton() {
        $(By.xpath("//a[normalize-space()='Logga in']")).click();
        }
public  void certificateButton() {
        $("active expand").click();
        }
public void loginCredentials() {
        String email = listCredits().get(0);
        $(By.cssSelector("#username")).setValue(email);
        }
        }