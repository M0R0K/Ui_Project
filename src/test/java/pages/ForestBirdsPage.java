package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ForestBirdsPage {
    private SelenideElement page = $("[class='container-fluid']");

    public ForestBirdsPage openPage() {
        open("/ptici-lesa.html");
        return this;
    }

    public ForestBirdsPage checkBirdInList(String birdName) {
        page.shouldHave(text(birdName));

        return this;
    }
}
