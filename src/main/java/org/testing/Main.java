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

            WebsiteTesting tasks = new WebsiteTesting();

            tasks.acceptCookiesLtu();


            tasks.studentButton();



            tasks.loginButton();


            tasks.loginCredentials();


            tasks.certificateButton();


            tasks.switchWindow();


            tasks.accessInstitution();
            System.out.println("SELECT Acess denied WHERE denied = - * (-1)");

            tasks.organisationSearchInput();


            tasks.selectLTU();


            tasks.makeLadokSwedish();


            tasks.secondCertificateButton();
            System.out.println("Coulda should woulda used the same method if it werent for ->");

            tasks.createCertificate();
            System.out.println("created certificate??? NONO only press button to ");



        }

}


