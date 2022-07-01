package com.mz.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @Getter
    private LoginPage loginPage;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button")
    private WebElement bankManagerLoginBtn;

    public Page chooseBankManagerLogin(){
        bankManagerLoginBtn.click();
        return new Page(driver);
    }

}
