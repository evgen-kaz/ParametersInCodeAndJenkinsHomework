package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import static pages.TextBoxPage.*;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setFirstName(firstName)
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

