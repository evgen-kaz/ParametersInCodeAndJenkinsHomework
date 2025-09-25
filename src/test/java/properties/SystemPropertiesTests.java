package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser"); //некорректно так запрашивать, т.к. вдруг в System.setProperty ничего нет

        System.out.println(browser); // null
    }

    @Test
    void systemProperties1Test() {
        System.setProperty("browser", "chrome"); //устанавливаем
        String browser = System.getProperty("browser");

        System.out.println(browser); // chrome
    }

    @Test
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "mozilla"); //def - дефолтное значение. Оно вообще chrome, но здесь задали mozilla
        //самый целивизованный способ
        System.out.println(browser); // mozilla
    }

    @Test
    void systemProperties3Test() {
        System.setProperty("browser", "chrome"); //положили значение chrome
        String browser = System.getProperty("browser", "mozilla"); //хотим узнать его значение, типа он mozilla же, но положили то chrome

        System.out.println(browser); // chrome. т.к. задали его в setProperty
    }

    @Test
    @Tag("property")
    void systemProperties4Test() {
        String browser = System.getProperty("browser", "mozilla"); //выбрали его дефлотным и ничего более не установили

        System.out.println(browser);
        // gradle property_test
        // mozilla

        // gradle property_test -Dbrowser=opera //передали в командную строку значение переменной -Dbrowser=opera, дефолт (mozilla) при этом будет игнорироваться
        // opera
    }

    @Test
    @Tag("hello")
    void systemProperties5Test() {
        String name = System.getProperty("name", "default student");
        String message = format("Hello, %s!", name);

        System.out.println(message);
        // gradle hello_test
        // Hello, default student!

        // gradle hello_test -Dname=Alex Egorov
        // BUILD FAILED: Task 'Egorov' not found in root project 'demoqa-tests-19'.

        // gradle hello_test -Dname="Alex Egorov"
        // gradle hello_test "-Dname=Alex Egorov"
        // Hello, Alex Egorov!
    }
}