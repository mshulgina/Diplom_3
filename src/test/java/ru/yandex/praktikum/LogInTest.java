package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LogInTest {
    private WebDriver driver;
    private UserClient userClient;
    private MainPage page;
    private User user;
    private String name;
    private String email;
    private String password;
    private String accessToken;
    private int count = 10;
    private boolean checkNeedSetYandexDriver;

    @Before
    public void startUp() {
        name = RandomStringUtils.randomAlphabetic(count);
        email = RandomStringUtils.randomAlphabetic(count) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(count);
        user = new User(email, password, name);
        userClient = new UserClient();
        ValidatableResponse responseCreate = userClient.createUser(user);
        accessToken = responseCreate.extract().path("accessToken");
        if (checkNeedSetYandexDriver) {
            System.setProperty("webdriver.chrome.driver",
                    "src\\main\\resources\\yandexdriver.exe");
        }
        driver = new ChromeDriver();
        page = new MainPage(driver);
    }

    @Test
    @DisplayName("Войти с помощью кнопки на Главной странице")
    public void logInAcrossButtonOnMainTest() {
        boolean flag = page.open()
                .clickGoInAccountButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Вход в систему через Личный кабинет")
    public void logInAcrossPersonalAccountTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Вход в систему через форму регистрации")
    public void logInAcrossFormRegistrationTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .clickButtonInOnPageRegistration()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Вход в систему через Восстановление пароля")
    public void logInAcrossFormReanimatePasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickReanimatePasswordButton()
                .clickLogInButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Выход из системы")
    public void logOutTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .logInUser(email, password)
                .expectMainPage()
                .clickPersonalAccountButton()
                .expectPersonalAccountButtonLogout()
                .clickLogOutButton()
                .expectPersonalAccount()
                .checkElementIn();
        assertTrue(flag);
    }

    @After
    public void teardown() {
        //Удаление user
        userClient.deleteUser(accessToken);
        // Закрытие браузера
        driver.quit();
    }
}
