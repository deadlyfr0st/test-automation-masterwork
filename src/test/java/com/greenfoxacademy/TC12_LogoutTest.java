package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC12_LogoutTest extends BaseTest {
  HomePage homePage;

  @BeforeEach
  public void setup() {
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
  }

  @Test
  @DisplayName("TC_12-Logout")
  @Feature("Logout")
  @Description("Successful logout after login with the previously created user")
  public void shouldSuccessfullyLogoutAfterLogin() {
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("TestUser0");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
    assertThat(driver.getTitle()).isEqualTo("Community Wiki | Community Members HomePage");
    homePage.logout();
    assertThat(driver.getTitle()).isEqualTo("Community Wiki | HomePage");
  }
}