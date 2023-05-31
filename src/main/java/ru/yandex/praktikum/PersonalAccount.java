package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccount {

    private final WebDriver driver;

    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }

    PageObject pageObject = new PageObject();

    public Registration clickRegistrationButton() {
        if (driver.findElement(pageObject.buttonRegistration).isDisplayed()) {
            driver.findElement(pageObject.buttonRegistration).click();
        }
        return new Registration(driver);
    }

    public PersonalAccount clickLogOutButton() {
        if (driver.findElement(pageObject.buttonLogOut).isDisplayed()) {
            driver.findElement(pageObject.buttonLogOut).click();
        }
        return this;
    }

    public MainPage clickConstructorButton() {
        if (driver.findElement(pageObject.buttonConstructor).isDisplayed()) {
            driver.findElement(pageObject.buttonConstructor).click();
        }
        return new MainPage(driver);
    }

    public ForgotPassword clickReanimatePasswordButton() {
        if (driver.findElement(pageObject.buttonReanimatePassword).isDisplayed()) {
            driver.findElement(pageObject.buttonReanimatePassword).click();
        }
        return new ForgotPassword(driver);
    }

    public PersonalAccount clickAndInputEmail(String email) {
        driver.findElement(pageObject.fieldEmail).click();
        driver.findElement(pageObject.fieldEmail).sendKeys(email);
        return this;
    }

    public PersonalAccount clickAndInputPassword(String password) {
        driver.findElement(pageObject.fieldPassword).click();
        driver.findElement(pageObject.fieldPassword).sendKeys(password);
        return this;
    }

    public MainPage clickButtonIn() {
        driver.findElement(pageObject.buttonIn).click();
        return new MainPage(driver);
    }

    public MainPage clickButtonLogo() {
        driver.findElement(pageObject.buttonLogoTip).click();
        return new MainPage(driver);
    }

    public boolean checkElementIn() {
        return driver.findElement(pageObject.elementIn).isDisplayed();
    }

    public PersonalAccount expectPersonalAccount() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(pageObject.elementIn, "Вход"));
        return this;
    }

    public PersonalAccount expectPersonalAccountButtonLogout() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(pageObject.buttonLogOut, "Выход"));
        return this;
    }

    public MainPage logInUser(String email, String password) {
        return new PersonalAccount(driver)
                .clickAndInputEmail(email)
                .clickAndInputPassword(password)
                .clickButtonIn();
    }
}
