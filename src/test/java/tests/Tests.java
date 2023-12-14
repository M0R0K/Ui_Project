package tests;



import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;


@DisplayName("Тесты на вебсайт 'Птицы России'")
@Tag("all-tests")
public class Tests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    @Test
    @Feature("Поиск")
    @Owner("Konstantin Ponomarenko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск птицы (есть результаты)")
    @Tag("smoke")
    void searchBird() {

        mainPage.openPage().search("Аист");
        searchPage.openPage("Аист").checkSearchResult("Аист");


    }

    // Поиск птицы
    // Проверка стиха птицы
    // Проверка наличия аудио птицы
    // Определение птицы
    // Проверка наличия видео птицы


}
