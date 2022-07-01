package com.mz.ui.pages;

import com.mz.ui.entities.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends BasePage{

    @FindBy(css = "div.center > button:nth-child(3)")
    private WebElement customersBtn;

    @FindBy(css = "form > div:nth-child(1) > input")
    private WebElement fistNameField;

    @FindBy(css = "form > div:nth-child(2) > input")
    private WebElement secondNameField;

    @FindBy(css = "form > div:nth-child(3) > input")
    private WebElement postalCodeField;

    @FindBy(css = "form > button")
    private WebElement addCustomerBtn;
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Step("создание нового пользователя")
    public NewCustomerPage createNewCustomer(Customer customer) {
        typeFirstName(customer)
                .typeSecondName(customer)
                .typePostCode(customer)
                .clickAddCustomerBtn();
//                .closePopUp();
//        return new Page(driver);
        return this;
    }

    private Page clickAddCustomerBtn() {
        addCustomerBtn.click();
        return new Page(driver);
    }


    private NewCustomerPage typePostCode(Customer customer) {
        postalCodeField.sendKeys(String.valueOf(customer.getPostalCode()));
        return this;
    }

    private NewCustomerPage typeSecondName(Customer customer) {
        secondNameField.sendKeys(customer.getSecondName());
        return  this;
    }

    private NewCustomerPage typeFirstName(Customer customer) {
        fistNameField.sendKeys(customer.getFirstName());
        return this;
    }

    public CustomersPage goToCustomersPage() {
        customersBtn.click();
        return new CustomersPage(driver);
    }
}
