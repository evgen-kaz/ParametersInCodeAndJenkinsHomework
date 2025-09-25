package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(byText(day)).click();
        //$(".react-datepicker__week").$(byText(day)).click(); - не работал такой способ.
        //т.к. находит первый эелемент с таким классом (первую неделю) и там ещет день
        //рано или поздно сломается. => ищем сразу по всему календарю
        //возврат из него никакой не нужен. поэтому void
    }
}
