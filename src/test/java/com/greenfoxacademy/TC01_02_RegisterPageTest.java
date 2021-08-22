package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.*;

import com.greenfoxacademy.pages.HomePage;
import com.greenfoxacademy.pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC01_02_RegisterPageTest extends BaseTest {
  HomePage homePage;
  RegisterPage registerPage;

  @BeforeEach
  public void setup() {
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    registerPage = PageFactory.initElements(driver, RegisterPage.class);
  }

  @Test
  @DisplayName("TC_01-Reg")
  @Feature("Registration")
  @Description("Unsuccessful registration due to mismatched password")
  public void registrationShouldFailWithMismatchedPassword() {
    homePage.getLoginDropDown().click();
    homePage.getRegisterLink().click();
    registerPage.getUsernameField().sendKeys("SomeData");
    registerPage.getEmailField().sendKeys(email);
    registerPage.getNewPassword().sendKeys(password);
    registerPage.getConfirmPassword().sendKeys(password + "a");
    registerPage.getPrivacyCheckbox().click();
    registerPage.getRegisterButton().click();
    assertThat(registerPage.getFailMessage().getText()).isEqualTo("Passwords do not match");
    homePage.open();
  }

  @Test
  @DisplayName("TC_02-Reg")
  @Feature("Registration")
  @Description("Successfully registration after open and read the Privacy Policy")
  public void registrationShouldSuccess() {
    homePage.getLoginDropDown().click();
    homePage.getRegisterLink().click();
    registerPage.getPrivacyLink().click();
    assertThat(driver.getTitle()).isEqualTo("Community Wiki | Privacy Policy");
    driver.navigate().back();
    registerPage.getUsernameField().sendKeys(userName);
    registerPage.getEmailField().sendKeys(email);
    registerPage.getNewPassword().sendKeys(password);
    registerPage.getConfirmPassword().sendKeys(password);
    registerPage.getPrivacyCheckbox().click();
    registerPage.getRegisterButton().click();
    assertThat(registerPage.getSuccessMessage().getText())
        .isEqualTo("Thank you for your registration. You may log in now.");
  }
}