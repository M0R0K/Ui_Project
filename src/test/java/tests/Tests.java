package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;

public class Tests extends TestBase {


    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск птицы (есть результаты)")
    @Tag("smoke")
    void searchBird() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
            mainPage.closeInfoWindow();
        });
        step("Вводим поисковый запрос: " + data.randomBird, () -> {
            mainPage.fillSearchInput(data.randomBird);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchBtnClick();
        });

        step("Проверяем наличие результата поиска", () -> {
            searchPage.checkSearchResult(data.randomBird);
        });

    }

    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Поиск птицы (нет результатов)")
    @Tag("regress")
    void searchBirdEmpty() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
            mainPage.closeInfoWindow();
        });

        step("Вводим поисковый запрос: " + data.emptySearchResult, () -> {
            mainPage.fillSearchInput(data.emptySearchResult);
        });

        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchBtnClick();
        });

        step("Проверяем заглушку при отсутствии результатов поиска", () -> {
            searchPage.checkSearchResultEmpty();
        });
    }

    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия видео у птицы")
    @Tag("regress")
    void checkBirdVideo() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
            mainPage.closeInfoWindow();
        });
        step("Вводим поисковый запрос: " + data.birdsWithVideo, () -> {
            mainPage.fillSearchInput(data.birdsWithVideo);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchBtnClick();
        });
        step("Открываем ссылку поискового результата", () -> {
            searchPage.openSearchLink();
        });
        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdsWithVideo);
        });
        step("Проверяем наличие видео", () -> {
            birdPage.checkVideo();
        });
    }


    @Test
    @Feature("Страница птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия аудио у птицы")
    @Tag("regress")
    void checkBirdAudio() {
        step("Открываем главную cтраницу", () -> {
            mainPage.openPage();
            mainPage.closeInfoWindow();
        });
        step("Вводим поисковый запрос: " + data.birdsWithAudio, () -> {
            mainPage.fillSearchInput(data.birdsWithAudio);
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchBtnClick();
        });
        step("Открываем ссылку поискового результата", () -> {
            searchPage.openSearchLink();
        });
        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdsWithAudio);
        });
        step("Проверяем наличие аудио", () -> {
            birdPage.checkAudio();
        });
    }

    @Test
    @Feature("Конструктор птицы")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка работы конструктора птицы")
    @Tag("smoke")
    void CheckBirdGuide() {
        step("Открываем страницу конструктора", () -> {
            birdGuidePage.openPage();
            mainPage.closeInfoWindow();
        });
        step("Выбираем силуэт", () -> {
            birdGuidePage.selectSilhouette();
        });
        step("Выбираем цвет", () -> {
            birdGuidePage.selectColour();
        });
        step("Проверяем наличие ссылки на птицу", () -> {
            birdGuidePage.checkLinkBird();
        });
        step("Кликаем по ссылке", () -> {
            birdGuidePage.linkBirdClick();
        });

        step("Проверяем заголовок страницы", () -> {
            birdPage.checkTitlePage(data.birdGuide);
        });
    }


    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка отображения птиц водоемов")
    @Tag("smoke")
    void CheckWaterBirds() {
        step("Открываем cтраницу птиц водоемов", () -> {
            waterBirdsPage.openPage();
            mainPage.closeInfoWindow();
        });

        step("Проверяем наличие птицы в списке", () -> {
            waterBirdsPage.checkBirdInList(data.waterBirds);
        });


    }

    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка отображения птиц леса")
    @Tag("smoke")
    void CheckForestBirds() {
        step("Открываем cтраницу птиц леса", () -> {
            forestBirdsPage.openPage();
            mainPage.closeInfoWindow();
        });

        step("Проверяем наличие птицы в списке", () -> {
            forestBirdsPage.checkBirdInList(data.forestBirds);
        });


    }


}