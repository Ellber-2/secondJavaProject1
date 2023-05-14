package org.testing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebsiteTesting {
        public void acceptCookiesLtu() {
                $("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click();
        }

        public void studentButton() {
                SelenideElement studentButton = $(By.xpath("//*[@id='main-nav']/div[3]/div/a[1]"));
                studentButton.click();
        }

        public void loginButton() {
                $(By.xpath("//a[normalize-space()='Logga in']")).click();
        }

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

        public void loginCredentials() {
                ArrayList<String> listCredits = listCredits();
                String email = listCredits.get(0);
                String password = listCredits.get(1);
                $(By.cssSelector("#username")).setValue(email);
                $(By.cssSelector("#password")).setValue(password);
                $(By.cssSelector("input[value='LOGGA IN']")).click();
        }

        public void ltuCertificateButton() {
                $(By.xpath("//a[normalize-space()='Intyg »']")).click();
        }

        public void switchWindow() {
                String currentWindowHandle = WebDriverRunner.getWebDriver().getWindowHandle();
                Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
                windowHandles.remove(currentWindowHandle);
                String newLadokWindow = windowHandles.iterator().next();
                WebDriverRunner.getWebDriver().switchTo().window(newLadokWindow);
        }

        public void closeTab() {
                String currentWindow = WebDriverRunner.getWebDriver().getWindowHandle();
                Set<String> windowHandle = WebDriverRunner.getWebDriver().getWindowHandles();
                windowHandle.remove(currentWindow);
                WebDriverRunner.getWebDriver().close();
                String remainingWindowHandle = windowHandle.iterator().next();
                WebDriverRunner.getWebDriver().switchTo().window(remainingWindowHandle);
        }

        public void accessInstitutionButton() {
                $(By.xpath("//span[normalize-space()='Access through your institution']")).click();
        }

        public void organisationSearchInput(String institution) {
                $(By.id("searchinput")).setValue(institution);
        }

        public void selectInstitution() {
                $(By.cssSelector("[aria-label='Select Lulea University of Technology']")).click();
        }

        public void ladokCertificateButton() {
                $(By.xpath("//a[normalize-space()='Intyg']")).click();
        }

        public void certificateTypeButton() {
                $(By.id("intygstyp")).click();
                $(byText("Registreringsintyg")).click();
        }

        public void createCertificate() {
                $(By.cssSelector("#start")).setValue("2022-01-01");
                $(By.cssSelector("#slut")).setValue("2024-01-01");
                $(By.cssSelector("button[class='btn btn-ladok-brand text-nowrap me-lg-3']")).click();
        }

        public void createCertificateButton() {
                $(By.cssSelector("[title='Skapa intyg']")).click();
        }

        public void searchCourseCode() {
                try {
                        $(By.id("enkel_sokfalt")).setValue("I0015N").pressEnter();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        public void clickCourseLink() {
                try {
                        $(By.linkText("I0015N-VT23-47000-, Test av IT-system vt234 50")).click();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        /*
        Not working. Method below.
        */
        public void findExaminationInfoPage() {
                try {
                        $(By.xpath("//a[normalize-space()='Tentamen']")).click();
                        $(By.xpath("//a[normalize-space()='Tentamensschema']")).click();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        public void screenshotToFolder(String nameFile) {
                String directoryPath = "target/screenshots";
                File directory = new File(directoryPath);
                directory.mkdirs();

                File screenshotFile = $(By.tagName("body")).screenshot();

                String destinationPath = directoryPath + "/" + nameFile + ".jpeg";

                try {
                        Files.move(screenshotFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void saveRegistrationCertificateToFolder() {
                String directoryPath = "target/Registration";
                File directory = new File(directoryPath);
                directory.mkdirs();

                String downloadUrl = $(By.cssSelector("div[class='ladok-list-kort border-top-none'] a[title='Öppna PDF-dokument i nytt fönster']")).getAttribute("href");

                String destinationPath = directoryPath + "/registration_certificate.pdf";

                try {
                        File registrationCertificate = download(downloadUrl);
                        Files.move(registrationCertificate.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
        public void search(){
                $(By.xpath("//button[@class='button is-medium ltu-search-btn']")).click();
                $(By.xpath("//input[@id='cludo-search-bar-input']")).setValue("I0015N").sendKeys(Keys.ENTER);
        }
        public void selectTestAvIt(){
                $(By.cssSelector("a[title='Test av IT-system']")).click();
        }
        public void cyllabusButton(){
                $(By.xpath("//div[@class='more-edu-info']//div//a[contains(text(),'Kursplan')]")).click();
        }
        public void selectAdmissionSemester() {
                $(By.xpath("//a[normalize-space()='V23']")).click();
        }
        public void saveSyllabusToFolder() {
                String directoryPath = "target/Syllabus";
                File directory = new File(directoryPath);
                directory.mkdirs();

                String downloadUrl = $(By.xpath("//a[@class='utbplan-pdf-link']")).getAttribute("href");

                String destinationPath = directoryPath + "/syllabus.pdf";

                try {
                        File Syllabus = download(downloadUrl);
                        Files.move(Syllabus.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
