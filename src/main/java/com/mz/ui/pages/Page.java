package com.mz.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class Page extends BasePage {
    @Getter
    private final LoginPage loginPage;
    @Getter
    private final BankManagerPage bankManagerPage;

    @Getter
    private final NewCustomerPage newCustomerPage;

    public Page(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        bankManagerPage = new BankManagerPage(driver);
        newCustomerPage = new NewCustomerPage(driver);
    }

    public void closePopUp() {
    }
}
