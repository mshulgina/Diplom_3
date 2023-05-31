package ru.yandex.praktikum;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {

    private final WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    PageObject pageObject = new PageObject();

    public Registration clickAndInputName(String name) {
        driver.findElement(pageObject.fieldName).click();
        driver.findElement(pageObject.fieldName).sendKeys(name);
        return this;
    }

    public Registration clickAndInputEmail(String email) {
        driver.findElement(pageObject.fieldEmailRegistration).click();
        driver.findElement(pageObject.fieldEmailRegistration).sendKeys(email);
        return this;
    }

    public Registration clickAndInputPassword(String password) {
        driver.findElement(pageObject.fieldPasswordRegistration).click();
        driver.findElement(pageObject.fieldPasswordRegistration).sendKeys(password);
        return this;
    }

    public PersonalAccount clickButtonRegistration() {
        driver.findElement(pageObject.buttonRegistrationPage).click();
        new WebDriverWait(driver, 100);
        return new PersonalAccount(driver);
    }

    public Registration clickButtonRegistrationError() {
        driver.findElement(pageObject.buttonRegistrationPage).click();
        return this;
    }

    public PersonalAccount clickButtonInOnPageRegistration() {
        driver.findElement(pageObject.buttonLogIn).click();
        return new PersonalAccount(driver);
    }

    public boolean checkErrorRegistrationExistUser() {
        return driver.findElement(pageObject.errorElementExistUser).isDisplayed();
    }

    public boolean checkErrorRegistrationIncorrectPassword() {
        return driver.findElement(pageObject.errorElementIncorrectPassword).isDisplayed();
    }

    public Registration scroll() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, Math.max" +
                "(document.documentElement.scrollHeight, document.body.scrollHeight, " +
                "document.documentElement.clientHeight));");
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(pageObject.errorElementExistUser, "Такой пользователь уже существует"));
        return this;
    }

    public PersonalAccount registrationUser(String name, String email, String password) {
        return new Registration(driver)
                .clickAndInputName(name)
                .clickAndInputEmail(email)
                .clickAndInputPassword(password)
                .clickButtonRegistration();
    }

    public Registration registrationUserError(String name, String email, String password) {
        return new Registration(driver)
                .clickAndInputName(name)
                .clickAndInputEmail(email)
                .clickAndInputPassword(password)
                .clickButtonRegistrationError();
    }
}
