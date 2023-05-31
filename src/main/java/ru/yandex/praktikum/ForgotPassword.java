package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;

public class ForgotPassword {

    private final WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    PageObject pageObject = new PageObject();

    public PersonalAccount clickLogInButton() {
        if (driver.findElement(pageObject.buttonLogIn).isDisplayed()) {
            driver.findElement(pageObject.buttonLogIn).click();
        }
        return new PersonalAccount(driver);
    }
}
