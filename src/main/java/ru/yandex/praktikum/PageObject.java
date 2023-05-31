package ru.yandex.praktikum;

import org.openqa.selenium.By;

public class PageObject {

    /////////////////////////////////////////////ЛОКАТОРЫ PersonalAccount

    //локатор поля ввода email
    final By fieldEmail = By.xpath(".//input[@name = 'name']");

    //локатор поля ввода password
    final By fieldPassword = By.xpath(".//input[@name = 'Пароль']");

    //локатор кнопки зарегистрироваться
    final By buttonRegistration = By.xpath
            (".//a[@class = 'Auth_link__1fOlj'][text() = 'Зарегистрироваться']");

    //локатор кнопки войти
    final By buttonIn = By.xpath
            (".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx " +
                    "button_button_size_medium__3zxIa'][text() = 'Войти']");

    //локатор элемента вход
    final By elementIn = By.xpath(".//h2[text() = 'Вход']");

    final By buttonConstructor = By.xpath(".//p[@class = " +
            "'AppHeader_header__linkText__3q_va ml-2'][text() = 'Конструктор']");

    //локатор кнопки восстановления пароля
    final By buttonReanimatePassword = By.xpath(".//a[@class = " +
            "'Auth_link__1fOlj'][text() = 'Восстановить пароль']");

    //локатор логотипа
    final By buttonLogoTip = By.xpath("html/body/div[@id='root']/div/header/nav/div/a");

    //локатор выхода из личного кабинета
    final By buttonLogOut = By.xpath(".//button[@class = " +
            "'Account_button__14Yp3 text text_type_main-medium text_color_inactive'][text() = 'Выход']");

    ////////////////////////////////////////////ЛОКАТОРЫ Registration

    //локатор поля ввода имени
    final By fieldName = By.xpath
            (".//fieldset[1]/div/div/input");

    //локатор поля ввода email Registration
    final By fieldEmailRegistration = By.xpath
            (".//fieldset[2]/div/div/input");

    //локатор поля ввода password Registration
    final By fieldPasswordRegistration = By.xpath
            (".//fieldset[3]/div/div/input");

    //локатор кнопки зарегистрироваться
    final By buttonRegistrationPage = By.xpath(".//button[@class = " +
            "'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //локатор кнопки Войти
    final By buttonLogIn = By.xpath(".//a[@class = 'Auth_link__1fOlj'][text() = 'Войти']");

    //локатор элемента существующего пользователя
    final By errorElementExistUser = By.xpath
            (".//p[@class = 'input__error text_type_main-default']" +
                    "[text() = 'Такой пользователь уже существует']");

    //локатор элемента некорректного пароля
    final By errorElementIncorrectPassword = By.xpath
            (".//p[@class = 'input__error text_type_main-default']" +
                    "[text() = 'Некорректный пароль']");

    ////////////////////////////////////////////ЛОКАТОРЫ MainPage

    //локатор кнопки личный кабинет
    final By buttonPersonalAccount = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2']" +
            "[text() = 'Личный Кабинет']");

    //локатор кнопки войти в аккаунт
    final By buttonGoInAccount = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']" +
            "[text() = 'Войти в аккаунт']");

    //локатор кнопки оформить заказ
    final By buttonCreateOrder = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']" +
            "[text() = 'Оформить заказ']");

    //локатор кнопки Соусы
    final By buttonSous = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Соусы']");

    //подсветка раздела Соусы
    final By buttonSousLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Соусы']");

    //локатор кнопки Булки
    final By buttonBulks = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Булки']");

    //подсветка раздела Булки
    final By buttonBulksLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Булки']");

    //локатор кнопки Начинки
    final By buttonFillings = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Начинки']");

    //подсветка раздела Начинки
    final By buttonFillingsLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Начинки']");

    //раздел Начинки без подсветки
    final By buttonFillingsWithoutLight = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Начинки']");

    //раздел Булки без подсветки
    final By buttonBulksWithoutLight = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Булки']");

    //раздел Соусы без подсветки
    final By buttonSousWithoutLight = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Соусы']");


}
