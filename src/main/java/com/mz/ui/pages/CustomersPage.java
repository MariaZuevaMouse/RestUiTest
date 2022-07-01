package com.mz.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CustomersPage extends BasePage {
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    @Step("проверка созданного пользователя в системе")
    public Page checkCustomerCreated() {
        return new Page(driver);
    }
}
