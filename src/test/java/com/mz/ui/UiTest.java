package com.mz.ui;

import com.github.javafaker.Faker;
import com.mz.ui.entities.Customer;
import com.mz.ui.pages.CustomersPage;
import com.mz.ui.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@Slf4j
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
        log.info("Test customer created '{}'", customer.toString());
    }

    @AfterAll
    static void afterAll() {

    }
    @AfterEach
    void cleanTestData() {
//        new LoginPage(driver)
//                .chooseBankManagerLogin()
//                .getBankManagerPage()
//                .openCustomers()
//                .removeCustomer(customer);
        new CustomersPage(driver)
                .removeCustomer(customer);

    }

    @BeforeEach
    void startBrowser() {
        driver.get(BASE_URL + "/career");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    void createNewCustomerTest() {
        new LoginPage(driver)
                .chooseBankManagerLogin()
                .getBankManagerPage()
                .clickAddCustomerBtn()
                .createNewCustomer(customer)
                .goToCustomersPage()
                .checkCustomerCreated(customer);
    }
}
