package com.mz.ui.pages;

import com.mz.ui.entities.Customer;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CustomersPage extends BasePage {
    @FindBy(css = "div > input")
    private WebElement searchCustomerField;

    @FindBy(css = "tbody > tr")
    private List<WebElement> customerList;

    @FindBy(css = "tbody > tr")
    private WebElement deleteCustomerBtn;
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    @Step("проверка созданного пользователя в системе")
    public Page checkCustomerCreated(Customer customer) {
        searchCustomerField.sendKeys(customer.getSecondName());
        log.info(customerList.toString());
        assertThat(customerList.size())
                .as("check customer '{}' was added", customer.toString())
                .isEqualTo(1);

        return new Page(driver);
    }

    public void removeCustomer(Customer customer) {
        searchCustomerField.sendKeys(customer.getSecondName());
        // not finished
    }
}
