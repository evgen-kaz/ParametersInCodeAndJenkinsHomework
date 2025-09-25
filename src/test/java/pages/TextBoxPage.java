package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    public static String firstName = "Anna";
    public static String email = "Anna@testova.ru";
    public static String currentAddress = "street of Roses 51";
    public static String permanentAddress = "street of Soviet 29";

    private final SelenideElement firstNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentInput = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage clickButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        $("#output").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
