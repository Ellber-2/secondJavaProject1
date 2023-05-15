package org.testing;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WebsiteTesting {
        public void acceptCookiesLtu() {

                try {
                        $("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click();
                } catch (ElementNotFound e){
                        System.out.println("Accept cookies is not visible");
                }
        }

        public void studentButton() {
                try {
                        SelenideElement studentButton = $x("//*[@id='main-nav']/div[3]/div/a[1]");
                        studentButton.click();
                } catch (ElementNotFound e) {
                        System.out.println("Student button is not visible");
                }
        }

        public void loginButton() {
                try {
                        $x("//a[normalize-space()='Logga in']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Login button is not visible");
                }
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
                        System.out.println("Issues with .JSON file");
                }

                return credentials;
        }

        public void loginCredentials() {
                ArrayList<String> listCredits = listCredits();
                String email = listCredits.get(0);
                String password = listCredits.get(1);
                try {
                        $("#username").setValue(email);
                        $("#password").setValue(password);
                        $("input[value='LOGGA IN']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Issues with login");
                }


        }

        public void ltuCertificateButton() {
                try {
                        $x("//a[normalize-space()='Intyg »']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Could not find ltu certificate button");
                }

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
                try {
                        $x("//span[normalize-space()='Access through your institution']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Could not find access institution button");
                }

        }

        public void organisationSearchInput(String institution) {
                try {
                        $("#searchinput").setValue(institution);
                } catch (ElementNotFound e) {
                        System.out.println("Could not find organisation search input");
                }

        }

        public void selectInstitution() {
                try {
                        $("[aria-label='Select Lulea University of Technology']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Could not select institution");
                }

        }

        public void ladokCertificateButton() {
                try {
                        $x("//a[normalize-space()='Intyg']").click();
                } catch (ElementNotFound e) {
                        System.out.println("Could not find ladok certificate button");
                }

        }

        public void certificateTypeButton() {
                try {
                        $("#intygstyp").click();
                        $(byText("Registreringsintyg")).click();
                } catch (ElementNotFound e) {
                        System.out.println("Issues with certificate type");
                }

        }

        public void certificateInformation() {
                try {
                        $("#start").setValue("2022-01-01");
                        $("#slut").setValue("2024-01-01");
                } catch (ElementNotFound e) {
                        System.out.println("Issues with start and end date");
                }

        }

        public void createCertificate() {
                try {
                        $("button[class='btn btn-ladok-brand text-nowrap me-lg-3']").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException("Certificate creation failed: " + e.getMessage());
                }
        }

        public void createCertificateButton() {
                try {
                        $("[title='Skapa intyg']").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }

        }

        public void searchCourseCode() {
                try {
                        $("#enkel_sokfalt").setValue("I0015N").pressEnter();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        public void clickCourseLink() {
                try {
                        $(byLinkText("I0015N-VT23-47000-, Test av IT-system vt234 50")).click();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        /*
        Not working. Method below.
        */
        public void findExaminationInfoPage() {
                try {
                        $x("//a[normalize-space()='Tentamen']").click();
                        $x("//a[normalize-space()='Tentamensschema']").click();
                } catch (NoSuchElementException e) {
                        System.out.println("No such element");
                }
        }

        public void screenshotToFolder(String nameFile) {
                String directoryPath = "target/screenshots";
                File directory = new File(directoryPath);
                directory.mkdirs();

                File screenshotFile = Screenshots.takeScreenShotAsFile();

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

                String downloadUrl = $("div[class='ladok-list-kort border-top-none'] a[title='Öppna PDF-dokument i nytt fönster']").getAttribute("href");

                String destinationPath = directoryPath + "/registration_certificate.pdf";

                try {
                        File registrationCertificate = download(downloadUrl);
                        Files.move(registrationCertificate.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
        public void search(){
                try {
                        $x("//button[@class='button is-medium ltu-search-btn']").click();
                        $x("//input[@id='cludo-search-bar-input']").setValue("I0015N").pressEnter();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }

        }
        public void logout() {
                try {
                        $(".user-full-name").click();
                        $x("//span[normalize-space()='Logga ut']").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }
        }
        public void selectTestAvIt(){
                try {
                        $("a[title='Test av IT-system']").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }

        }
        public void syllabusButton(){
                try {
                        $x("//div[@class='more-edu-info']//div//a[contains(text(),'Kursplan')]").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }

        }
        public void selectAdmissionSemester() {
                try {
                        $x("//a[normalize-space()='V23']").click();
                } catch (ElementNotFound e) {
                        throw new RuntimeException(e.getMessage());
                }

        }
        public void saveSyllabusToFolder() {
                String directoryPath = "target/Syllabus";
                File directory = new File(directoryPath);
                directory.mkdirs();

                String downloadUrl = $x("//a[@class='utbplan-pdf-link']").getAttribute("href");

                String destinationPath = directoryPath + "/syllabus.pdf";

                try {
                        File Syllabus = download(downloadUrl);
                        Files.move(Syllabus.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
