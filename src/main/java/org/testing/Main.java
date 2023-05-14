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
            open("https://www.ltu.se/");
            WebsiteTesting tasks = new WebsiteTesting();
            WebDriverRunner.getWebDriver().manage().window().maximize();

            tasks.acceptCookiesLtu();

            tasks.studentButton();

            tasks.loginButton();

            tasks.loginCredentials();

            tasks.ltuCertificateButton();

            tasks.switchWindow();

            tasks.accessInstitutionButton();

            tasks.organisationSearchInput("LTU");

            tasks.selectInstitution();

            tasks.ladokCertificateButton();

            tasks.createCertificateButton();

            tasks.certificateTypeButton();

            tasks.createCertificate();








        }

}


