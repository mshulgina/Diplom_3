package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class TransitionTest {

    private WebDriver driver;
    private MainPage page;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        page = new MainPage(driver);
    }

    @Test
    @DisplayName("Вход в систему при тестировании персональной учетной записи")
    public void logInTransitionInPersonalAccountTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .expectPersonalAccount()
                .checkElementIn();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Переход на главную страницу через конструктор для входа")
    public void logInTransitionInMainPageAcrossConstructorTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .expectPersonalAccount()
                .clickConstructorButton()
                .expectMainPageLogInAccount()
                .checkButtonLogInAccount();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Переход для входа в систему на Главной Странице через Подсказку с логотипом")
    public void logInTransitionInMainPageAcrossLogoTipTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .expectPersonalAccount()
                .clickButtonLogo()
                .expectMainPageLogInAccount()
                .checkButtonLogInAccount();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Переход в соусы")
    public void transitionInSousTest() {
        boolean flag = page.open()
                .clickSousButton()
                .checkButtonSousLight();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Переход в булки")
    public void transitionInBulkTest() {
        boolean flag = page.open()
                .clickSousButton()
                .clickBulksButton()
                .checkButtonBulksLight();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Переход в начинки")
    public void transitionInFillingsTest() {
        boolean flag = page.open()
                .clickFillingsButton()
                .checkButtonFillingsLight();
        assertTrue(flag);
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
