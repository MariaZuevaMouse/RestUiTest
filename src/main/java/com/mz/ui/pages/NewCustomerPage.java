package com.mz.ui.pages;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends BasePage{

    @FindBy(css = "div.center > button:nth-child(3)")
    private WebElement customersBtn;
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Step("создание нового пользователя")
    public NewCustomerPage createNewCustomer() {
        typeFirstName()
                .typeSecondName()
                .typePostCode()
                .clickAddCustomerBtn()
                .closePopUp();
//        return new Page(driver);
        return this;
    }

    private Page clickAddCustomerBtn() {

        return new Page(driver);
    }


    private NewCustomerPage typePostCode() {
        return this;
    }

    private NewCustomerPage typeSecondName() {
        return  this;
    }

    private NewCustomerPage typeFirstName() {
        return this;
    }

    public CustomersPage goToCustomersPage() {
        customersBtn.click();
        return new CustomersPage(driver);
    }
}
