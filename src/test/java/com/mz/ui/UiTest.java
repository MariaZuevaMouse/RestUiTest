package com.mz.ui;

import com.github.javafaker.Faker;
import com.mz.ui.entities.Customer;
import com.mz.ui.pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

//@TestInstance(Lifecycle.PER_CLASS)
public class UiTest extends UiBaseTest {
    static Customer customer;

    @BeforeAll
    static void beforeAll() {
        faker = new Faker();
        customer = new Customer()
                .withFirstName(faker.name().firstName())
                .withSecondName(faker.name().lastName())
                .withPostalCode(faker.hashCode());
        System.out.println(customer);
    }

    @AfterAll
    static void afterAll() {
        new LoginPage(driver)
                .chooseBankManagerLogin()
                .getBankManagerPage()
                .openCustomers()
                .removeCustomer(customer);

    }

    @BeforeEach
    void startBrowser() {
        driver.get(BASE_URL + "/career");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    void name() {
        new LoginPage(driver)
                .chooseBankManagerLogin()
                .getBankManagerPage()
                .clickAddCustomerBtn()
                .createNewCustomer().goToCustomersPage()
                .checkCustomerCreated();


    }
}
