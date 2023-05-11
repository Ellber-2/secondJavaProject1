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
            System.out.println("Devoured cookies from ltu");

            tasks.studentButton();
            System.out.println("managed to press studentlink");

/*
            tasks.loginButton();
            System.out.println("loginbuton ha been");

            tasks.loginCredentials();
            System.out.println("logincredentials putin or sum");

            tasks.certificateButton();
            System.out.println("cetificate button has been pressurized.");

            tasks.switchWindow();
            System.out.println("SWetched wenbdos");

            tasks.accessInstitution();
            System.out.println("SELECT Acess denied WHERE denied = - * (-1)");
*/


        }

}


