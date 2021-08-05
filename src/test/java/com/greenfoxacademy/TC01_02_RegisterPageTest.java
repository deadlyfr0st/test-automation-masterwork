package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

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
  @Description("Unsuccessful registration due to non-acceptance of privacy policy")
  public void registrationShouldFailWithoutCheckPrivacyCheckbox() {
    homePage.getLoginDropDown().click();
    homePage.getRegisterLink().click();
    registerPage.getUsernameField().sendKeys("TiborTest");
    registerPage.getEmailField().sendKeys("tibortest00+reg@gmail.com");
    registerPage.getNewPassword().sendKeys("Jelszo01");
    registerPage.getConfirmPassword().sendKeys("Jelszo01");
    registerPage.getRegisterButton().click();
    assertThat(registerPage.getFailMessage().getText()).isEqualTo("This field is required");
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
    registerPage.getUsernameField().sendKeys("TiborTest");
    registerPage.getEmailField().sendKeys("tibortest00+reg@gmail.com");
    registerPage.getNewPassword().sendKeys("Jelszo01");
    registerPage.getConfirmPassword().sendKeys("Jelszo01");
    registerPage.getPrivacyCheckbox().click();
    registerPage.getRegisterButton().click();
    assertThat(registerPage.getSuccessMessage().getText())
        .isEqualTo("Thank you for your registration. You may log in now.");
  }
}