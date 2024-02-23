package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.BirdGuidePage;
import pages.BirdPage;
import pages.MainPage;
import pages.SearchPage;

public class TestBase {
    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    BirdPage birdPage = new BirdPage();
    BirdGuidePage birdGuidePage = new BirdGuidePage();
    TestData data = new TestData();


    @BeforeAll
    public static void beforeAll() {
        projectConfiguration.configure();

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

}