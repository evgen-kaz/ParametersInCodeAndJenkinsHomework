package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser"); //задаем парметр из Jenkins
        Configuration.browserVersion = System.getProperty("browserVersion"); //задаем парметр из Jenkins
        Configuration.browserSize = System.getProperty("browserSize"); //задаем парметр из Jenkins
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "wdhost"; //подключаемся к удалённой ферме

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setupConfig() {
        SelenideLogger.addListener("allure", new AllureSelenide()); //добавляем слушателя в каждый запуск теста
    }

    @AfterEach
    void addAttachments() { //в конце каждого теста
        Attach.screenshotAs("Last screenshot"); //добавляем скриншот
        Attach.pageSource(); //добавляем pageSource
        Attach.browserConsoleLogs(); //добавляем логи консоли
        Attach.addVideo(); //добавляем видео
        Selenide.closeWebDriver(); //закрываем сессию браузера
    }
}
