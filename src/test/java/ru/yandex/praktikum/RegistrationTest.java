package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    private UserClient userClient;
    private MainPage page;
    private String name;
    private String email;
    private String password;
    private String passwordIncorrect;
    private int count = 10;
    private int countForPasswordIncorrect = 1;

    @Before
    public void startUp() {

        driver = new ChromeDriver();
        userClient = new UserClient();
        page = new MainPage(driver);
        name = RandomStringUtils.randomAlphabetic(count);
        email = RandomStringUtils.randomAlphabetic(count) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(count);
        passwordIncorrect = RandomStringUtils.randomAlphabetic(countForPasswordIncorrect);
    }

    @Test
    @DisplayName("Регистрация с помощью правильного пароля")
    public void registrationWithCorrectPasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .checkElementIn();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Регистрация с существующим пользователем")
    public void registrationWithExistUserTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickRegistrationButton()
                .registrationUserError(name, email, password)
                .scroll()
                .checkErrorRegistrationExistUser();
        assertTrue(flag);
    }

    @Test
    @DisplayName("Регистрация с неправильным паролем")
    public void registrationWithIncorrectPasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUserError(name, email, passwordIncorrect)
                .checkErrorRegistrationIncorrectPassword();
        assertTrue(flag);
    }

    @After
    public void teardown() {
        //получения токена для удаления на главной странице после логина
        page.open()
                .clickPersonalAccountButton()
                .logInUser(email, password);
        //Получение токена для удаления созданного пользователя
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        LocalStorage localStorage = webStorage.getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        userClient.deleteUser(accessToken);
        // Закрытие браузера
        driver.quit();
    }
}
