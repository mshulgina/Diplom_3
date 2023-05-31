package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    //драйвер для браузера
    private final WebDriver driver;

    private static final String URL_BURGER = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    PageObject pageObject = new PageObject();

    public MainPage open() {
        driver.get(URL_BURGER);
        return this;
    }

    public MainPage clickSousButton() {
        if (driver.findElement(pageObject.buttonSous).isDisplayed()) {
            new WebDriverWait(driver, 2000)
                    .until(ExpectedConditions.elementToBeClickable(pageObject.buttonSous));
            driver.findElement(pageObject.buttonSous).click();
        }
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonBulksWithoutLight));
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonFillingsWithoutLight));
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonSousLight));
        return this;
    }

    public MainPage clickBulksButton() {
        if (driver.findElement(pageObject.buttonBulks).isDisplayed()) {
            new WebDriverWait(driver, 2000)
                    .until(ExpectedConditions.elementToBeClickable(pageObject.buttonBulks));
            driver.findElement(pageObject.buttonBulks).click();
        }
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonSousWithoutLight));
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonFillingsWithoutLight));
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonBulksLight));
        return this;
    }

    public MainPage clickFillingsButton() {
        if (driver.findElement(pageObject.buttonFillings).isDisplayed()) {
            driver.findElement(pageObject.buttonFillings).click();
        }
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonBulksWithoutLight));
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonSousWithoutLight));
        new WebDriverWait(driver, 10000)
                .until(ExpectedConditions.elementToBeClickable(pageObject.buttonFillingsLight));
        return this;
    }

    public boolean checkButtonFillingsLight() {
        return driver.findElement(pageObject.buttonFillingsLight).isDisplayed();
    }

    public boolean checkButtonBulksLight() {
        return driver.findElement(pageObject.buttonBulksLight).isDisplayed();
    }

    public boolean checkButtonSousLight() {
        return driver.findElement(pageObject.buttonSousLight).isDisplayed();
    }

    public PersonalAccount clickPersonalAccountButton() {
        if (driver.findElement(pageObject.buttonPersonalAccount).isDisplayed()) {
            driver.findElement(pageObject.buttonPersonalAccount).click();
        }
        return new PersonalAccount(driver);
    }

    public PersonalAccount clickGoInAccountButton() {
        if (driver.findElement(pageObject.buttonGoInAccount).isDisplayed()) {
            driver.findElement(pageObject.buttonGoInAccount).click();
        }
        return new PersonalAccount(driver);
    }

    public boolean checkButtonCreateOrder() {
        return driver.findElement(pageObject.buttonCreateOrder).isDisplayed();
    }

    public boolean checkButtonLogInAccount() {
        return driver.findElement(pageObject.buttonGoInAccount).isDisplayed();
    }

    public MainPage expectMainPage() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(pageObject.buttonCreateOrder, "Оформить заказ"));
        return this;
    }

    public MainPage expectMainPageLogInAccount() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(pageObject.buttonGoInAccount, "Войти в аккаунт"));
        return this;
    }

}
