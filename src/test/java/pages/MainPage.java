package pages;

import com.codeborne.selenide.SelenideElement;
import com.mifmif.common.regex.Main;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private SelenideElement searchInput = $("[name='query']"),

    searchButton = $("[type='submit']");



    public MainPage openPage() {
        step("Открываем главную", () -> {
            open("https://ptici.info/");
            searchInput.shouldBe(visible);
        });
        return this;
    }


    public MainPage search(String value) {
        step("Вводим поисковый запрос: "+ value, () -> {
            open("https://ptici.info/");
            searchInput.setValue(value);
        });
        return this;
    }
}
