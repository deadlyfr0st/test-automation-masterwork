package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC03_04_LoginTest extends BaseTest {
  HomePage homePage;

  @BeforeEach
  public void setup() {
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
  }

  @Test
  @DisplayName("TC_03-Login")
  @Feature("Login")
  @Description("Unsuccessful login with invalid username")
  public void loginShouldFailWithInvalidUsername() {
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("FakeUser1");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
    assertThat(homePage.getLoginErrorMessage().getText()).isEqualTo("Invalid username or password");
  }

  @Test
  @DisplayName("TC_04-Login")
  @Feature("Login")
  @Description("Successful login with the previously created user")
  public void shouldLoginWithTheCreatedUserInRegisterPageTest() {
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("FinalUser0");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
    assertThat(driver.getTitle()).isEqualTo("Community Wiki | Community Members HomePage");
    homePage.logout();
  }
}