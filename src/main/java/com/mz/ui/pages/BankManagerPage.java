package com.mz.ui.pages;

import com.mz.ui.entities.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerPage extends BasePage {
//    @FindBy(css = "div.center > button.btn.btn-lg.tab.btn-primary")
    @FindBy(css = "div.center > button:nth-child(1)")
    private WebElement addCustomerBtn;
    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    public NewCustomerPage clickAddCustomerBtn() {
        addCustomerBtn.click();
        return new NewCustomerPage(driver);
    }

    public BankManagerPage openCustomers() {

        return this;
    }

    public BankManagerPage removeCustomer(Customer customer) {
        return this;
    }

    private BankManagerPage closePopUp() {
        return this;
    }


}
