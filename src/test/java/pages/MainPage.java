package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $("[name='query']"),

    searchButton = $("[type='submit']"),

    infoWindow = $("[class*='fc-consent-root']"),

    infoWindowButton = $("[class^='fc-button']");

    public MainPage openPage() {
        open(Configuration.baseUrl);
        searchInput.shouldBe(visible);
        return this;
    }

    public MainPage closeInfoWindow() {

        if (infoWindow.isDisplayed()) {
            infoWindowButton.$(byText("Consent")).click();
        }
        return this;
    }

    public MainPage fillSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    public MainPage searchBtnClick() {
        searchButton.click();
        return this;
    }
}
