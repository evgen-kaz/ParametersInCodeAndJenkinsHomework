package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.TextBoxPage.*;

@Tag("Registration")
public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.onloadCallback = function() { console.log('Fake reCAPTCHA onloadCallback called'); };");
        textBoxPage.setFirstName(firstName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickButton()
                .checkResult("Name:", firstName)
                .checkResult("Email:", email)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }
}

