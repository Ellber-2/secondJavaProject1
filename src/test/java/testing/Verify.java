package testing;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Disabled;
import org.testing.WebsiteTesting;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verify automated Facebook testing tasks.
 */
class Verify {
    private static final Logger LOGGER = LoggerFactory.getLogger(Verify.class);

    /**
     * Verify login using expected URL.
     */
    @Test
    public void assertLogin() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        open("https://www.ltu.se/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        WebsiteTesting tasks = new WebsiteTesting();

        tasks.acceptCookiesLtu();
        tasks.studentButton();
        tasks.loginButton();
        tasks.loginCredentials();

        assertEquals("https://portal.ltu.se/group/student/start", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    /**
     * Verify examination date.
     */
    @Test
    public void assertExaminationDate() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebsiteTesting tasks = new WebsiteTesting();
        open("https://www.ltu.se/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        tasks.acceptCookiesLtu();
        tasks.studentButton();
        tasks.loginButton();
        tasks.loginCredentials();
        tasks.findExaminationInfoPage();
        tasks.closeTab();
        tasks.searchCourseCode();
        tasks.clickCourseLink();
        tasks.closeTab();
        tasks.screenshotToFolder("final_examination");
        String tdText = $(By.xpath("//td[text()='2023-04-17']")).getText();
        LOGGER.info("Date of the exam is " + tdText);
        assertEquals("2023-04-17", tdText);
    }

    /**
     * Verify download certificate.
     */
    @Test
    public void assertDownloadCertificate() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        open("https://www.ltu.se/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebsiteTesting tasks = new WebsiteTesting();

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
        tasks.saveRegistrationCertificateToFolder();

        // Verify the file is located in the correct folder
        String expectedFolder = "target/Registration";
        String expectedFileName = "registration_certificate.pdf";
        Path expectedFilePath = Paths.get(expectedFolder, expectedFileName);
        assertTrue(Files.exists(expectedFilePath), "Certificate not found in the expected folder: " + expectedFolder);
    }

    /**
     * Verify download syllabus.
     */
    @Test
    public void assertDownloadSyllabus() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        open("https://www.ltu.se/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebsiteTesting tasks = new WebsiteTesting();

        tasks.acceptCookiesLtu();
        tasks.search();
        tasks.selectTestAvIt();
        tasks.cyllabusButton();
        tasks.selectAdmissionSemester();
        tasks.saveSyllabusToFolder();

        //Verify the Syllabus file is located in the correct folder.
        String expectedFolder = "target/Syllabus";
        String expectedFileName = "Syllabus.pdf";
        Path expectedFilePath = Paths.get(expectedFolder, expectedFileName);
        assertTrue(Files.exists(expectedFilePath), "Certificate not found in the expected folder: " + expectedFolder);
    }

    @Disabled
    @Test
    public void assertCreateCertificate() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        open("https://www.ltu.se/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebsiteTesting tasks = new WebsiteTesting();
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
        tasks.certificateInformation();

        //Verify that the createCertificate is pressed.

        try {
            tasks.createCertificate();
        } catch (Exception e) {
            assertTrue(false, "Certificate creation failed: " + e.getMessage());
        }
    }
}