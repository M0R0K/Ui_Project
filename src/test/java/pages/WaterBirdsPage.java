package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WaterBirdsPage {


    private SelenideElement page = $("[class='container-fluid']");

    public WaterBirdsPage openPage() {
        open("/ptici-vodoemov.html");
        return this;
    }


    public WaterBirdsPage checkBirdInList(String birdName) {
        page.shouldHave(text(birdName));

        return this;
    }

}
