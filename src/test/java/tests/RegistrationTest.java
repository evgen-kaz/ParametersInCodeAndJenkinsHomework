package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.RegistrationPage.*;

@Tag("Registration")
public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Успешная регистрация с полным набором данных")
    @Test
    @Tag("Positive")
    void successfulRegistrationTest() {
        registrationPage.openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.onloadCallback = function() { console.log('Fake reCAPTCHA onloadCallback called'); };");
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Female")
                .setUserNumber(phone)
                .setDateOfBirth("3", "December", "1900")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture(file)
                .setAddress(address)
                .setState(stateCity)
                .setCity(city)
                .clickTheButton()
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", email)
                .checkResultInModal("Gender", "Female")
                .checkResultInModal("Mobile", phone)
                .checkResultInModal("Date of Birth", "03 December,1900")
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", hobbies)
                .checkResultInModal("Picture", file)
                .checkResultInModal("Address", address)
                .checkResultInModal("State and City", stateCity + " " + city);
    }

    @DisplayName("Успешная регистрация с минимальным набором данных")
    @Test
    @Tag("Positive")
    void successfulRegistrationOnWithAMinimumCountOfDataTest() {
        registrationPage.openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.onloadCallback = function() { console.log('Fake reCAPTCHA onloadCallback called'); };");
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGender("Female")
                .setUserNumber(phone)
                .clickTheButton()
                .getTextInAModalWindow()
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Gender", "Female")
                .checkResultInModal("Mobile", phone);
    }

    @DisplayName("Невозможна регистрация с неправильным email")
    @Test
    @Tag("Negative")
    void registrationIsNotPossibleWithWrongEmailTest() {
        registrationPage.openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.onloadCallback = function() { console.log('Fake reCAPTCHA onloadCallback called'); };");
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailWong)
                .setGender("Female")
                .setUserNumber(phone)
                .clickTheButton()
                .getTextInAModalWindow()
                .notResultInModal();
    }
}
